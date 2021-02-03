create database categories;
use categories;
create table categories1(
id int primary key,
name varchar(50),
description varchar(500)
);
create table suppliers(
id int primary key,
name varchar(100),
email varchar(50),
phone_number varchar(50),
address varchar(500)
);
create table customers(
id varchar(50) primary key, 
first_name varchar(50),
last_name varchar(50),
phone_number varchar(50),
address varchar(500),
email varchar(50),
brithday date
);
create table employess(
id varchar(50),
first_name varchar(50),
last_name varchar(50),
phone_number varchar(50),
addresss varchar(255),
email varchar(50),
birthday date
);
create table product(
id int primary key,
name varchar(50),
umage_url varchar(1000),
price int,
discount int,
stock int,
category_id int,
supplier_id int,
description varchar(255)
);
create table orders(
id int primary key,
created_date datetime,
shipped_date datetime,
status varchar(50),
 description varchar(255),
shipping_address varchar(500),
shipping_city  varchar(50),
payment_type varchar(20),
customer_id varchar(50),
employess_id varchar(50) 
);
create table order_details(
id int primary key,
order_id int,
product_id int,
quantity int
);
create table bang(
ID int NOT NULL,
    LastName varchar(255) NOT NULL,
    FirstName varchar(255),
    Age int,
    CONSTRAINT UC_Person UNIQUE (ID,LastName)
); 
drop table bang;


