package AkkaStream;

import akka.NotUsed;
import akka.actor.Actor;
import akka.actor.ActorRef;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.model.Query;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;

public class HttpFlow {
    public static final int TIMEOUT_SECONDS = 5;
    public static final int NUM_OF_WORKERS = 3;
    private static final String QUERY_URL = "testUrl";
    private static final String QUERY_COUNT = "count";

    public static Flow<HttpRequest, HttpResponse, NotUsed> httpFlow(
            ActorMaterializer materializer, ActorRef actorRef
    ) {
        return Flow.of(HttpRequest.class)
                .map(request -> {
                    Query query = request.getUri().query();
                    String url = query.get(QUERY_URL).get();
                    int count = Integer.parseInt(query.get(QUERY_COUNT).get());
                    return new Pair<>(url, count);
                })
    }
}
