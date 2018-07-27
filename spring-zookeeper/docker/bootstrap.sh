#!/bin/sh

ZK_SERVER=${ZK_SERVER:-"172.31.29.85:2181"}

USER_SET=${USER_SET:-"{\"users\": [{ \"username\":\"admin\" , \"password\":\"123456\",\"role\": \"ADMIN\" \},{ \"username\":\"appconfig\" , \"password\":\"appconfig\",\"role\": \"USER\" \}]\}"}
LOGIN_MESSAGE=${LOGIN_MESSAGE:-"Please login using admin/manager or appconfig/appconfig."}

sed -i "s/^zkServer=.*$/zkServer=$ZK_SERVER/" /var/app/config.cfg

sed -i "s/^userSet = .*$/userSet = $USER_SET/" /var/app/config.cfg
sed -i "s/^loginMessage=.*$/loginMessage=$LOGIN_MESSAGE/" /var/app/config.cfg

echo "Starting zkui with server $ZK_SERVER"

exec java -jar /var/app/zkui.jar
