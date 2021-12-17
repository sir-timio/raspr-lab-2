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
