package AkkaStream.Actor;

import AkkaStream.Message.MessageGetRandom;
import AkkaStream.Message.MessageServers;
import akka.actor.AbstractActor;
import akka.actor.Actor;
import akka.japi.pf.ReceiveBuilder;

import java.util.ArrayList;
import java.util.Random;

public class ActorConfigKeeper extends AbstractActor{
    private ArrayList<String> servers;
    private Random rand = new Random();

    @Override
    public Receive createReceive() {
        return ReceiveBuilder.create()
                .match(MessageGetRandom.class,
                        msg -> sender()
                                .tell(
                                        servers.get(rand.nextInt(servers.size())),
                                        Actor.noSender()
                                )
                )
                .match(MessageServers.class,
                        msg -> msg.getServers())

    }
}
