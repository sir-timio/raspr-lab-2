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

    public ZooWatcher(ActorRef actorConfigKeeper, ZooKeeper zooKeeper) throws Exception {
        this.actorConfigKeeper = actorConfigKeeper;
        this.zooKeeper = zooKeeper;

        
    }

}

