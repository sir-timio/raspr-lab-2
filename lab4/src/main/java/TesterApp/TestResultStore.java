package TesterApp;

public class TestResultStore {
    private final String packageId;
    private final TestResult result;

    public TestResultStore(String packageId, String status, String testName,
                           String expectedResult, String evaluatedResult) {
        this.packageId = packageId;
        this.result = new TestResult(packageId, status, testName, expectedResult, evaluatedResult);
    }

    public String getPackageId() {
        return packageId;
    }

    public TestResult getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "TestResultStore{" +
                "packageId:" + packageId + '\n' +
                result
    }
}
