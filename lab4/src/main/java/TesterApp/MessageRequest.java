package TesterApp;

public class MessageRequest {
    private final String packageID;

    public MessageRequest(String packageID) {
        this.packageID = packageID;
    }

    public String getPackageID() {
        return packageID;
    }
}
