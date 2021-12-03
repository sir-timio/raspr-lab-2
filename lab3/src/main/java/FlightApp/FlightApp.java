package FlightApp;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;


public class FlightApp {
    private static final String PATH_TO_FLIGHTS = "flights.csv";
    private static final String PATH_TO_AIRPORTS = "airp.csv";

    public static void main(String[] args){

        SparkConf conf = new SparkConf().setAppName("FlightApp");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> flightsFile = sc.textFile(PATH_TO_FLIGHTS);


        JavaRDD<String> airportsFIle = sc.textFile(PATH_TO_AIRPORTS);
        JavaPairRDD<Integer, String> airports = airportsFIle.mapToPair(AirportMapper::processRow);

    }
}