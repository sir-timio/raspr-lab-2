package FlightApp;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;
import scala.Tuple2;

import java.util.Map;


public class FlightApp {
    private static final String PATH_TO_FLIGHTS = "flights.csv";
    private static final String PATH_TO_AIRPORTS = "airport.csv";
    private static final String FIRST_LINE_PREFIX_AIRPORT = "Code";
    private static final String FIRST_LINE_PREFIX_FLIGHTS = "\"YEAR\"";

    public static void main(String[] args){

        SparkConf conf = new SparkConf().setAppName("FlightApp");
        JavaSparkContext sc = new JavaSparkContext(conf);


        JavaRDD<String> airportsFIle = sc.textFile(PATH_TO_AIRPORTS);
        JavaPairRDD<Integer, String> airports = airportsFIle
                .filter(row -> !row.startsWith(FIRST_LINE_PREFIX_AIRPORT))
                .mapToPair(AirportMapper::processRow);

        JavaRDD<String> flightsFile = sc.textFile(PATH_TO_FLIGHTS);
        JavaPairRDD<Tuple2<Integer, Integer>, FlightSerializable> flights = flightsFile
                .filter(row -> !row.startsWith(FIRST_LINE_PREFIX_FLIGHTS))
                .mapToPair(FlightMapper::processRow);

        Map<Integer, String> airportsMap = airports.collectAsMap();
        final Broadcast<Map<Integer, String>> airportsBroa

    }
}