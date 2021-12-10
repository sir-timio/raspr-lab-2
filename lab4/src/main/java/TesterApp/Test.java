package TesterApp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Test {
    @JsonProperty
    private final String testName;

    @JsonProperty
    private final Object[] params;

    @JsonProperty
    private final String expectedResult;

    public Test(String testName, ) {

    }
}
