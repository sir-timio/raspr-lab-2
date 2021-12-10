package TesterApp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Test {
    @JsonProperty
    private final String testName;
    private final Object[] params;
    private final String expectedResult;

    public Test() {

    }
}
