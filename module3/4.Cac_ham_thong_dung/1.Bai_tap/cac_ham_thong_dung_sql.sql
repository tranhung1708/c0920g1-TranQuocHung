create database bai_tap_ham_sql;
use bai_tap_ham_sql;

create table hoc_vien(
id int primary key ,
ten varchar(35),
tuoi int,
khoa_hoc varchar(155),
so_tien int
);

drop table hoc_vien;

insert into hoc_vien (id,ten,tuoi,khoa_hoc,so_tien) values(1,'hoang',20 , 'CNTT' , 400000),
(2,'viet' ,19, 'DTVT' , 320000),
(3 , 'THANH', 18, 'KTDN' , 400000),
(4, 'NHAN' , '19' , 'CK' , 450000),
(5, 'HUONG' , 20 , 'TCNH' , 500000),
(6 , 'HUONG' , 20 , 'TCNH' , 200000);

select count(ten) from hoc_vien where ten = 'huong';

select sum(so_tien) from hoc_vien where ten = 'huong';

select distinct ten from hoc_vien;