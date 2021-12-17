package TesterApp;

public class MessageTestsPackageResult {
    private final String packageID;
    public MessageTestsPackageResult(String packageID, TestResult result) {
        this.packageID = packageID;
    }

    public String getPackageID() {
        return packageID;
    }
}
