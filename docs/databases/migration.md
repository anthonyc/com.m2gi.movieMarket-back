# movieMarket database migration (liquibase)
<aside class="warning">
	You must never manually update your database. 
</aside>

## Concept

This project use liquibase for manage database migration.
Summary after having make `docker-compose exec webapp make init` when you has init the project, you has create an database movieMarket and you has build angular and webservice. During the build of webservice, maven has execute liquibase migration. The version of latest migration has save in your database.

For ever build with maven, only the newest migrations has execute.

## Add new migration

When you need to create a new migration, you have just to add you file migration in `src/main/resources/liquibase/changelogs/`. You should respect naming convention.

The naming pattern is `db.changelog-version.xml`.
If your migration change the schema, you should update the latest `1.x` version.
If your migration add fixture, you should update the latest `2.x` version.

<aside class="notice">
	This naming convention is not a good way for manage fixture.
	It is bring to change 
</aside> 