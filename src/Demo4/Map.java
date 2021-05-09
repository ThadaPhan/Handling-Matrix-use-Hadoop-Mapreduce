package Demo4;



import java.io.IOException;

import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.io.LongWritable;

import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapred.*;



public class Map extends MapReduceBase

		implements Mapper <LongWritable, Text, Text, Text> {

	public void map(LongWritable key, Text value, OutputCollector<Text, Text> output, Reporter reporter)

			throws IOException {

		String[] values = value.toString().trim().split(",");

		output.collect(new Text(values[0]), new Text(values[1]+","+values[2]));

	}

}


