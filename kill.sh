pid=`ps -ef | grep dasServer | grep -v grep | cut -c 9-15`
kill $pid