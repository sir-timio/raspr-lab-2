package AnonApp;

import akka.actor.ActorRef;
import akka.http.javadsl.Http;
import akka.http.javadsl.server.Route;

import static akka.http.javadsl.server.Directives.route;

public class AnonRouter {
    private final ActorRef actorConfigKeeper;
    private final Http client;

    private static final int TIMEOUT_SECONDS = 5;
    private static final String ZERO_COUNT = "0";

    private static final String QUERY_URL = "testUrl";
    private static final String QUERY_COUNT = "count";
    private static final String PATH = "";

    public AnonRouter(ActorRef actorConfigKeeper, Http client) {
        this.actorConfigKeeper = actorConfigKeeper;
        this.client = client;
    }

    public Route createRoute() {
        return route(
                path("", ())
    }

}
