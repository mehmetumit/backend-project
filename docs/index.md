# backend-project

Backend project with Java, PostgreSQL and Tomcat

---

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

# File Tree
```sh
.
├── _config.yml
├── docker-compose.yml
├── docs
│   ├── architecture.png
│   ├── dbeaver1.png
│   ├── dbeaver2.png
│   ├── dbeaver3.png
│   ├── dbeaver4.png
│   ├── dbeaver5.png
│   ├── ER.png
│   ├── index.md
│   ├── pgadmin1.png
│   ├── pgadmin2.png
│   ├── pgadmin3.png
│   ├── pgadmin4.png
│   ├── pgadmin5.png
│   └── rest_collection.json
├── pom.xml
├── queries
│   ├── all.sql
│   ├── customer.sql
│   ├── demo.sql
│   ├── invoice.sql
│   ├── order_detail.sql
│   ├── order.sql
│   ├── product.sql
│   ├── seller.sql
│   ├── stock_detail.sql
│   └── supplier.sql
├── README.md -> ./docs/index.md
└── src
    └── main
        ├── java
        │   └── com
        │       └── demo
        │           └── app
        │               ├── api
        │               │   └── rest
        │               │       └── controllers
        │               │           ├── CustomerController.java
        │               │           ├── InvoiceController.java
        │               │           ├── OrderController.java
        │               │           ├── OrderDetailController.java
        │               │           ├── ProductController.java
        │               │           ├── RestController.java
        │               │           ├── SellerController.java
        │               │           ├── StockDetailController.java
        │               │           └── SupplierController.java
        │               ├── App.java
        │               ├── models
        │               │   ├── dtos
        │               │   │   ├── CustomerDTO.java
        │               │   │   ├── InvoiceDTO.java
        │               │   │   ├── OrderDetailDTO.java
        │               │   │   ├── OrderDTO.java
        │               │   │   ├── ProductDTO.java
        │               │   │   ├── SellerDTO.java
        │               │   │   ├── StockDetailDTO.java
        │               │   │   └── SupplierDTO.java
        │               │   └── entities
        │               │       ├── Customer.java
        │               │       ├── Invoice.java
        │               │       ├── OrderDetail.java
        │               │       ├── Order.java
        │               │       ├── Product.java
        │               │       ├── Seller.java
        │               │       ├── StockDetail.java
        │               │       └── Supplier.java
        │               ├── repository
        │               │   ├── dao
        │               │   │   ├── CustomerDAO.java
        │               │   │   ├── DAO.java
        │               │   │   ├── InvoiceDAO.java
        │               │   │   ├── OrderDAO.java
        │               │   │   ├── OrderDetailDAO.java
        │               │   │   ├── ProductDAO.java
        │               │   │   ├── SellerDAO.java
        │               │   │   ├── StockDetailDAO.java
        │               │   │   └── SupplierDAO.java
        │               │   ├── daoImpl
        │               │   │   ├── CustomerDAOImpl.java
        │               │   │   ├── InvoiceDAOImpl.java
        │               │   │   ├── OrderDAOImpl.java
        │               │   │   ├── OrderDetailDAOImpl.java
        │               │   │   ├── ProductDAOImpl.java
        │               │   │   ├── SellerDAOImpl.java
        │               │   │   ├── StockDetailDAOImpl.java
        │               │   │   └── SupplierDAOImpl.java
        │               │   ├── DatabaseEngine.java
        │               │   └── QueryEngine.java
        │               ├── services
        │               │   ├── abstracts
        │               │   │   ├── CustomerService.java
        │               │   │   ├── InvoiceService.java
        │               │   │   ├── OrderDetailService.java
        │               │   │   ├── OrderService.java
        │               │   │   ├── ProductService.java
        │               │   │   ├── SellerService.java
        │               │   │   ├── Service.java
        │               │   │   ├── StockDetailService.java
        │               │   │   └── SupplierService.java
        │               │   └── implementations
        │               │       ├── CustomerServiceImpl.java
        │               │       ├── InvoiceServiceImpl.java
        │               │       ├── OrderDetailServiceImpl.java
        │               │       ├── OrderServiceImpl.java
        │               │       ├── ProductServiceImpl.java
        │               │       ├── SellerServiceImpl.java
        │               │       ├── StockDetailServiceImpl.java
        │               │       └── SupplierServiceImpl.java
        │               └── views
        ├── resources
        │   └── hibernate.cfg.xml
        └── webapp
            ├── index.jsp
            └── WEB-INF
                └── web.xml
```
