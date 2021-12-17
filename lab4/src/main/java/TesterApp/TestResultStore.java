package TesterApp;

public class TestResultStore {
    private final String packageId;
    private final String status;
    private final String testName;
    private final String expectedResult;
    private final String evaluatedResult;
    public TestResultStore(String packageId, String status, String testName,
                           String expectedResult, String evaluatedResult) {
        this.packageId = packageId;
        this.result = new TestResultJson(packageId, status,
                testName, expectedResult, evaluatedResult);
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
