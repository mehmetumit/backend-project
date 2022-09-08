# File Tree

```sh
.
├── docker-compose.yml
├── docs
│   ├── api.md
│   ├── arch.md
│   ├── ER.md
│   ├── file-tree.md
│   ├── img
│   │   ├── architecture.png
│   │   ├── dbeaver1.png
│   │   ├── dbeaver2.png
│   │   ├── dbeaver3.png
│   │   ├── dbeaver4.png
│   │   ├── dbeaver5.png
│   │   ├── ER.png
│   │   ├── pgadmin1.png
│   │   ├── pgadmin2.png
│   │   ├── pgadmin3.png
│   │   ├── pgadmin4.png
│   │   └── pgadmin5.png
│   ├── index.md
│   ├── inspect-database.md
│   ├── rest_collection.json
│   └── usage.md
├── mkdocs.yml
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
├── src
│   └── main
│       ├── java
│       │   └── com
│       │       └── demo
│       │           └── app
│       │               ├── api
│       │               │   └── rest
│       │               │       └── controllers
│       │               │           ├── CustomerController.java
│       │               │           ├── InvoiceController.java
│       │               │           ├── OrderController.java
│       │               │           ├── OrderDetailController.java
│       │               │           ├── ProductController.java
│       │               │           ├── RestController.java
│       │               │           ├── SellerController.java
│       │               │           ├── StockDetailController.java
│       │               │           └── SupplierController.java
│       │               ├── App.java
│       │               ├── models
│       │               │   ├── dtos
│       │               │   │   ├── CustomerDTO.java
│       │               │   │   ├── InvoiceDTO.java
│       │               │   │   ├── OrderDetailDTO.java
│       │               │   │   ├── OrderDTO.java
│       │               │   │   ├── ProductDTO.java
│       │               │   │   ├── SellerDTO.java
│       │               │   │   ├── StockDetailDTO.java
│       │               │   │   └── SupplierDTO.java
│       │               │   └── entities
│       │               │       ├── Customer.java
│       │               │       ├── Invoice.java
│       │               │       ├── OrderDetail.java
│       │               │       ├── Order.java
│       │               │       ├── Product.java
│       │               │       ├── Seller.java
│       │               │       ├── StockDetail.java
│       │               │       └── Supplier.java
│       │               ├── repository
│       │               │   ├── dao
│       │               │   │   ├── CustomerDAO.java
│       │               │   │   ├── DAO.java
│       │               │   │   ├── InvoiceDAO.java
│       │               │   │   ├── OrderDAO.java
│       │               │   │   ├── OrderDetailDAO.java
│       │               │   │   ├── ProductDAO.java
│       │               │   │   ├── SellerDAO.java
│       │               │   │   ├── StockDetailDAO.java
│       │               │   │   └── SupplierDAO.java
│       │               │   ├── daoImpl
│       │               │   │   ├── CustomerDAOImpl.java
│       │               │   │   ├── InvoiceDAOImpl.java
│       │               │   │   ├── OrderDAOImpl.java
│       │               │   │   ├── OrderDetailDAOImpl.java
│       │               │   │   ├── ProductDAOImpl.java
│       │               │   │   ├── SellerDAOImpl.java
│       │               │   │   ├── StockDetailDAOImpl.java
│       │               │   │   └── SupplierDAOImpl.java
│       │               │   ├── DatabaseEngine.java
│       │               │   └── QueryEngine.java
│       │               ├── services
│       │               │   ├── abstracts
│       │               │   │   ├── CustomerService.java
│       │               │   │   ├── InvoiceService.java
│       │               │   │   ├── OrderDetailService.java
│       │               │   │   ├── OrderService.java
│       │               │   │   ├── ProductService.java
│       │               │   │   ├── SellerService.java
│       │               │   │   ├── Service.java
│       │               │   │   ├── StockDetailService.java
│       │               │   │   └── SupplierService.java
│       │               │   └── implementations
│       │               │       ├── CustomerServiceImpl.java
│       │               │       ├── InvoiceServiceImpl.java
│       │               │       ├── OrderDetailServiceImpl.java
│       │               │       ├── OrderServiceImpl.java
│       │               │       ├── ProductServiceImpl.java
│       │               │       ├── SellerServiceImpl.java
│       │               │       ├── StockDetailServiceImpl.java
│       │               │       └── SupplierServiceImpl.java
│       │               └── views
│       ├── resources
│       │   └── hibernate.cfg.xml
│       └── webapp
│           ├── index.jsp
│           └── WEB-INF
│               └── web.xml
└── tools
    └── gen-file-tree.sh

```
