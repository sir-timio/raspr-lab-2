package AnonApp;
import akka.actor.ActorRef;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;

import java.nio.charset.StandardCharsets;

public class ZooWatcher implements Watcher {
    public static final String ZOO_HOST = "127.0.0.1";
    public static final String ZOO_PORT = "8000";
    private static final int SESSION_TIMEOUT = 5000;
    private static final String SERVERS_PATH = "/servers";

    private final ZooKeeper zooKeeper;
    private final ActorRef actorConfigKeeper;

    public ZooWatcher(ActorRef actorConfigKeeper, String host, String port) throws Exception {
        this.zooKeeper = new ZooKeeper(
                ZOO_HOST + ": " + ZOO_PORT,
                SESSION_TIMEOUT,
                this
        );
        this.actorConfigKeeper = actorConfigKeeper

        String akkaUrl = "http://" + host + ":" + port;
        zooKeeper.create(
                SERVERS_PATH,
                akkaUrl.getBytes(StandardCharsets.UTF_8),
                ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL_SEQUENTIAL
        );
    }

}

