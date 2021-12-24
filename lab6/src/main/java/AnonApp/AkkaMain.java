package AnonApp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.concurrent.CompletionStage;

import AnonApp.Actor.ActorConfigKeeper;
import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import com.sun.net.httpserver.HttpServer;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;


public class AkkaMain {

    private static final String HOST = "127.0.0.1";
    private static final int SESSION_TIMEOUT = 5000;

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: AnonApp <port>");
            return;
        }
        Integer port = Integer.parseInt(args[0]);

        ActorSystem system = ActorSystem.create();
        ActorRef actorConfigKeeper = system.actorOf(Props.create(ActorConfigKeeper.class));

        ZooWatcher watcher = new ZooWatcher(actorConfigKeeper);

        ZooKeeper zooKeeper = null;
        try {
            zooKeeper = new ZooKeeper(HOST,SESSION_TIMEOUT, watcher);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        String url = HOST + ":" + port.toString();
        watcher.setZooKeeper(zooKeeper);
        try {
            zooKeeper.create("/servers/s",
                    url.getBytes(),
                    ZooDefs.Ids.OPEN_ACL_UNSAFE,
                    CreateMode.EPHEMERAL_SEQUENTIAL);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);
        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow = new AnonRouter(actorConfigKeeper, http)
                .createRoute().flow(system, materializer);
        final CompletionStage<ServerBinding> binding = http.bindAndHandle(routeFlow,
                ConnectHttp.toHost(HOST, port), materializer);
        http.bindAndHandle()

    }
}
