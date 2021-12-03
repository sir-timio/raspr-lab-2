package FlightApp;

import scala.Tuple2;

public class FlightMapper {
    private static final String DELIMITER = ",";
    private static final int ORIGIN_AIRPORT_ID_COLUMN = 11;
    private static final int DEST_AIRPORT_ID_COLUMN =  14;
    private static final int ARR_DELAY_COLUMN = 18;
    private static final int CANCELLED_STATUS_COLUMN = 19;

    public static Tuple2<Tuple2<Integer, Integer>, FlightSerializable> processRow(String rawRowStr){
        String[] row = rawRowStr.split(DELIMITER);

        String rawDelay = row[ARR_DELAY_COLUMN];
        float delay = 0;
        if (!rawDelay.isEmpty()) {
            delay = Float.parseFloat(rawDelay)
        }

        String rawIsCancelled = row[CANCELLED_STATUS_COLUMN];
        boolean isCancelled = true;
        if (!rawIsCancelled.isEmpty()){
            isCancelled =
        }

    }
}
