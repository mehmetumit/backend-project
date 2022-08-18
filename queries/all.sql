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
	customer_id INT REFERENCES customer(id) NOT NULL,
	order_timestamp TIMESTAMP NOT NULL
);
CREATE TABLE "order_detail"(
	id SERIAL PRIMARY KEY,
	order_id INT REFERENCES "order"(id) NOT NULL,
	quantity INT CHECK(quantity > 0) DEFAULT 0
);
CREATE TABLE "product"(
	id SERIAL PRIMARY KEY,
	order_detail_id INT REFERENCES order_detail(id) NOT NULL,
	category_name VARCHAR(255) NOT NULL,
	name VARCHAR(255) NOT NULL,
	unit_price NUMERIC(12,2) DEFAULT 0 NOT NULL,
	is_active BOOL DEFAULT TRUE NOT NULL
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
	product_id INT REFERENCES product(id) NOT NULL,
	supplier_id INT REFERENCES supplier(id) NOT NULL,
	quantity INT CHECK(quantity >= 0) DEFAULT 0
);
CREATE TABLE "seller"(
	id SERIAL PRIMARY KEY,
	name VARCHAR(255) NOT NULL,
	address VARCHAR(255) NOT NULL,
	phone_num PHONE NOT NULL,
	email_addr EMAIL NOT NULL,
	fax VARCHAR(255) DEFAULT '' NOT NULL,
	is_active BOOL DEFAULT TRUE NOT NULL
);
CREATE TABLE "invoice"(
	id SERIAL PRIMARY KEY,
	order_id INT REFERENCES "order"(id) NOT NULL,
	seller_id INT REFERENCES seller(id) NOT NULL,
	invoice_timestamp TIMESTAMP NOT NULL,
	due_timestamp TIMESTAMP NOT NULL,
	sub_total NUMERIC(12,2) DEFAULT 0 NOT NULL,
	discount NUMERIC(12,2) DEFAULT 0 NOT NULL,
	tax_rate SMALLINT DEFAULT 0 CHECK (tax_rate >= 0) NOT NULL,
	total_tax NUMERIC(12,2) GENERATED ALWAYS AS (sub_total * tax_rate / 100) STORED,
	total_price NUMERIC(12,2) GENERATED ALWAYS AS (sub_total - discount + sub_total * tax_rate / 100) STORED
);
CREATE OR REPLACE FUNCTION calculate_sub_total()
	RETURNS trigger
	LANGUAGE plpgsql AS
$$
BEGIN
	NEW.sub_total := (select SUM(unit_price * quantity) from "order" left join order_detail on "order".id = order_detail.order_id left join product on order_detail.id = product.order_detail_id where "order".id = NEW.order_id);
	RETURN NEW;
END;
$$;

CREATE TRIGGER invoice_insert_trigger
	BEFORE INSERT
	ON "invoice"
	FOR EACH ROW
	EXECUTE PROCEDURE calculate_sub_total();
