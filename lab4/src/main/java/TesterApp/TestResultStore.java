package TesterApp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestResultStore {
    private final String packageId;
    private final String status;
    private final String testName;
    private final String expectedResult;
    private final String receivedResult;
    private final TestResultJson result;


    public TestResultStore(@JsonProperty("packageId") String packageId,
                           @JsonProperty("status") String status,
                           @JsonProperty("testName") String testName,
                           @JsonProperty("expectedResult") String expectedResult,
                           @JsonProperty("receivedResult") String evaluatedResult) {
        this.packageId = packageId;
        this.result = new TestResultJson(
                packageId,
                status,
                testName,
                expectedResult,
                evaluatedResult,
        );
        this.status = status;
        this.testName = testName;
        this.expectedResult = expectedResult;
        this.receivedResult = evaluatedResult;
    }

    public String getPackageId() {
        return packageId;
    }

    public String getResult() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "Test{" +
                "packageId: " + packageId + '\n' +
                "status: " + status + '\n' +
                "testName: " + testName + '\n' +
                "expectedResult: " + expectedResult + '\n' +
                "receivedResult: " + receivedResult + '\n';
    }
}
