package TesterApp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TestResultJson {
    private final String packageId;
    private final String status;
    private final String testName;
    private final String expectedResult;
    private final String evaluatedResult;

    @JsonCreator
    public TestResultJson(@JsonProperty("packageId") String packageId,
                          @JsonProperty("status") String status,
                          @JsonProperty("testName") String testName,
                          @JsonProperty("expectedResult") String expectedResult,
                          @JsonProperty("receivedResult") String evaluatedResult) {
        this.packageId = packageId;
        this.status = status;
        this.testName = testName;
        this.expectedResult = expectedResult;
        this.evaluatedResult = evaluatedResult;
    }

    @Override
    public String toString() {
        return "TestResult{" +
                "packageId='" + packageId + '\'' +
                ", status='" + status + '\'' +
                ", testName='" + testName + '\'' +
                ", expectedResult='" + expectedResult + '\'' +
                ", evaluatedResult='" + evaluatedResult + '\'' +
                '}';
    }
}
