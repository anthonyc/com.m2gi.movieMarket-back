deploy-dev:
	mvn clean package
	cp target/movieMarket-0.0.1.war /opt/wildfly-11.0.0.Final/standalone/deployments/
	
init-db:
	mysql -hdb -uroot -proot -e "DROP DATABASE movieMarket"
	mysql -hdb -uroot -proot -e "CREATE DATABASE movieMarket"
	mysql -hdb -uroot -proot movieMarket < ./fixture/movieMarket.sql
	
init: deploy-dev init-db