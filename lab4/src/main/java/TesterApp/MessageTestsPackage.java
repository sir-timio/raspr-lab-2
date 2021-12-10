package TesterApp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MessageTestsPackage {
    private final String packageId;
    private final String jsScript;
    private final String functionName;
    private final List<Test> tests;

    @JsonCreator
    public MessageTestsPackage(@JsonProperty("packageId") String packageID,
                               @JsonProperty("jsScript") String jsScript,
                               @JsonProperty("functionName") String functionName,
                               @JsonProperty("tests") List<Test> tests) {
        this.packageId = packageID;
        this.jsScript = jsScript;
        this.functionName = functionName;
        this.tests = tests;
    }

    public List<Test> getTests() {
        return tests;
    }

    public String getPackageId() {
        return getPackageId();
    }

    public String getJsScript() {
        return jsScript;
    }

    public String get

    public String getFunctionName() {
        return functionName;
    }
}
