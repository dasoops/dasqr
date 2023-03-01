pid=`ps -ef | grep DasServerApplication | grep -v grep | cut -c 9-15`

cd /usr/local/gitRepo/dasServer
git pull
mvn clean install

cd /usr/local/gitRepo/common-boot-starter
git pull
mvn clean install

cd /usr/local/gitRepo/dasServer

echo $pid
str=$"\n"
nohup mvn spring-boot:run -pl core >./logs/mvn.log 2>&1 &
sstr=$(echo -e $str)
echo $sstr
kill $pid

