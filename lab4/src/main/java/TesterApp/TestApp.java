package TesterApp;
import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.http.javadsl.Http;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.AllDirectives;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;

public class TestApp extends AllDirectives {
    private static final String ACTOR_SYSTEM_NAME = "JS_TESTER";

    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create(ACTOR_SYSTEM_NAME);

        Http http = Http.get(actorSystem);
        ActorMaterializer actorMaterializer = ActorMaterializer.create(ActorSystem);

        TestApp app = new TestApp();
        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow =
                
    }
}
