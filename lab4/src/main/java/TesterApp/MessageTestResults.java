package TesterApp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class MessageTestResults {
    public static final String packageId;
    public static final ArrayList<TestResult> results;

    @JsonCreator
     MessageReturnResults(
            @JsonProperty("packageId") String packageId,
            @JsonProperty("results") ArrayList<TestResult> results) {
        this.packageId = packageId;
        this.results = results;
    }


}
