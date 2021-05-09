rm data.txt
declare -i m=$1;
declare -i n=$2;
declare -i temp=$2;
while [ $m != 0 ]; do
	n=temp;
	while [ $n != 0 ]; do
		declare -i count=0 ;
		declare -i x=$RANDOM%999 ;
		echo -ne $x >> data.txt;
		while [ $x != 0 ];
		do
  			x=$(( $x/10 ));
			count=$(( count+1 ));
		done;
		if [[ $count = 0 ]]; then
			count=1 ;
		fi;
		while [[ $count -le 2 ]];
		do
			echo -ne " " >> data.txt;
			count=$(( count+1));
		done;
		if [ $n == 1 ]; then
			echo -ne " " >> data.txt;
		else
			echo -ne "," >> data.txt;
		fi;
		n=$(( n-1 ));
	done;
	echo >> data.txt;
	m=$(( m-1 ));
done;
