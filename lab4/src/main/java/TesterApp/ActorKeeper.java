package TesterApp;

import akka.actor.AbstractActor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ActorKeeper extends AbstractActor {
    private Map<String, ArrayList<TestResult>> results = new HashMap<>();

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(
                        TestResultStore.class,
                        this::storeResult
                )
                .match(
                        MessageReturnResults.class,
                        request -> sender().tell(
                                new MessageReturnResults(
                                        request.getPackageID(),
                                        results.get(request.getPackageID())
                                ),
                                self()
                        )
                )
                .build();
    }

    public void storeResult(TestResultStore m) {
        String packageId = m.getPackageId();
        if  (!results.containsKey(packageId)) {
            results.put(m.getPackageId(), new ArrayList<>());
        }
        results.get(packageId).add(m.getResult());
    }
}
