package TesterApp;

import akka.actor.AbstractActor;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class ActorKeeper extends AbstractActor {
    private Map<String, List<TestResultJson>> results = new HashMap<>();

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(
                        TestResultStore.class,
                        this::storeResult
                )
                .match(
                        MessageRequestJson.class,
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
            List<>
            results.put(m.getPackageId(), new List<>());
        }
        results.get(packageId).add(m.getResult());
        System.out.println(results.get(packageId));
    }
}