INSERT INTO customer(name, surname, phone_num, email, discount_rate, is_active) VALUES('Mehmet Ümit', 'Özden', '5554443333', 'mehmetumit@domain.com', 20, true );
INSERT INTO customer(name, surname, phone_num, email, discount_rate) VALUES('Tugay', 'Yıldız', '5556667777', 'tugayyildiz@domain.com', 25);
INSERT INTO customer(name, surname, phone_num, email, discount_rate, is_active) VALUES('Michael', 'Stonebraker', '7773334458', 'postgresql@domain.com', 10,false );
INSERT INTO customer(name, surname, phone_num, email, discount_rate, is_active) VALUES('Brian', 'Kernighan', '6668884445', 'cprogramming@domain.com', 10, true );
INSERT INTO customer(name, surname, phone_num, email, discount_rate, is_active) VALUES('Nikola', 'Tesla', '4446665632', 'tesla@domain.com', 15, false );
INSERT INTO customer(name, surname, phone_num, email, discount_rate, is_active) VALUES('Richard', 'Stallman', '8883334535', 'gnu@domain.com', 21, true );
INSERT INTO customer(name, surname, phone_num, email, discount_rate, is_active) VALUES('Linus', 'Torvalds', '9696432565', 'linux@domain.com', 14, true );
INSERT INTO "order"(customer_id, order_timestamp) VALUES(1, '2022-08-15 10:00:04');
INSERT INTO "order"(customer_id, order_timestamp) VALUES(1, '2022-08-15 09:00:04');
INSERT INTO "order"(customer_id, order_timestamp) VALUES(1, '2022-08-15 11:00:04');
INSERT INTO "order"(customer_id, order_timestamp) VALUES(1, '2022-08-15 12:00:04');
INSERT INTO "order"(customer_id, order_timestamp) VALUES(1, '2022-08-15 13:00:04');
INSERT INTO "order"(customer_id, order_timestamp) VALUES(2, '2022-08-15 10:00:04');
INSERT INTO "order"(customer_id, order_timestamp) VALUES(2, '2022-08-15 09:00:04');
INSERT INTO "order"(customer_id, order_timestamp) VALUES(2, '2022-08-15 11:00:04');
INSERT INTO "order"(customer_id, order_timestamp) VALUES(2, '2022-08-15 12:00:04');
INSERT INTO "order"(customer_id, order_timestamp) VALUES(2, '2022-08-15 13:00:04');
INSERT INTO "order"(customer_id, order_timestamp) VALUES(3, '2022-08-15 12:00:04');
INSERT INTO "order"(customer_id, order_timestamp) VALUES(3, '2022-08-15 13:00:04');
INSERT INTO "order"(customer_id, order_timestamp) VALUES(4, '2022-08-15 10:00:04');
INSERT INTO "order"(customer_id, order_timestamp) VALUES(4, '2022-08-15 09:00:04');
INSERT INTO order_detail(order_id, quantity) VALUES(1, 100);
INSERT INTO order_detail(order_id, quantity) VALUES(1, 20);
INSERT INTO order_detail(order_id, quantity) VALUES(1, 30);
INSERT INTO order_detail(order_id, quantity) VALUES(1, 40);
INSERT INTO order_detail(order_id, quantity) VALUES(1, 50);
INSERT INTO order_detail(order_id, quantity) VALUES(1, 60);
INSERT INTO order_detail(order_id, quantity) VALUES(2, 16);
INSERT INTO order_detail(order_id, quantity) VALUES(3, 12);
INSERT INTO order_detail(order_id, quantity) VALUES(4, 23);
INSERT INTO order_detail(order_id, quantity) VALUES(5, 42);
INSERT INTO order_detail(order_id, quantity) VALUES(6, 18);
INSERT INTO product(order_detail_id, category_name, name, unit_price, is_active) VALUES(1, 'Yoğurt', 'Kova Yoğurt 2000g', 36.95, true );
INSERT INTO product(order_detail_id, category_name, name, unit_price, is_active) VALUES(2, 'Peynir', 'Kaşar Peyniri 400g', 48.95, false );
INSERT INTO product(order_detail_id, category_name, name, unit_price, is_active) VALUES(3, 'Yoğurt', 'Kaymaklı Tava Yoğurt 1000g', 29.95, true );
INSERT INTO product(order_detail_id, category_name, name, unit_price, is_active) VALUES(4, 'Yoğurt', 'Efsane Yoğurt 350g', 12.95, true );
INSERT INTO product(order_detail_id, category_name, name, unit_price, is_active) VALUES(5, 'Yoğurt', 'Süzme Yoğurt 250g', 25.95, false );
INSERT INTO product(order_detail_id, category_name, name, unit_price, is_active) VALUES(6, 'Ayran', 'Eker Ayran 1000ml', 13.95, true );
INSERT INTO product(order_detail_id, category_name, name, unit_price, is_active) VALUES(7, 'Kefir', 'Ananaslı Kefir 200ml', 6.95, true );
INSERT INTO product(order_detail_id, category_name, name, unit_price, is_active) VALUES(8, 'Tatlı', 'Keşkül 150g', 9.95, true );
INSERT INTO product(order_detail_id, category_name, name, unit_price, is_active) VALUES(9, 'Fırsat Paketleri', 'Sakızlı Muhallebi 6x150g', 49.75, true );
INSERT INTO product(order_detail_id, category_name, name, unit_price, is_active) VALUES(10, 'Tatlı', 'Antep Fıstıklı Sütlü Çikolatalı Tatlı', 9.95, true );
INSERT INTO product(order_detail_id, category_name, name, unit_price, is_active) VALUES(11, 'Tatlı', 'Hoşmerim 150g', 9.95, true );
INSERT INTO seller(name, address, phone_num, email_addr, fax, is_active) VALUES('Migros', 'Örnek Mah. Deneme Sk. No:34 Ankara', '5865934392', 'migros@domain.com', '', true);
INSERT INTO seller(name, address, phone_num, email_addr, fax, is_active) VALUES('Seyhanler', 'Konak Mah. Çiçek Sk. No:12 Bursa', '5358323481', 'seyhanlar@domain.com', '02123413223@fax.demo', true);
INSERT INTO seller(name, address, phone_num, email_addr, fax, is_active) VALUES('Yunus', 'Kanaryalı Mah. Badem Sk. No:2 Ankara', '2223456312', 'yunus@domain.com', '02543234643@fax.demo', false);
INSERT INTO seller(name, address, phone_num, email_addr, fax, is_active) VALUES('Carrefour', 'Odunluk Mah. Gülbahçe Sk. No:1 Bursa', '2334534534', 'carrefour@domain.com', '022345435434fax.demo', true);
INSERT INTO seller(name, address, phone_num, email_addr, fax, is_active) VALUES('Bim', 'Alageyik Mah. Papatya Sk. No:3 Bursa', '2545345345', 'bim@domain.com', '', false);
INSERT INTO supplier(name, address, phone_num, is_active) VALUES('Eker Bursa Depo', 'Odunluk Mahallesi Erdoğan Bin Yücel Cad. 13/A, 16110 Nilüfer', '2223334445', true);
INSERT INTO supplier(name, address, phone_num, is_active) VALUES('Eker Kocaeli Depo', 'Mahmutpaşa, Eski Bağdat Yolu No:23, 41040 Başiskele/Kocaeli', '5345629445', true);
INSERT INTO supplier(name, address, phone_num, is_active) VALUES('Eker Edirne Depo', '22130 Sazlıdere/Edirne Merkez/Edirne', '5863234234', false);
INSERT INTO supplier(name, address, phone_num, is_active) VALUES('Eker Sakarya Depo', 'Tekeler, D:020, 54100 Adapazarı/Sakarya', '2345623465', true);
INSERT INTO supplier(name, address, phone_num, is_active) VALUES('Eker Isparta Depo', 'Sanayi, 32200 Isparta Merkez/Isparta', '5365483284', false);
INSERT INTO stock_detail(product_id, supplier_id, quantity) VALUES(11, 1, 2000);
INSERT INTO stock_detail(product_id, supplier_id, quantity) VALUES(1, 1, 1244);
INSERT INTO stock_detail(product_id, supplier_id, quantity) VALUES(2, 2, 3234);
INSERT INTO stock_detail(product_id, supplier_id, quantity) VALUES(3, 3, 1384);
INSERT INTO stock_detail(product_id, supplier_id, quantity) VALUES(4, 4, 1234);
INSERT INTO stock_detail(product_id, supplier_id, quantity) VALUES(5, 5, 3428);
INSERT INTO stock_detail(product_id, supplier_id, quantity) VALUES(6, 1, 2346);
INSERT INTO stock_detail(product_id, supplier_id, quantity) VALUES(7, 2, 1238);
INSERT INTO stock_detail(product_id, supplier_id, quantity) VALUES(8, 3, 1260);
INSERT INTO stock_detail(product_id, supplier_id, quantity) VALUES(9, 4, 1400);
INSERT INTO stock_detail(product_id, supplier_id, quantity) VALUES(10, 5, 3000);
INSERT INTO invoice(order_id, seller_id, invoice_timestamp, due_timestamp, discount, tax_rate) VALUES(1, 1,  '2022-08-15 11:10:14',  '2022-09-16 19:00:00', 10, 8  );
INSERT INTO invoice(order_id, seller_id, invoice_timestamp, due_timestamp, discount, tax_rate) VALUES(1, 4,  '2022-08-15 11:10:14',  '2022-09-16 15:00:00', 10, 8  );
INSERT INTO invoice(order_id, seller_id, invoice_timestamp, due_timestamp, discount, tax_rate) VALUES(1, 2,  '2022-08-15 11:10:14',  '2022-09-16 12:00:00', 10, 8  );
INSERT INTO invoice(order_id, seller_id, invoice_timestamp, due_timestamp, discount, tax_rate) VALUES(1, 3,  '2022-08-15 11:10:14',  '2022-09-16 13:00:00', 10, 8  );
INSERT INTO invoice(order_id, seller_id, invoice_timestamp, due_timestamp, discount, tax_rate) VALUES(2, 1,  '2022-08-15 11:10:53',  '2023-09-16 16:00:00', 10, 8  );
INSERT INTO invoice(order_id, seller_id, invoice_timestamp, due_timestamp, discount, tax_rate) VALUES(2, 1,  '2022-06-09 10:10:31',  '2025-09-16 13:00:00', 10, 8  );
INSERT INTO invoice(order_id, seller_id, invoice_timestamp, due_timestamp, discount, tax_rate) VALUES(2, 4,  '2022-06-10 13:10:29',  '2024-09-16 15:00:00', 10, 8  );
INSERT INTO invoice(order_id, seller_id, invoice_timestamp, due_timestamp, discount, tax_rate) VALUES(3, 1,  '2021-02-13 14:00:16',  '2023-10-16 11:00:00', 10, 8  );
INSERT INTO invoice(order_id, seller_id, invoice_timestamp, due_timestamp, discount, tax_rate) VALUES(3, 2,  '2021-08-11 11:00:11',  '2023-09-16 13:00:00', 10, 8  );
