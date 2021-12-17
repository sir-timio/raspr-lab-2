package TesterApp;

public class MessageRequest {
    private final String packageID;

    public MessageTestsPackageResult(String packageID) {
        this.packageID = packageID;
    }

    public String getPackageID() {
        return packageID;
    }
}
