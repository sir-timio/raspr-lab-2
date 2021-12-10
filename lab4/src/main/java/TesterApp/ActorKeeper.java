package TesterApp;

import akka.actor.AbstractActor;

import javax.swing.*;
import java.util.HashMap;

public class ActorKeeper extends AbstractActor {
    private Map<String, List<TestResult>> results = new HashMap<>();
    
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match()
    }
}
