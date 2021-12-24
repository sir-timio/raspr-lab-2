package AkkaStream;

import akka.NotUsed;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;

public class HttpFlow {
    public static final TIMEOUT = 5;
    public static final NUM_OF_WORKERS = 3;

    public static Flow<HttpRequest, HttpResponse, NotUsed
}
