package TesterApp;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Test {
    @JsonProperty
    private final String testName;

    @JsonProperty
    private final ArrayList<Object> params;

    @JsonProperty
    private final String expectedResult;

    public Test(String testName, ) {

    }
}
