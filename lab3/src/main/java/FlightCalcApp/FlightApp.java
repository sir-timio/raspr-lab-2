package FlightAp;

public class FlightApp {

    public static void main(){
        SparkConf conf = new SparkConf().setAppName("FlightApp");
        JavaSparkContext sc = new JavaSparkContext(conf);

        JavaRDD<String> flights = sc.textFile("flights.csv")
    }
}