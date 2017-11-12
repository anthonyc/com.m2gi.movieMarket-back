build:
	rm -rf src/main/webapp/* && \
	cd src/main/angular/movieMarket && \
		npm install && \
		npm install jquery@1.9.1 --save &&\
		ng build --prod
	mkdir -p src/main/webapp
	cp -R src/main/angular/movieMarket/dist/* src/main/webapp/
	mvn clean package
	cp target/movieMarket-0.0.1.war /opt/wildfly-11.0.0.Final/standalone/deployments/
	
init-db:
	mysql -hdb -uroot -proot -e "DROP DATABASE IF EXISTS movieMarket"
	mysql -hdb -uroot -proot -e "CREATE DATABASE movieMarket"
	mysql -hdb -uroot -proot movieMarket < ./fixture/movieMarket.sql
	
init: init-db build