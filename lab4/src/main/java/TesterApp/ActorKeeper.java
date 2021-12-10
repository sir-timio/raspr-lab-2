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
        return receiveBuilder()
                .match()
    }
}
