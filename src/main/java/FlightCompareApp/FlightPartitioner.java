package FlightCompareApp;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.io.Text;

public class FlightPartitioner extends Partitioner<AirportWritableComparable, Text>{

    @Override
    public int getPartition(AirportWritableComparable flightWritableComparable, Text text, int numPartitions) {
       return flightWritableComparable.getAirportID() % numPartitions;
    }
}
