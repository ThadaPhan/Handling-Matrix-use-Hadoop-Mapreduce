package Demo2;

import org.apache.hadoop.conf.*;

import org.apache.hadoop.fs.Path;

import org.apache.hadoop.io.*;

import org.apache.hadoop.mapreduce.*;

import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;

import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;

import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;

public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length != 5) {
            System.err.println("Must 5 paramaters");
            System.exit(2);
        }
        Configuration conf = new Configuration();

        conf.set("m", args[2]);
        conf.set("n", args[3]);
        conf.set("p", args[4]);

	@SuppressWarnings("deprecation")
                Job job = new Job(conf, "MatrixMultiply");
        job.setJarByClass(Main.class);
	job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);

        job.setMapperClass(Map.class);

        job.setReducerClass(Reduce.class);

        job.setInputFormatClass(TextInputFormat.class);

        job.setOutputFormatClass(TextOutputFormat.class);

        FileInputFormat.addInputPath(job, new Path(args[0]));

        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        job.waitForCompletion(true);
    }
}
