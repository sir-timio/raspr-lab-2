package TesterApp;

import akka.actor.AbstractActor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ActorKeeper extends AbstractActor {
    private Map<String, ArrayList<TestResult>> results = new HashMap<>();

    @Override
    public Receive createReceive() {
        return null;
        return receiveBuilder()
                .match(
                        TestResultStore.class,
                        this::storeResult
                )
                .match()
    }

    public void storeResult(TestResultStore m) {
        String packageId = m.getPackageId();
        if (results.containsKey(packageId)) {
            results.get(packageId).add(m.getResults())
        }

    }
}
