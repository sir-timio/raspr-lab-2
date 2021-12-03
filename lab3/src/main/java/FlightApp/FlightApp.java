package FlightApp;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import scala.Tuple2;

public class FlightApp {
    private static final String PATH_TO_FLIGHTS = "flights.csv";
    private static final String PATH_TO_AIRPORTS = "airports.csv";
    SparkConf conf = new SparkConf().setAppName("FlightApp");
    JavaSparkContext sc = new JavaSparkContext(conf);

    JavaRDD<String> flightFile = sc.textFile(PATH_TO_FLIGHTS);
    JavaPairRDD<Tuple2<Integer, Integer>, FlightSerializable>

}
