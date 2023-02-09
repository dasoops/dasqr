pid=`ps -ef | grep DasServerApplication | grep -v grep | cut -c 9-15`
kill $pid
