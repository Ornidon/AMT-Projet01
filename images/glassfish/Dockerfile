FROM glassfish/server:4.1.1
# See: https://hub.docker.com/r/glassfish/server/~/dockerfile/
# See: https://github.com/glassfish/docker/tree/master/4.1.1


MAINTAINER Ioannis Noukakis <ioannis.noukakis@heig-vd.ch>


ADD projet-1.0-SNAPSHOT.war /glassfish4/glassfish/domains/domain1/autodeploy/
ADD drivers/mysql-connector-java-5.1.39-bin.jar /glassfish4/glassfish/lib/

RUN echo "AS_ADMIN_PASSWORD=glassfish" > /tmp/gfpw.txt && \
		./glassfish4/bin/asadmin start-domain domain1 && \
		./glassfish4/bin/asadmin --interactive=false --user admin --passwordfile=/tmp/gfpw.txt create-jdbc-connection-pool --restype javax.sql.DataSource --datasourceclassname com.mysql.jdbc.jdbc2.optional.MysqlDataSource --property user=root:password=1234:DatabaseName=sakila:ServerName=db:port=3306 pool_sakila && \
		./glassfish4/bin/asadmin --interactive=false --user admin --passwordfile=/tmp/gfpw.txt create-jdbc-resource --connectionpoolid pool_sakila jdbc/sakila

RUN ./glassfish4/bin/asadmin stop-domain domain1