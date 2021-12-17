package TesterApp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class MessageReturnResults {
    private static String packageId;
    private static ArrayList<TestResult> results;

    @JsonCreator
    public MessageReturnResults(
            @JsonProperty("packageId") String packageId,
            @JsonProperty("results") ArrayList<TestResult> results) {
        this.packageId = packageId;
        this.results = results;
        System.out.println(results);
    }

    public String getPackageId() {
        return packageId;
    }

    public ArrayList<TestResult> getResults() {
        return results;
    }
}
