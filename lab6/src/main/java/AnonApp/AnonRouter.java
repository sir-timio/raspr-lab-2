package AnonApp;

import akka.actor.ActorRef;
import akka.http.javadsl.Http;
import akka.http.javadsl.server.Route;

import static akka.http.javadsl.server.Directives.route;

public class AnonRouter {
    private final ActorRef actorConfigKeeper;
    private final Http client;
    private final int TIMEOUT_SECONDS = 5;
    private static final ZERO_STRING = "0";

    public AnonRouter(ActorRef actorConfigKeeper, Http client) {
        this.actorConfigKeeper = actorConfigKeeper;
        this.client = client;
    }

    public Route createRoute() {
        return route(
                get(() ->
                        )

        )
    }

}
