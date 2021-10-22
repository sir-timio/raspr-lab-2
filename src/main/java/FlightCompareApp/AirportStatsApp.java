package FlightCompareApp;

import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

public class AirportStatsApp {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.err.println("flights airports output");
            System.exit(-1);
        }

        Job job = Job.getInstance();
        job.setJarByClass(AirportStatsApp.class);


    }
}
