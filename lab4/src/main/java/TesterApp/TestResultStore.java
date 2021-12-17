package TesterApp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestResultStore {
    private final String packageId;

    private final TestResultJson result;


    public TestResultStore(String packageId,
                           String status,
                           String testName,
                           String expectedResult,
                           String evaluatedResult) {
        this.packageId = packageId;
        this.result = new TestResultJson(
                packageId,
                status,
                testName,
                expectedResult,
                evaluatedResult
        );
    }

    public String getPackageId() {
        return packageId;
    }

    public TestResultJson getResult() {
        return this.result;
    }

    @Override
    public String toString() {
        return "packageId: " + packageId + '\n' + result;
    }
}
