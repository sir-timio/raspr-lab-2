mvn package

stop-dfs.sh
stop-yarn.sh

start
start-dfs.sh

hadoop fs -copyFromLocal data/Flights.csv
hadoop fs -copyFromLocal data/Airports.csv
export HADOOP_CLASSPATH=target/hadoop-examples-1.0-SNAPSHOT.jar
hadoop FlightCompareApp data/Flights.csv data/Airports.csv output
hadoop fs -copyToLocal output