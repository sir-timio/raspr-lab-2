package FlightCompareApp;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class AirportMapper extends Mapper<LongWritable, Text, FlightWritableComparable, Text>{

    private static String DELIMETER = ",";
    private static int AIRPORT_CODE_COLUMN = 0;
    private static int 
}
