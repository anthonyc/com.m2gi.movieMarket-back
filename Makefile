build: build-front build-back

build-back:
	mkdir -p src/main/webapp/swagger-ui
	cp swagger/dist/* src/main/webapp/swagger-ui/
	mvn clean package
	cp target/movieMarket-0.0.1.war /opt/wildfly-11.0.0.Final/standalone/deployments/

build-front:
	rm -rf src/main/webapp/* && \
	cd src/main/angular/movieMarket && \
		npm install && \
		node_modules/@angular/cli/bin/ng build --prod
	mkdir -p src/main/webapp
	cp -R src/main/angular/movieMarket/dist/* src/main/webapp/
	
init-db:
	mysql -hdb -uroot -proot -e "DROP DATABASE IF EXISTS movieMarket"
	mysql -hdb -uroot -proot -e "CREATE DATABASE movieMarket"
	mysql -hdb -uroot -proot movieMarket < ./fixture/movieMarket.sql
	
init: init-db build