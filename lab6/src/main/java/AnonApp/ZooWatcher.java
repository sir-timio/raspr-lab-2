package AnonApp;
import AnonApp.Message.MessageServers;
import akka.actor.ActorRef;
import org.apache.zookeeper.*;

import java.util.ArrayList;

public class ZooWatcher implements Watcher {
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
        try {
            sendServers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

