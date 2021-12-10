package TesterApp;

import akka.actor.AbstractActor;

import java.util.ArrayList;

public class ActorTester extends AbstractActor {
    private static final String EVAL_ENGINE = "nashorn";
    private static final String PASSED_STATUS = "OK";
    private static final String FAILING_STATUS = "FAILED";
    private static final String ERROR_STATUS = "ERROR";


    private String evalJS(String jscript, String functionName, ArrayList<Object> params) throws 

}
