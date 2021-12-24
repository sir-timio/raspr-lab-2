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
    public static final TIMEOUT = 5;
    public static final NUM_OF_WORKERS = 3;

    public static Flow<HttpRequest, HttpResponse, NotUsed> httpFlow(
            ActorMaterializer materializer, ActorRef actorRef
    ) {
        return Flow.of(HttpRequest.class)
                .map(request -> {
                    Query query request.getUri().query();
                    return new P
                })
    }
}
