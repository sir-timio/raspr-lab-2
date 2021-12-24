package AkkaStream;

import java.io.IOException;

import AkkaStream.Actor.ActorKeeper;
import akka.actor.ActorSystem;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.stream.ActorMaterializer;


public class AkkaMain {

    public static void main(String[] args) throws IOException {
        System.out.println("start!");
        ActorSystem system = ActorSystem.create("routes");
        ActorRef actor = system.actorOf(Props.create(ActorKeeper.class));

        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);
//        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow = flowHttpRequest(materializer, actor);
//        final CompletionStage<ServerBinding> binding = http.bindAndHandle(
////                routelow,
//                ConnectHttp.toHost("localhost", 8080),
//                materializer
//        );
        System.out.println("Server online at http://localhost:8080/\nPress RETURN to stop...");
        System.in.read();
        binding
                .thenCompose(ServerBinding::unbind)
                .thenAccept(unbound -> system.terminate());
    }


}
