FROM aallam/oracle-java:8

WORKDIR /tmp

RUN apt-get -y update && \
	apt-get install -yq curl sudo make maven ca-certificates mysql-client && \
	apt-get clean && \
	rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*
	
RUN curl -sL https://deb.nodesource.com/setup_6.x | sudo -E bash - &&\
	apt-get -y update && \
	apt-get install -yq nodejs &&\
	apt-get clean && \
	rm -rf /var/lib/apt/lists/* /tmp/* /var/tmp/*
	
COPY ./docker/mysql-connector/mysql-connector-java-5.1.45-bin.jar .
COPY ./docker/wildfly/standalone.xml .
COPY ./docker/mysql-connector/module.xml .

ENV JBOSS_HOME /opt/wildfly-11.0.0.Final

RUN	wget http://download.jboss.org/wildfly/11.0.0.Final/wildfly-11.0.0.Final.tar.gz && \
	tar xzf wildfly-11.0.0.Final.tar.gz && \
	mv wildfly-11.0.0.Final $JBOSS_HOME && \
	rm wildfly-11.0.0.Final.tar.gz*

RUN	cp standalone.xml $JBOSS_HOME/standalone/configuration/

ENV LAUNCH_JBOSS_IN_BACKGROUND true

EXPOSE 8080

RUN	mkdir -p $JBOSS_HOME/modules/system/layers/base/com/mysql/driver/main && \
	cp mysql-connector-java-5.1.45-bin.jar $JBOSS_HOME/modules/system/layers/base/com/mysql/driver/main/ && \
	cp module.xml $JBOSS_HOME/modules/system/layers/base/com/mysql/driver/main/ &&\
	rm mysql-connector-java-5.1.45-bin.jar && rm module.xml

COPY ./target/movieMarket-0.0.1.war $JBOSS_HOME/standalone/deployments/

RUN mkdir -p /dev/movieMarket

WORKDIR /dev/movieMarket

CMD ["/opt/wildfly-11.0.0.Final/bin/standalone.sh", "-b", "0.0.0.0"]
