# ***ADVANCED MAPREDUCE DEMO IN HADOOP: HANDING MATRIX PROJECT***

## ***INTRODUCTION***
* This project include:
    * 4 demo handing matrix:
    <table>
    <tr>
        <td>Name</td>
        <td>Input example</td>
        <td>Corresponding output</td>
    </tr>
    <tr>
        <td>Demo 1</td>
        <td>
          M Matrix
          <table>
            <tr>
              <td>1, 4</td>
            </tr>
            <tr>
              <td>2, 5</td>
            </tr>
          </table>
        </td>
        <td>
          <h4>M, 0, 0, 1</h4>
          <h4>M, 0, 1, 4</h4>
          <h4>M, 1, 0, 2</h4>
          <h4>M, 1, 1, 5</h4>
        </td>
    </tr>
    <tr>
      <td>
        Demo 2  
      </td>
      <td>
      <div>
        <h4>M, 0, 0, 1</h4>
        <h4>M, 0, 1, 4</h4>
        <h4>M, 1, 0, 2</h4>
        <h4>M, 1, 1, 5</h4>
        <h1></h1>
      </div>
      <div>
        <h4>N, 0, 0, 2</h4>
        <h4>N, 0, 1, 1</h4>
        <h4>N, 1, 0, 3</h4>
        <h4>N, 1, 1, 5</h4>
      </div>
      </td>
      <td>
        <h4>MxN Matrix</h4>
        <h4>0, 0, 14</h4>
        <h4>0, 1, 21</h4>
        <h4>1, 0, 19</h4>
        <h4>1, 1, 27</h4>
      </td>
    </tr>
    <tr>
        <td>Demo 3</td>
        <td>
        <h4>0, 0, 14</h4>
        <h4>0, 1, 21</h4>
        <h4>1, 0, 19</h4>
        <h4>1, 1, 27</h4>
        </td>
        <td>
          <table>
            <tr>
              <td>14, 21</td>
            </tr>
            <tr>
              <td>19, 27</td>
            </tr>
          </table>
        </td>
    </tr>
    <tr>
       <td>
         Demo 4
       </td>
       <td>
          <table>
            <tr>
              <td>14, 21</td>
            </tr>
            <tr>
              <td>19, 27</td>
            </tr>
          </table>
       </td>
       <td>
          AVERAGE ALL PRIME: 19
       </td>
    </tr>
   </table>
   
    * A execute file used to create any matrix you want: createData.sh
    * A execute to run all 
  
 * data.txt: list of students receiving encourage learning scholarships in HCMUTE from 2018 to 2020.


## ***INSTALLATION***

* You can install this project in [WordCount with Hadoop](https://github.com/ThadaPhan/WordCount-with-Hadoop.git)

## ***BUILD***

* Step 1: Create a operation direction:
  * *mkdir operation*
* Step 2: Compiling the program in particular folder named as operation/:
  * *javac -cp $HADOOP_HOME/share/hadoop/common/hadoop-common-2.7.7.jar:$HADOOP_HOME/share/hadoop/mapreduce/hadoop-mapreduce-client-core-2.7.7.jar:operation/:. -d operation map.java*
  * *javac -cp $HADOOP_HOME/share/hadoop/common/hadoop-common-2.7.7.jar:$HADOOP_HOME/share/hadoop/mapreduce/hadoop-mapreduce-client-core-2.7.7.jar:operation/:. -d operation reduce.java*
  * *javac -cp $HADOOP_HOME/share/hadoop/common/hadoop-common-2.7.7.jar:$HADOOP_HOME/share/hadoop/mapreduce/hadoop-mapreduce-client-core-2.7.7.jar:operation/:. -d operation runner.java*
* Step 3: Create WordCount.jar file:
  * *jar -cvf WordCount.jar -C operation/ .*

  Now, you have a WordCount jar file with name *WordCount.jar*

## ***DEMO***

* Step by step:
  * Step 1: Create input direction in HDFS:
    * *hdfs dfs -mkdir -p input*
  * Step 2: Put data.txt file into input in HDFS:
    * *hdfs dfs -put data.txt input*
  * Step 3: Demo WordCount
    * *hadoop jar WordCount.jar PackageDemo.runner input output*
  * Step 4: Show result
    * *hdfs dfs -cat output/part-00000*
* Instructional video: [Demo WordCount with Hadoop](youtu.be/dN8gNwBmy34)

