cd framework
javac -d build *.java
cd build
rm -rf framework.jar && jar -cf framework.jar . || jar -cf framework.jar .
rm -rf ../../TestFramework/build/web/WEB-INF/lib/framework.jar && cp framework.jar ../../TestFramework/build/web/WEB-INF/lib/framework.jar || cp framework.jar ../../TestFramework/build/web/WEB-INF/lib/framework.jar 
cd ../../TestFramework/build/web/
rm -rf TestFramework.war && jar -cf TestFramework.war . || jar -cf TestFramework.war .
rm -rf /opt/tomcat/webapps/TestFramework.war && cp TestFramework.war /opt/tomcat/webapps/ || cp TestFramework.war /opt/tomcat/webapps/
