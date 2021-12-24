package AkkaStream.Actor;

import AkkaStream.Message.MessageServers;
import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;

import java.util.ArrayList;

public class ActorConfigKeeper {
    private ArrayList<String> servers;

    @Override
    public AbstractActor.Receive createReceive() {
        return ReceiveBuilder.create()
                .match(MessageServers.class, )

    }
}
