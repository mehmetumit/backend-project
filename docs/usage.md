# Usage

## Initialize Backend

```sh
mvn install
```

## Run postgresql, pgadmin and tomcat containers

```sh
docker-compose up
```

## Restart tomcat 
> No need to manually restart after generate new war file but you can restart if anything happens unexpected.
```sh
docker restart tomcat_container
```
