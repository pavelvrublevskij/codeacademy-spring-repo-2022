# E-Shop
WEB for Spring MVC learning

### Requirements
* Language Adopt Open JDK 11 Hotspot

### Access the application
http://localhost:8080

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
See [help](HELP.md) for getting started
