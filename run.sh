#GET ROW,COL OF M,N MATRIX
echo "Row of M matrix:"
read m
echo "Column of M matrix:"
read n
echo "Column of N matrix:"
read p

#DELETE M_MATRIX, M_TRANSFER_MATRIX DIRECTORY
hadoop fs -rm -r M_MATRIX >/dev/null 2>&1
hadoop fs -rm -r M_TRANSFER_MATRIX >/dev/null 2>&1
#CREATE DATA, PUT DATA INTO M_MATRIX DIRECTORY
./createData.sh $m $n
hadoop fs -mkdir -p M_MATRIX
hdfs dfs -put data.txt M_MATRIX #>/dev/null 2>&1
echo "----------------------------------------------INPUT1----------------------------------------"
hdfs dfs -cat M_MATRIX/data.txt
echo "---------------------------------------------MATRIX-M---------------------------------------"
read -p "Press enter to countinue"
#RUN DEMO1 TO TRANSFER M MATRIX
hadoop jar Demo1.jar Demo1.Main M_MATRIX M_TRANSFER_MATRIX M $n
echo "----------------------------------------------OUTPUT1---------------------------------------"
hdfs dfs -cat M_TRANSFER_MATRIX/M-r-00000
echo "------------------------------------------M-TRANSFER-MATRIX---------------------------------"
read -p "Press enter to continue"

#DELETE N_MATRIX, N_TRANSFER_MATRIX DIRECTORY
hadoop fs -rm -r N_MATRIX >/dev/null 2>&1
hadoop fs -rm -r N_TRANSFER_MATRIX >/dev/null 2>&1
#CREATE DATA, PUT DATA INTO N_MATRIX DIRECTORY
./createData.sh $n $p
hadoop fs -mkdir -p N_MATRIX
hdfs dfs -put data.txt N_MATRIX >/dev/null 2>&1
echo "----------------------------------------------INPUT2-----------------------------------------"
hdfs dfs -cat N_MATRIX/data.txt
echo "---------------------------------------------MATRIX-N----------------------------------------"
read -p "Press enter to countinue"
#RUN DEMO1 TO TRANSFER N MATRIX
hadoop jar Demo1.jar Demo1.Main N_MATRIX N_TRANSFER_MATRIX N $p
echo "---------------------------------------------OUTPUT2-----------------------------------------"
hdfs dfs -cat N_TRANSFER_MATRIX/N-r-00000
echo "-----------------------------------------N-TRANSFER-MATRIX-----------------------------------"
read -p "Press enter to continue"

#DELETE MATRIX_TRANSFER DIRECTORY
hadoop fs -rm -r MATRIX_TRANSFER >/dev/null 2>&1
#CREATE MATRIX_TRANSFER DIRECTORY
hadoop fs -mkdir -p MATRIX_TRANSFER
#MOVE M AND N MATRIX FORMATED INTO MATRIX_TRANSFER DIRECTORY
hadoop fs -mv M_TRANSFER_MATRIX/M-r-00000 MATRIX_TRANSFER >/dev/null 2>&1
hadoop fs -mv N_TRANSFER_MATRIX/N-r-00000 MATRIX_TRANSFER >/dev/null 2>&1

#DELETE MxN DIRECTORY
hadoop fs -rm -r MxN >/dev/null 2>&1
#RUN DEMO2 TO MULTIPLY M_MATRIX VS N_MATRIX
hadoop jar Demo2.jar Demo2.Main MATRIX_TRANSFER MxN $m $n $p
echo "----------------------------------------------OUTPUT3----------------------------------------"
hdfs dfs -cat MxN/part-r-00000
echo "-----------------------------------------------M-x-N-----------------------------------------"
read -p "Press enter to countinue"

#DELETE MxN_FORMAT DIRECTORY
hadoop fs -rm -r MxN_FORMAT >/dev/null 2>&1
#RUN DEMO4 TO FORMAT MxN RESULT
hadoop jar Demo4.jar MxN MxN_FORMAT $p
echo "----------------------------------------------OUTPUT4----------------------------------------"
hdfs dfs -cat MxN_FORMAT/part-00000
echo "--------------------------------------------M-x-N-FORMAT-------------------------------------"
read -p "Press enter to countinue"

#DELTED FINAL_OUT DIRECTORY
hadoop fs -rm -r FINAL_OUTPUT >/dev/null 2>&1
#RUN DEMO3 TO AVERAGE ALL PRIME NUMBER IN MxN RESULT
hadoop jar Demo3.jar MxN_FORMAT FINAL_OUTPUT
echo "----------------------------------------------OUTPUT5----------------------------------------"
hdfs dfs -cat FINAL_OUTPUT/part-00000
echo "-----------------------------------------------FINAL-----------------------------------------"
echo "----------------------------------------THANK'S FOR WATCHING---------------------------------"
