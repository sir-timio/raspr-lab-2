package AnonApp;

import AnonApp.Message.MessageServers;
import akka.actor.ActorRef;
import akka.pattern.Patterns;
import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NodeWatcher implements Watcher {
    public static String ZOO_CONNECT_STRING = "127.0.0.1:2181";
    public static int SESSION_TIMEOUT = 3000;
    private ZooKeeper zoo;
    private final ActorRef actorConfigKeeper;

    public NodeWatcher(ActorRef actorConfigKeeper) throws IOException, InterruptedException, KeeperException {
        this.actorConfigKeeper = actorConfigKeeper;
    }

    public void setZoo(ZooKeeper zoo) {
        this.zoo = zoo;
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        try {
            List<String> servers = zoo.getChildren("/servers", this);
            ArrayList<String> serversForAkka = new ArrayList<>();
            for (String server : servers) {
                byte[] data = zoo.getData("/servers/" + server, false, null);
                serversForAkka.add(new String(data));
            }
            System.out.println(serversForAkka.size());
            actorConfigKeeper.tell(new MessageServers(serversForAkka), ActorRef.noSender());
        } catch (KeeperException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}
