export CLASSPATH="$HADOOP_HOME/share/hadoop/mapreduce/hadoop-mapreduce-client-core-2.7.7.jar:$HADOOP_HOME/share/hadoop/mapreduce/hadoop-mapreduce-client-common-2.7.7.jar:$HADOOP_HOME/share/hadoop/common/hadoop-common-2.7.7.jar:/usr/local/hadoop/lib/*"
javac -d . Main.java Map.java Reduce.java
jar cfm Demo3.jar Manifest.txt Demo3/*.class
mv Demo3.jar ../../

