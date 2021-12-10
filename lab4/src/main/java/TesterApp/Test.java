package TesterApp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class Test {
    @JsonProperty
    private final String testName;

    @JsonProperty
    private final ArrayList<Object> params;

    @JsonProperty
    private final String expectedResult;

    @JsonCreator
    public Test(@JsonProperty("testName") String testName,
                @JsonProperty("params") ArrayList<Object> params,
                @JsonProperty("expectedResult") String expectedResult) {
        this.testName = testName;
        this.params = params;
        this.expectedResult = expectedResult;

    }

    public String getTestName() {
        return testName;
    }

    public ArrayList<Object> getParams() {
        return params;
    }

    public String getExpectedResult() {
        return expectedResult;
    }
}
