deploy-dev:
	rm -f src/main/webapp/*
	cd src/main/angular/movieMarket && npm install && ng build --prod
	cp src/main/angular/movieMarket/dist/* src/main/webapp/
	mvn clean package
	cp target/movieMarket-0.0.1.war /opt/wildfly-11.0.0.Final/standalone/deployments/
	
init-db:
	mysql -hdb -uroot -proot -e "DROP DATABASE IF EXISTS movieMarket"
	mysql -hdb -uroot -proot -e "CREATE DATABASE movieMarket"
	mysql -hdb -uroot -proot movieMarket < ./fixture/movieMarket.sql
	
init: init-db deploy-dev