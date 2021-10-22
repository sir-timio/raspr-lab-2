package FlightCompareApp;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class FlightReducer extends Reducer<FlightWritableComparable, Text, Text, Text>{

    @Override
    protected void reduce(FlightWritableComparable key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
        Iterator<Text> iterator = values.iterator();
        Text airportName = new Text(iterator.next());

        
    }
}
