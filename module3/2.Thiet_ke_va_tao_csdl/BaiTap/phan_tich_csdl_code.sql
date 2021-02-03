drop database if exists phan_tich_thiet_ke_csdl;
create database phan_tich_thiet_ke_csdl;
use phan_tich_thiet_ke_csdl;



create table payments(
ma_thanh_toan int primary key,
ngay_thanh_toan date,
so_tien int
);

create table orders(
ma_don_hang int primary key,
ngay_mua date,
ngay_yeu_cau_giao_hang date,
ngay_giao_thuc_te date,
so_luong_don_hang int,
don_gia int
); 



create table customer(
ma_khach_hang int primary key,
ten_khach_hang varchar(30),
so_dien_thoai int,
dia_chi varchar(255),
customer_number int,
foreign key (customer_number) references orders(ma_don_hang),
foreign key (customer_number) references payments(ma_thanh_toan)
);



create table products (
ma_san_pham int primary key,
ten_san_pham varchar(255),
nha_cung_cap varchar(255),
so_luong_kho int,
gia_nhap int,
gia_ban int,
produc_code int,
foreign key (produc_code) references orders(ma_don_hang)
);

create table products_line(
ma_san_pham int primary key,
mo_ta varchar(255),
product_line int,
foreign key (product_line) references products(ma_san_pham)
); 


create table employees(
ma_quan_ly int primary key,
ma_nhan_vien int,
ten_nhanh_vien varchar(30),
email varchar(50),
ten_cong_viecc varchar(255),
employees_number int,
foreign key (employees_number) references customer(ma_khach_hang)
); 

create table offices (
ma_van_phong int primary key,
dia_chi varchar(255),
dien_thoai int,
quoc_gia varchar(255),
offices_code int,
foreign key (offices_code) references employees(ma_quan_ly)
); 

