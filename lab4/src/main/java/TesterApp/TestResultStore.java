package TesterApp;

public class TestResultStore {
    private final String packageId;
    private final String status;
    private final String testName;
    private final String expectedResult;
    private final String receivedResult;
    public TestResultStore(String packageId, String status, String testName,
                           String expectedResult, String evaluatedResult) {
        this.packageId = packageId;
        this.status = status;
        this.testName = testName;
        this.expectedResult = expectedResult;
        this.receivedResult = evaluatedResult;
    }

    public String getPackageId() {
        return packageId;
    }

    public TestResultJson getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "packageId:" + packageId + '\n' +
                result;
    }
}
