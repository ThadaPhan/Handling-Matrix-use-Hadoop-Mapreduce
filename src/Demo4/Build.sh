export CLASSPATH="$HADOOP_HOME/share/hadoop/mapreduce/hadoop-mapreduce-client-core-2.7.7.jar:$HADOOP_HOME/share/hadoop/mapreduce/hadoop-mapreduce-client-common-2.7.7.jar:$HADOOP_HOME/share/hadoop/common/hadoop-common-2.7.7.jar:./Demo4/*:/usr/local/hadoop/lib/*"
javac -d . Map.java Reduce.java Main.java
jar cfm Demo4.jar main.txt Demo4/*.class
mv Demo4.jar ../../

