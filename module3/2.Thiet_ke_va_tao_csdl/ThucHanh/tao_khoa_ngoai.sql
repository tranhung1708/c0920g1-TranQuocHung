create database customers;
use customers;
create table customer(
id int auto_increment primary key,
`name` varchar(40),
address varchar(225),
email varchar(255)
);

create table oders (
id int auto_increment ,
staff  varchar(50),
primary key (id),
customer_id int,
foreign key (customer_id) references customer(id) 
);