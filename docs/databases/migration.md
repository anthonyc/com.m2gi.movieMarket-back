# movieMarket database migration (liquibase)
<aside class="warning">
	You must never manually update your database. 
</aside>

## Concept

This project use liquibase for manage database migration.
Summary after having make `docker-compose exec webapp make init` when you has init the project, you has create an database movieMarket and you has build angular and webservice. During the build of webservice, maven has execute liquibase migration. The version of latest migration has save in your database.

For ever build with maven, only the newest migrations has execute.

## Normal workflow

1. Edit your Hibernate mapped classes as needed (add and remove classes and attributes)
2. Run `docker-compose exec webapp mvn liquibase:diff`
3. Check that the modified changelog.xml does what you expect, edit it if it does not
4. Run liquibase `docker-compose exec webapp mvn liquibase:update`
5. Repeat