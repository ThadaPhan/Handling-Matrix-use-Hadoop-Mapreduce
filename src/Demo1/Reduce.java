package Demo1;

import java.io.IOException;
import java.util.*;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.conf.*;
public class Reduce extends org.apache.hadoop.mapreduce.Reducer<Text, Text, Text, Text> {

	public void reduce(Text t_key, Iterable<Text> values, Context context) throws IOException, InterruptedException {

		int i = 1;

		Configuration conf = context.getConfiguration();

		String name = String.valueOf(conf.get("name"));

		Integer column = Integer.valueOf(conf.get("column"));

		for(Text val : values){

			Text outputKey = new Text();

			outputKey.set(name + "," + t_key + "," + Integer.valueOf(column-i)+","+
				      val.toString());

			context.write(null, outputKey);

			i++;
		}
	}
}

