package TesterApp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class MessageResponseJson {
    private static String packageId;
    private static ArrayList<TestResultJson> results;

    @JsonCreator
    public MessageResponseJson(
            @JsonProperty("packageId") String packageId,
            @JsonProperty("results") ArrayList<String> results) {
        this.packageId = packageId;
        this.results = results;
    }

    public String getPackageId() {
        return packageId;
    }

    public ArrayList<String > getResults() {
        return results;
    }
}
