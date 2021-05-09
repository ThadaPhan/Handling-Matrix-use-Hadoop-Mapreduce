package Demo4;

import java.io.IOException;

import java.util.*;



import org.apache.hadoop.io.FloatWritable;

import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapred.*;
public class Reduce extends MapReduceBase implements Reducer<Text, Text, Text, Text>
{

     public void reduce(Text n_key, Iterator<Text> values, OutputCollector<Text,Text> output, Reporter reporter) throws IOException
	{
          String result = "";
          String[] value;
          HashMap<Integer, String> hash = new HashMap<Integer, String>(); 
          while (values.hasNext()){
              value = values.next().toString().split(","); 
              hash.put(Integer.valueOf(value[0]),
              String.valueOf(value[1].replaceAll(".0", "")));
	  }
          String n;
          int length = hash.size();
          for (int j = 0; j < length; j++){
              n = hash.containsKey(j) ? hash.get(j) : "0"; 
              result = result + format(n);
	}
          result = result.substring(0, result.length() - 1); 
          output.collect(null, new Text(result));
}
     private String format(String value) { 
          int length = value.length(); 
          for(int i=length; i<16; i++){
              value = value + " ";
	}
          return value+",";
	  }
}
