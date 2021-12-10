package TesterApp;
import akka.actor.ActorSystem;
import akka.http.javadsl.Http;
import akka.http.javadsl.server.AllDirectives;
import akka.stream.ActorMaterializer;

public class TestApp extends AllDirectives {
    private static final String ACTOR_SYSTEM_NAME = "JS_TESTER";

    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create(ACTOR_SYSTEM_NAME);

        Http http = Http.get(actorSystem);
        ActorMaterializer actorMaterializer = ActorMaterializer.create(ActorSystem);

        TestApp instance = new TestApp()
    }
}
