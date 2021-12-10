package TesterApp;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.routing.Router;

public class ActorRouter extends AbstractActor {
    private static final int NUM_WORKERS = 3;

    private final ActorRef keeper;
    private final Router router;

    {
        keeper = getContext().actorOf()
    }
}
