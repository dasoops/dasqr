pid=`ps -ef | grep DasServerApplication | grep -v grep | cut -c 9-15`

git pull
cd /usr/local/gitRepo/dasServer
mvn clean install

echo $pid
str=$"\n"
nohup mvn spring-boot:run -pl core >./logs/mvn.log 2>&1 &
sstr=$(echo -e $str)
echo $sstr
kill $pid