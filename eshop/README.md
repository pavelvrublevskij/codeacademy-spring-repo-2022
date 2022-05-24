# E-Shop
WEB for Spring MVC learning

### Requirements
* Language Adopt Open JDK 11 Hotspot

### Access the application
http://localhost:8080

## Run application
Application has several profiles:

`amazon` - full functional.

`ebay` - delete product not possible and product list are always empty.
### DB profiles
By default, h2 DBMS will be activated. To activate other DBMS, additional profile should be added:

`pg` - PostgreSQL will be used. PostgreSQL DBMS required. You could use below docker command (docker required).
See __application-pg.yml__ for configuration.

`mysql` - MySQL will be used. MySQL DBMS required. You could use below docker command (docker required).
See __application-mysql.yml__ for configuration.

## Run DB with Docker
### Run mysql
```
docker run --detach --name mysql_eshop --env MYSQL_ROOT_PASSWORD=123 --env MYSQL_DATABASE=eshopdb --env MYSQL_USER=eshop --env MYSQL_PASSWORD=passShop --publish 3306:3306 mysql
```

### Run postgres
```
docker run --detach --name postgres_eshop --env POSTGRES_DB=eshopdb --env POSTGRES_USER=eshop --env POSTGRES_PASSWORD=passShop --publish 5432:5432 postgres
```

## Run DB with docker-compose
```
docker-compose up -d
```

## How To
Run api with security mode (h2 db will be used):
```
gradlew clean build
gradlew bootJar
java -jar ./build/libs/eshop-0.0.1-SNAPSHOT.jar
```

Run api on production mode:
````
java -jar -Dspring.profiles.active=pg promptpay-api.jar
````

See [help](HELP.md) for getting started
