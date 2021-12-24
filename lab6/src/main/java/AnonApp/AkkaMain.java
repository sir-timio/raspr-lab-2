package AnonApp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CompletionStage;

import AnonApp.Actor.ActorConfigKeeper;
import akka.actor.ActorSystem;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.stream.ActorMaterializer;
import com.sun.net.httpserver.HttpServer;
import org.apache.zookeeper.ZooKeeper;


public class AkkaMain {

    private static final String PORT = "2181";
    private static final String HOST = "127.0.0.1";
    private static final int SESSION_TIMEOUT = 5000;

    public static void main(String[] args) throws IOException {
        System.out.println("start!");
        ActorSystem system = ActorSystem.create("routes");
        ActorRef actorConfigKeeper = system.actorOf(Props.create(ActorConfigKeeper.class));

        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);
        ZooKeeper zooKeeper = null;

        try {
            zooKeeper = new ZooKeeper(
                    HOST + ":" + PORT,
                    SESSION_TIMEOUT,
                    null
            );
            new ZooWatcher(actorConfigKeeper, zooKeeper);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        }

        ArrayList<CompletionStage<ServerBinding>> bindings = new ArrayList<>();

        System.out.println("Servers online at\n");

        for (String port: args) {
            try {
                HttpServer server = new HttpServer(http, actorConfigKeeper, zooKeeper, port)
            }
        }

        final CompletionStage<ServerBinding> binding = http.bindAndHandle(
                ConnectHttp.toHost("localhost", 8080),
                materializer
        );

    }


}
