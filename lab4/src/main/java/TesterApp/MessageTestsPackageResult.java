package TesterApp;

public class MessageTestsPackageResult {
    private final String packageID;
    private final TestResult result;
    public MessageTestsPackageResult(String packageID, TestResult result) {
        this.packageID = packageID;
        this.result = result
    }

    public String getPackageID() {
        return packageID;
    }
}
