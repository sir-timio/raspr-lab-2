package TesterApp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class MessageTestResults {
    private final String packageId;
    public final ArrayList<TestResult> results;

    @JsonCreator

    public MessageReturnResults(
            @JsonProperty("packageId") String packageId,
            @JsonProperty("results") ArrayList<TestResult> results) {
        this.packageId = packageId;
        this.results = results;
    }


}
