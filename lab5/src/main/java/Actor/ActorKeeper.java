package Actor;

import Message.MessageRequest;
import akka.actor.AbstractActor;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ActorKeeper extends AbstractActor {
    private Map<String, Long> results = new HashMap<>();

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(
                        MessageRequest.class,
                        message -> sender().tell(
                                Optional.ofNullable(results.get(message.getUrl())),
                                self())
                )
                .match(

                )
    }
}
