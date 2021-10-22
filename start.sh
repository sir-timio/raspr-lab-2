mvn package

hadoop fs -copyFromLocal data/Flights.csv
hadoop fs -copyFromLocal data/Airports.csv
export HADOOP_CLASSPATH=target/hadoop-examples-1.0-SNAPSHOT.jar
hadoop 