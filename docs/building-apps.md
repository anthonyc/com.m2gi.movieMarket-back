# Building applications

## Build and deploy all applications

```bash
docker-compose exec webapp make build
```
This command run mvn clean package inside the container, build the angular app, build webservice and ejb with maven and deploy the war

You can see when wildfly see the application with

```bash
docker-compose logs -f webapp
```

## Build only back application

```bash
docker-compose exec webapp make build-back
```

## Build only front application

```bash
docker-compose exec webapp make build-front
```

## Init db
```bash
docker-compose exec webapp make init-db
```