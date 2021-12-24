package AnonApp;
import AnonApp.Message.MessageServers;
import akka.actor.ActorRef;
import com.sun.net.httpserver.HttpServer;
import org.apache.zookeeper.*;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ZooWatcher implements Watcher {
    public static final String ZOO_HOST = "127.0.0.1";
    public static final String ZOO_PORT = "8000";
    private static final int SESSION_TIMEOUT = 5000;
    private static final String SERVERS_PATH = "/servers";

    private ZooKeeper zooKeeper;
    private final ActorRef actorConfigKeeper;

    public ZooWatcher(ActorRef actorConfigKeeper) throws Exception {
        this.actorConfigKeeper = actorConfigKeeper;
    }

    public void sendServers() throws Exception {
        ArrayList<String> servers = new ArrayList<>();
        for (String s : zooKeeper.getChildren(SERVERS_PATH, this)) {
            servers.add(new String(zooKeeper.getData(SERVERS_PATH + "/" + s, false, null)));
        }
        actorConfigKeeper.tell(new MessageServers(servers), ActorRef.noSender());
    }

    public void setZooKeeper(ZooKeeper zooKeeper){
        this.zooKeeper = zooKeeper;
    }
    @Override
    public void process(WatchedEvent watchedEvent) {
        List<String> servers;
        try {
            zooKeeper.getChildren(SERVERS_PATH, this);
            sendServers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

