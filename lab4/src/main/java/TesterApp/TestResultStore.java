package TesterApp;

public class TestResultStore {
    private final String packageId;
    private final TestResult result;

    public TestResultStore(String packageId, String status, String testName,
                           String expectedResult, String receivedResult) {
        this.packageId = packageId;
        
    }
}
