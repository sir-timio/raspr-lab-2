mvn package

stop-yarn.sh
stop-dfs.sh

rm -rf ~/hdata/namenode
rm -rf ~/hdata/datanode
hdfs namenode -format

start
start-dfs.sh

hadoop fs -copyFromLocal data/Flights.csv
hadoop fs -copyFromLocal data/Airports.csv
export HADOOP_CLASSPATH=target/hadoop-examples-1.0-SNAPSHOT.jar
hadoop FlightCompareApp data/Flights.csv data/Airports.csv output
hadoop fs -copyToLocal output