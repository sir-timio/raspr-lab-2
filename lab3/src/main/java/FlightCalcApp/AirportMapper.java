package FlighCalcApp;

import java.io.Serializable;

public class AirporMapper implements Serializable {

    private static final String DELIMETER = ",";
    private static final int AIRPORT_CODE_COLUMN = 0;
    private static final int NAME_COLUMN = 1;
    private static final int DATA_TYPE = 0;
    private static final String REDUNTANT_QUOT = "\"";

    protected String removeQuots(String s){
        return s.replace(REDUNTANT_QUOT, "");
    }

    public static Tuple2<Integer, String> tuple2Mapper(String row) {
        row = removeQuots
    }

}