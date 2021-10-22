package FlightCompareApp;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirportMapper extends Mapper<LongWritable, Text, FlightWritableComparable, Text>{

    private static String DELIMETER = ",";
    private static int AIRPORT_CODE_COLUMN = 0;
    private static int NAME_COLUMN = 1;
    private static int DATA_TYPE = 0;

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
        if (key.get() != 0) {
            String[] row = value.toString().split(DELIMETER);
            String rawCode = row[AIRPORT_CODE_COLUMN];
            rawCode = rawCode.replace("\"", "")l
            int code = Integer.parseInt(rawCode);
            String airportName = row[NAME_COLUMN];
            context.write(new FlightWritableComparable(code, DATA_TYPE), new Text(airportName));
        }
    }
}
