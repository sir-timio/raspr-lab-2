package FlightCompareApp;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;


public class AirportGroupingComparator extends WritableComparator{

    public AirportGroupingComparator () {
        super(FlightWritableComparable.class, true);
    }

    @Override
    protected int compare(WritableComparable a1, WritableComparable a2) {
        FlightWritableComparable airport1 = (FlightWritableComparable) a1;
        FlightWritableComparable
    }
}
