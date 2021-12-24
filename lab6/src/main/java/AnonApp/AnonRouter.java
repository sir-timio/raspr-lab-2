package AnonApp;

import akka.actor.ActorRef;
import akka.http.javadsl.Http;

public class AnonRouter {
    private final ActorRef actorConfigKeeper;
    private final Http client;
    private final int TIMEOUT_SECONDS = 5;

    public AnonRouter(ActorRef actorConfigKeeper, Http client) {
        this.actorConfigKeeper = actorConfigKeeper;
        this.client = client;
    }

}
