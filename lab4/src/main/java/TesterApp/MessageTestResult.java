package TesterApp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class MessageTestResult {
    private static String packageId;
    private static ArrayList<TestResult> results;

    @JsonCreator
    public MessageTestResult(
            @JsonProperty("packageId") String packageId,
            @JsonProperty("results") ArrayList<TestResult> results) {
        this.packageId = packageId;
        this.results = results;
    }

    public static String getPackageId() {
        return packageId;
    }

    public static ArrayList<TestResult> getResults() {
        return results;
    }
}
