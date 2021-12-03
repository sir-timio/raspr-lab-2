package FlightApp;

import scala.Tuple2;

public class FlightMapper {

    private static final String DELIMETER = ",";
    private static final int AIRPORT_CODE_COLUMN = 0;
    private static final int NAME_COLUMN = 1;
    private static final int DATA_TYPE = 0;
    private static final String QUOT = "\"";

    protected static String removeQuots(String s){
        return s.replace(QUOT, "");
    }

    public static Tuple2<Integer, String> processRow(String rowRawStr) {
        String rowStr = removeQuots(rowRawStr);
        String[] row = rowStr.split(DELIMETER);
        String airportName = row[NAME_COLUMN];
        
    }

}
