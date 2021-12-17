package TesterApp;

public class TestResult {
    private final String packageId;
    private final String status;
    private final String testName;
    private final String expectedResult;
    private final String evaluatedResult;


    public TestResult(String packageId, String status, String testName,
                      String expectedResult, String evaluatedResult) {
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
