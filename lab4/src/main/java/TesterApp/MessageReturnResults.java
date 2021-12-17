package TesterApp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class MessageReturnResults {
    private static String packageId;
    private static List<String> results;

    @JsonCreator
    public MessageReturnResults(
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
