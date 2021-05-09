package Demo1;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.io.LongWritable;

import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapreduce.Mapper;

import org.apache.hadoop.conf.*;

public class Map extends org.apache.hadoop.mapreduce.Mapper<LongWritable, Text, Text, Text> {

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

		Configuration conf = context.getConfiguration();

		Integer column = Integer.valueOf(conf.get("column"));

		String keyString = key.toString();

		Integer keyInt = 0;

			keyInt = Integer.parseInt(keyString);

		String valueString = value.toString();

		String[] item = valueString.split(",");

		for(int i = 0; i < column; i++){

			context.write( new Text(String.valueOf(keyInt%(column*4))), new Text(item[i].trim()));

		}

	}

}


