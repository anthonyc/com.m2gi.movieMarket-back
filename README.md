# com.m2gi.movieMarket-back

## Setup project

You need docker see [https://github.com/docker/docker-install](https://github.com/docker/docker-install)

### Launch server
``` bash
docker-compose up -d
```

This command download wildfly 11. It make take time <br />
Now you have a wildfly container with a mysql datastore configured which run on localhost:8080.

### Init Project
```bash
docker-compose exec webapp make init
```

Check in go to [http://localhost:8080/movieMarket-0.0.1/ws/movies](http://localhost:8080/movieMarket-0.0.1/ws/movies)
## Utils
### Deploy the application

```bash
docker-compose exec webapp make deploy-dev
```
This command run mvn clean package inside the container and deploy the war

You can see when wildfly see the application with

```bash
docker-compose logs -f webapp
```

### Init db
```bash
docker-compose exec webapp make init-db
```