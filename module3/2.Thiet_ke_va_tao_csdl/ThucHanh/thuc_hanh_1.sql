create database thuc_hanh;
use thuc_hanh;
create table name_ten(
contact_id int(11) not null  auto_increment,
last_name varchar(255) not null,
first_name varchar(255) not null,
birthday date,
constraint contact_pk primary key(contact_id)
);
drop table name_ten;
create table suppliers(
suppliers_id int(11) not null auto_increment,
suppliers_name varchar(50) not null,
account_rep varchar(50) not null default 'dtn',
constraint suppliers_pk primary key (suppliers_id)
);

drop table name_ten,suppliers;
alter table suppliers add email varchar(40) not null  after suppliers_id;
alter table suppliers modify email varchar(50) not null;
alter table suppliers drop column email;
create index idId1 on suppliers(suppliers_id);