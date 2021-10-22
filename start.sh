mvn package

stop-yarn.sh
stop-dfs.sh

rm -rf ~/hdata/namenode
rm -rf ~/hdata/datanode

mkdir ~/hdata/namenode
mkdir ~/hdata/datanode

hdfs namenode -format

start-dfs.sh
start-yarn.sh

hadoop fs -rm -r -f  hdfs://localhost:9000/user/timur/output

hadoop fs -copyFromLocal data/Flights.csv
hadoop fs -copyFromLocal data/Airports.csv
export HADOOP_CLASSPATH=target/FlightCompareApp-1.0.jar
hadoop FlightCompareApp.AirportStatsApp data/Flights.csv data/Airports.csv output

rm -rf output
mkdir output
hadoop fs -copyToLocal /Users/timur/Documents/5_term/parallel/output