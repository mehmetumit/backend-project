CREATE DATABASE "DemoDB"
    WITH
    OWNER = demo
    ENCODING = 'UTF8'
    LC_COLLATE = 'en_US.utf8'
    LC_CTYPE = 'en_US.utf8'
    TABLESPACE = pg_default
    CONNECTION LIMIT = -1
    IS_TEMPLATE = False;
CREATE DOMAIN PHONE as CHAR(10)
	CHECK (	VALUE ~ '^\d+$');
CREATE DOMAIN EMAIL AS VARCHAR(254)
  CHECK ( VALUE ~ '^[a-zA-Z0-9.!#$%&''*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$' );
CREATE TABLE IF NOT EXISTS "customer" (
	customer_id serial PRIMARY KEY,
	customer_name VARCHAR(100) NOT NULL,
	surname VARCHAR(100) NOT NULL,
	phone_num PHONE NOT NULL,
	email EMAIL NOT NULL,
	discount_rate SMALLINT CHECK(discount_rate > 0) NOT NULL,
	is_active BOOL DEFAULT TRUE
);
CREATE TABLE IF NOT EXISTS "order"(
	order_id SERIAL PRIMARY KEY,
	customer_id INT REFERENCES customer NOT NULL,
	order_timestamp TIMESTAMP NOT NULL
);
CREATE TABLE IF NOT EXISTS "orderDetails"(
	order_details_id SERIAL PRIMARY KEY,
	order_id INT REFERENCES "order" NOT NULL,
	quantity INT CHECK(quantity > 0) DEFAULT 0
);
CREATE TABLE IF NOT EXISTS "category"(
	category_id SERIAL PRIMARY KEY,
	category_name VARCHAR(255) NOT NULL
);
CREATE TABLE IF NOT EXISTS "product"(
	product_id SERIAL PRIMARY KEY,
	order_details INT REFERENCES "orderDetails" NOT NULL,
	category_id INT REFERENCES "category" NOT NULL,
	product_name VARCHAR(255) NOT NULL,
	unit_price MONEY NOT NULL,
	is_active BOOL DEFAULT TRUE NOT NULL
);
CREATE TABLE IF NOT EXISTS "supplier"(
	supplier_id SERIAL PRIMARY KEY,
	address VARCHAR(255),
	phone_num PHONE NOT NULL,
	is_active BOOL DEFAULT TRUE NOT NULL
);
CREATE TABLE IF NOT EXISTS "stockDetails"(
	stock_id SERIAL PRIMARY KEY,
	product_id INT REFERENCES "product",
	supplier_id INT REFERENCES "supplier",
	quantity INT CHECK(quantity > 0)
);
CREATE TABLE IF NOT EXISTS "seller"(
	seller_id SERIAL PRIMARY KEY,
	address VARCHAR(255),
	phone_num PHONE NOT NULL,
	email_addr EMAIL NOT NULL,
	fax VARCHAR(255) DEFAULT '' NOT NULL,
	is_active BOOL DEFAULT TRUE NOT NULL
);
CREATE TABLE IF NOT EXISTS "invoice"(
	invoice_id SERIAL PRIMARY KEY,
	order_id INT REFERENCES "order" NOT NULL,
	seller_id INT REFERENCES "seller" NOT NULL,
	invoice_timestamp TIMESTAMP NOT NULL,
	due_timestamp TIMESTAMP NOT NULL,
	sub_total MONEY NOT NULL,
	discount MONEY DEFAULT 0 NOT NULL,
	tax_rate SMALLINT DEFAULT 0 CHECK (tax_rate > 0) NOT NULL,
	total_tax MONEY DEFAULT 0,
	total_price MONEY 
);
