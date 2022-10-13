pid=`ps -ef | grep dasServer | grep -v grep | cut -c 9-15`

git pull
cd /usr/local/gitRepo/dasServer
mvn clean install
cd core

echo $pid
str=$"\n"
nohup mvn spring-boot:run &
sstr=$(echo -e $str)
echo $sstr
kill $pid