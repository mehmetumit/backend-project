CREATE DATABASE "demodb"
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
CREATE TABLE "customer" (
	id serial PRIMARY KEY,
	name VARCHAR(100) NOT NULL,
	surname VARCHAR(100) NOT NULL,
	phone_num PHONE NOT NULL,
	email EMAIL NOT NULL,
	discount_rate SMALLINT CHECK(discount_rate > 0) NOT NULL,
	is_active BOOL DEFAULT TRUE
);
CREATE TABLE "order"(
	id SERIAL PRIMARY KEY,
	customer_id INT REFERENCES customer(id),
	order_timestamp TIMESTAMP NOT NULL
);
CREATE TABLE "product"(
	id SERIAL PRIMARY KEY,
	category_name VARCHAR(255) NOT NULL,
	name VARCHAR(255) NOT NULL,
	unit_price NUMERIC(12,2) DEFAULT 0 NOT NULL,
	is_active BOOL DEFAULT TRUE NOT NULL
);
CREATE TABLE "order_detail"(
	id SERIAL PRIMARY KEY,
	order_id INT REFERENCES "order"(id),
	product_id INT REFERENCES product(id),
	quantity INT CHECK(quantity > 0) DEFAULT 0
);
CREATE TABLE "supplier"(
	id SERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	address VARCHAR(255) NOT NULL,
	phone_num PHONE NOT NULL,
	is_active BOOL DEFAULT TRUE NOT NULL
);
CREATE TABLE "stock_detail"(
	id SERIAL PRIMARY KEY,
	product_id INT REFERENCES product(id),
	supplier_id INT REFERENCES supplier(id),
	quantity INT CHECK(quantity >= 0) DEFAULT 0
);
CREATE TABLE "seller"(
	id SERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	address VARCHAR(255) NOT NULL,
	phone_num PHONE NOT NULL,
	email EMAIL NOT NULL,
	fax VARCHAR(255) DEFAULT '' NOT NULL,
	is_active BOOL DEFAULT TRUE NOT NULL
);
CREATE TABLE "invoice"(
	id SERIAL PRIMARY KEY,
	order_id INT REFERENCES "order"(id),
	seller_id INT REFERENCES seller(id),
	invoice_timestamp TIMESTAMP NOT NULL,
	due_timestamp TIMESTAMP NOT NULL,
	sub_total NUMERIC(12,2) DEFAULT 0,
	discount NUMERIC(12,2) DEFAULT 0,
	tax_rate SMALLINT DEFAULT 0 CHECK (tax_rate >= 0),
	total_tax NUMERIC(12,2) GENERATED ALWAYS AS (sub_total * tax_rate / 100) STORED,
	total_price NUMERIC(12,2) GENERATED ALWAYS AS (sub_total - discount + sub_total * tax_rate / 100) STORED
);
CREATE OR REPLACE FUNCTION calculate_sub_total()
	RETURNS trigger
	LANGUAGE plpgsql AS
$$
BEGIN
	NEW.sub_total := (select SUM(unit_price * quantity) from "order" left join order_detail on "order".id = order_detail.order_id left join product on order_detail.product_id = product.id where "order".id = NEW.order_id);
	RETURN NEW;
END;
$$;
		
CREATE TRIGGER invoice_insert_trigger
	BEFORE INSERT
	ON "invoice"
	FOR EACH ROW
	EXECUTE PROCEDURE calculate_sub_total();
