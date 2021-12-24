package AkkaStream;

import java.io.IOException;
import java.util.concurrent.CompletionStage;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.actor.ActorRef;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;


public class AkkaMain {

    public static void main(String[] args) throws IOException {
        System.out.println("start!");
        ActorSystem system = ActorSystem.create("routes");
        ActorRef actor = system.actorOf(Props.create(ActorCache.class));

        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);
        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow = flowHttpRequest(materializer, actor);
        final CompletionStage<ServerBinding> binding = http.bindAndHandle(
                routeFlow,
                ConnectHttp.toHost("localhost", 8080),
                materializer
        );
        System.out.println("Server online at http://localhost:" + PORT + "/\nPress RETURN to stop...");
        System.in.read();
        binding
                .thenCompose(ServerBinding::unbind)
                .thenAccept(unbound -> system.terminate());
    }


}
