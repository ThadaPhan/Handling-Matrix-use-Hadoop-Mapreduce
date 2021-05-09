package Demo3;

import java.io.IOException;

import java.math.*;

import org.apache.hadoop.io.IntWritable;

import org.apache.hadoop.io.LongWritable;

import org.apache.hadoop.io.Text;

import org.apache.hadoop.mapred.*;



public class Map extends MapReduceBase
		implements Mapper <LongWritable, Text, Text, Text> {
	public void map(LongWritable key, Text value, OutputCollector<Text, Text> output, Reporter reporter)

			throws IOException {

		String intvalue = value.toString();
		String[] values = intvalue.split(",");
		int length = values.length;
		BigInteger[] B = new BigInteger[length];

		for(int  i =0 ; i < length; i++)

		{
			BigDecimal temp = new BigDecimal(values[i].toString().trim());

			B[i] = temp.toBigInteger();

		}

		for (int i = 0; i < B.length; i++) {

			if(B[i] != null)

			if (B[i].isProbablePrime(100)) {

				 output.collect(new Text("1"),new Text(B[i].toString()));

			}

		}
	}

}





