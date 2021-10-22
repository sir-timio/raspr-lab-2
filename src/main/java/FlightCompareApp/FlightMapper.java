package FlightCompareApp;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class FlightMapper extends Mapper<IntWritable, Text, FlightWritableComparable, Text>{
    private static String DELIMITER = ",";
    private static int AIRPORT_ID_COLUMN =  14;
}
