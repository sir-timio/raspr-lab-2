package TesterApp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class MessageResponseJson {
    private final String packageId;
    private final List<TestResultJson> results;

    @JsonCreator
    public MessageResponseJson(
            @JsonProperty("packageId") String packageId,
            @JsonProperty("results") List<TestResultJson> results) {
        this.packageId = packageId;
        this.results = results;
    }

    public String getPackageId() {
        return packageId;
    }

    public ArrayList<TestResultJson > getResults() {
        return results;
    }
}
