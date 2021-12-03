package FlightApp;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;

public class FlightApp {
    SparkConf conf = new SparkConf().setAppName("FlightApp");
    JavaSparkContext sc = new JavaSparkContext(conf);

    JavaRDD<String> flightFile = sc.textFile("flights.csv");

}
