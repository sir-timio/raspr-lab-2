package TesterApp;

import akka.actor.AbstractActor;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ActorKeeper extends AbstractActor {
    private Map<String, ArrayList<TestResult>> results = new HashMap<>();

    @Override
    public Receive createReceive() {
        return null;
//        return receiveBuilder()
//                .match(
//                        MessageTestResult.class,
//                        this::storeResult
//                )
//                .match()
    }

    public void storeResult(MessageTestResult m) {
        String packageId = m.getPackageId();
        if (results.containsKey(packageId)) {
            results.get(packageId).add(m.getResults())
        }

    }
}
