#!/bin/sh
PACKAGE_NAME=json-server
VERSION=0.1

JVM_OPTS="-Xms256M -Xmx1G -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintGCApplicationConcurrentTime -XX:+PrintGCApplicationStoppedTime -XX:+HeapDumpOnOutOfMemoryError"

# start Jetty server
#java $JVM_OPTS -Dorg.mortbay.util.URI.charset=utf-8 -Dhost=$1 -Dport=8443 -jar target/${PACKAGE_NAME}-${VERSION}.jar > stdout.log 2>&1 &
java -Dorg.mortbay.util.URI.charset=utf-8 -Dhost=$1 -Dport=8443 -jar target/${PACKAGE_NAME}-${VERSION}.jar > stdout.log 2>&1 &

