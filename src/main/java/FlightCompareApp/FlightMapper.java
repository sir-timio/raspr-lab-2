package FlightCompareApp;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightMapper extends Mapper<LongWritable, Text, FlightWritableComparable, Text>{
    private static String DELIMITER = ",";
    private static int DEST_AIRPORT_ID_COLUMN =  14;
    private static int CANCELED_COLUMN = 19;
    private static int ARR_DELAY_COLUMN = 17;
    private static int ARR_DELAY_NEW_COLUMN = 18;

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (key.get() != 0){
            String[] row = value.toString().split(DELIMITER);
            if (row[ARR_DELAY_COLUMN].isEmpty() ||)
        }
    }
}
