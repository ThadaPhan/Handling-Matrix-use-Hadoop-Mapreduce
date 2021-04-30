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
    * A execute file to run all demo: run.sh 
  


## ***INSTALLATION***

* You can install this project in [Handling-Matrix-with-Hadoop](https://github.com/ThadaPhan/Handling-Matrix-with-Hadoop.git)

## ***BUILD***

* Step 1: Give permission for execute files:
  * *chmod +x Demo1/Build.sh Demo2/Build.sh Demo3/Build.sh Demo4/Build.sh createData.sh run.sh*
* Step 2: Execute all demo:
  * *run.sh*
  * After execute run.sh command, you must
   * Type number of column and row of M, N Matrix (column M = row N)
   * Hit Enter to continue when screen stop to show result

## ***RUN ALL DEMO***

* Step by step:
  * Step 1: Run command:
    * *run.sh*
  * Step 2: Type row number of M matrix:
    * Row of M matrix:
      
      4
  * Step 3: Type column number of M matrix = row number of N matrix:
    * Column of M matrix:
    
      3
  * Step 4: TYpe column number of N matrix:
    * Column of N matrix:
 
      5
   * When srcreen stop to show input and ouput of every demo, you must hit "enter" to continue.
## ***EDIT DEMO***
* If you want to edit any demo your way, you can. But after edit, you have to rebuild jar file of demo you edit by run: *./Build.sh*
## ***GOOD LUCK :))***
