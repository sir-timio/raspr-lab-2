package FlightCalcApp;

import java.io.Serializable;
import scala.Tuple2;

public class AirpotMapper implements Serializable {

    private static final String DELIMETER = ",";
    private static final int AIRPORT_CODE_COLUMN = 0;
    private static final int NAME_COLUMN = 1;
    private static final int DATA_TYPE = 0;
    private static final String REDUNTANT_QUOT = "\"";

    protected static String removeQuots(String s){
        return s.replace(REDUNTANT_QUOT, "");
    }

    public static Tuple2<Integer, String> tuple2Mapper(String rowStr) {
        rowStr = removeQuots(rowStr);
        String[] row = rowStr.split(DELIMETER);
        int code = Integer.parseInt(row[AIRPORT_CODE_COLUMN]);
        String airportName = row[NAME_COLUMN];

        return new Tuple2<>(code, airportName);
    }

}