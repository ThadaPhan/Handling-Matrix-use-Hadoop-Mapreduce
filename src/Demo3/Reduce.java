package Demo3;

import java.io.IOException;

import java.util.*;



import org.apache.hadoop.io.FloatWritable;

import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapred.*;



public class Reduce extends MapReduceBase implements Reducer<Text, Text, Text, Text> 
{

	public void reduce(Text n_key, Iterator<Text> values, OutputCollector<Text,Text> output, Reporter reporter) 

	throws IOException

	{

		float sum = 0;

		int count = 0;

		float average;

		while(values.hasNext())

		{

			IntWritable value = new IntWritable(Integer.valueOf(String.valueOf(values.next())));

			sum += value.get();

			count = count + 1;

		}

		average = sum/count;

		output.collect(new Text("PRIME AVERAGE:"), new Text(String.valueOf(average)));

	}
}

