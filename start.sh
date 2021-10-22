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

hadoop fs -copyFromLocal data/flights.csv
hadoop fs -copyFromLocal data/airports.csv

export HADOOP_CLASSPATH=target/FlightCompareApp-1.0.jar

hadoop FlightCompareApp.AirportStatsApp flights.csv airports.csv output

rm -rf output
mkdir output
hadoop fs -copyToLocal /Users/timur/output