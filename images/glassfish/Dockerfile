FROM glassfish/server:4.1.1
# See: https://hub.docker.com/r/glassfish/server/~/dockerfile/
# See: https://github.com/glassfish/docker/tree/master/4.1.1


MAINTAINER Ioannis Noukakis <ioannis.noukakis@heig-vd.ch>

ADD drivers/mysql-connector-java-5.1.39-bin.jar /glassfish4/glassfish/lib/
ADD target/LandingPageMVCApp-1.1-STUDENT.war /glassfish4/glassfish/domains/domain1/autodeploy/
ADD target/final.war /glassfish4/glassfish/domains/domain1/autodeploy/