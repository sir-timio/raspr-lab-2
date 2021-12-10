package TesterApp;
import akka.NotUsed;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.http.javadsl.Http;
import akka.http.javadsl.marshallers.jackson.Jackson;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;
import akka.pattern.Patterns;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;

import java.util.concurrent.Future;

public class TestApp extends AllDirectives {
    private static final String ACTOR_SYSTEM_NAME = "JS_TESTER";

    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create(ACTOR_SYSTEM_NAME);

        Http http = Http.get(actorSystem);
        ActorMaterializer actorMaterializer = ActorMaterializer.create(ActorSystem);

        TestApp app = new TestApp();
        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow;
    }

    private Route createRoute(ActorRef actorRouter) {
        return route(
                path("test", () ->
                        route(
                                post(
                                        () -> entity(Jackson.unmarshaller(MessageTestsPackage.class), m -> {
                                            actorRouter.tell(m, ActorRef.noSender());
                                            return complete("Start testing");
                                        })
                                )
                        )
                ),
                path("result", () ->
                        route(
                                get(
                                        () -> parameter("packageId", (id) -> {
                                            Future<Object> result = Patterns.ask(
                                                    actorRouter,
                                                    new MessageTestsPackageResult(id),

                                            )


                                        })
                                )
                        )
                        )
        )
    }
}
