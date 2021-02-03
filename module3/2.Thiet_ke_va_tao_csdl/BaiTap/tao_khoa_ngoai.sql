drop database if exists baitap;
create database baitap;
use baitap;

create table accounts(
so_tai_khoan int primary key,
kieu_so_tai_khoan varchar(50),
check (kieu_so_tai_khoan = 'vip'),
check (kieu_so_tai_khoan = 'thuong'),
check (kieu_so_tai_khoan = 'doanh nghiep'),
ngay_mo_the date,
so_du_tai_khoan int
);

create table customers(
ma_khanh_hang int not null ,
ten_khach_hang varchar(40),
email varchar(30),
so_dien_thoai int ,
customer_number int,
FOREIGN KEY (customer_number) REFERENCES accounts(so_tai_khoan)
);


create table transactions(
ma_giao_dich int primary key,
so_tien int not null,
thoi_gian date,
mo_ta varchar(255),
account_number  int ,
foreign key (account_number) references accounts(so_tai_khoan)
);