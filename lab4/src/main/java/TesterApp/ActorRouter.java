package TesterApp;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.routing.ActorRefRoutee;
import akka.routing.RoundRobinRoutingLogic;
import akka.routing.Routee;
import akka.routing.Router;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ActorRouter extends AbstractActor {
    private static final int NUM_WORKERS = 3;

    private final ActorRef keeper;
    private final Router router;

    public ActorRouter() {
        keeper = getContext().actorOf(Props.create(ActorKeeper.class));
        getContext().watch(keeper);

        List<Routee> routees = new ArrayList<>();
        for (int i = 0; i < NUM_WORKERS; i++) {
            ActorRef tester = getContext().actorOf(Props.create(ActorTester.class));
            getContext().watch(tester);
            routees.add(new ActorRefRoutee(tester));
        }
        router = new Router(new RoundRobinRoutingLogic(), routees);
    }

    static class MessageTest {
        private final String packageId;
        private final String jsScript;
        private final String functionName;
        private final Test test;

        @JsonCreator
        public MessageTest(@JsonProperty("packageId") String packageID,
                           @JsonProperty("jsScript") String jsScript,
                           @JsonProperty("functionName") String functionName,
                           @JsonProperty("test") Test test) {
            this.packageId = packageID;
            this.functionName = functionName;
            this.jsScript = jsScript;
            this.test = test;
        }

        protected String getPackageId() {
            return packageId;
        }

        protected String getJsScript() {
            return jsScript;
        }

        protected String getFunctionName() {
            return functionName;
        }

        protected Test getTest() {
            return test;
        }

    }
}
