package TesterApp;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.routing.Routee;
import akka.routing.Router;

import java.util.ArrayList;
import java.util.List;

public class ActorRouter extends AbstractActor {
    private static final int NUM_WORKERS = 3;

    private final ActorRef keeper;
    private final Router router;

    public ActorRouter() {
        keeper = getContext().actorOf(Props.create(ActorKeeper.class));
        getContext().watch(keeper);

        List<Routee> routees = new ArrayList<>();
        for (int i = 0; i < NUM_WORKERS; i++) {
            ActorRef 
        }


    }
}
