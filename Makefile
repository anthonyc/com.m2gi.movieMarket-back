deploy-dev:
	mvn clean package
	cp target/movieMarket-0.0.1.war /opt/wildfly-11.0.0.Final/standalone/deployments/
	