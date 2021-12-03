start-yarn.sh
start-dfs.sh

mvn package

spark-submit --class FlightApp.FlightApp --master yarn-client --num-executors 3 target/FlightApp.jar