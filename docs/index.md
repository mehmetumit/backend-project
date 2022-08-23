# backend-project

Backend project with Java and PostgreSQL

---

# Usage

## Install to war file

```sh
mvn install
```

## Run postgresql, pgadmin and tomcat containers

```sh
docker-compose up
```

## Run backend

```sh
mvn clean compile exec:java
```

## Restart tomcat

```sh
docker restart tomcat_container
```

---

# Inspect Database

## With PGADMIN

![pgadmin](docs/pgadmin1.png)

![pgadmin](docs/pgadmin2.png)

![pgadmin](docs/pgadmin3.png)

![pgadmin](docs/pgadmin4.png)

![pgadmin](docs/pgadmin5.png)

---

## With DBeaver

![dbeaver](docs/dbeaver1.png)

![dbeaver](docs/dbeaver2.png)

![dbeaver](docs/dbeaver3.png)

![dbeaver](docs/dbeaver4.png)

![dbeaver](docs/dbeaver5.png)

---


# ER Diagram

![architecture](docs/ER.png)

---

# Software Architecture

![architecture](docs/architecture.png)

