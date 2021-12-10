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

hdfs dfs -rm -r -f /user

hdfs dfs -mkdir /user
hdfs dfs -mkdir /user/parallels


hadoop fs -rm -r -f  hdfs://localhost:9000/user/parallels/output
hadoop fs -copyFromLocal data/flights.csv
hadoop fs -copyFromLocal data/airports.csv

spark-submit --class FlightApp.FlightApp --master yarn-client --num-executors 3 target/FlightApp.jar
hadoop fs -copyToLocal output