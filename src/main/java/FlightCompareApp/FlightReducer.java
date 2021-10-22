package FlightCompareApp;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class FlightReducer extends Reducer<FlightWritableComparable, Text, Text, Text>{

    @Override
    protected void reduce(FlightWritableComparable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Text airportName = new Text(key.toString());
        
    }
}
