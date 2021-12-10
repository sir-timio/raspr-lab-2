package TesterApp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MessageTestResult {
    private static String packageId;
    private static List<TestResult> results;

    @JsonCreator
    public MessageTestResult(
            @JsonProperty("packageId") String packageId,
            @JsonProperty("results") List<TestResult> results) {
        this.packageId = packageId;
        this.results = results;
    }

    public String getPackageId() {
        return packageId;
    }

    public TestResult getResults() {
        return results;
    }
}
