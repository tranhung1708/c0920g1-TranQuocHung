drop database if exists bai_tap;
create database bai_tap ;
use bai_tap;

create table hoc_sinh (
ma_the int primary key,
the_sinh_vien int ,
ngay_sinh date,
dia_chi varchar(255),
email varchar(255),
so_dien_thoai int,
anh blob
);

create table book(
ma_sach int primary key,
ten_sach varchar(255),
ma_the int,
foreign key (ma_the) references hoc_sinh (ma_the)
);

create table trang_thai_muon_sach (
ma_trang_thai int primary key ,
tinh_trang varchar(255),
ma_the int,
ma_sach int,
foreign key (ma_the) references hoc_sinh (ma_the),
foreign key (ma_sach) references book (ma_sach)
);

create table thu_vien(
id_thu_vien int primary key ,
sinh_vien varchar(30)not null,
sach varchar(255) not null,
ma_the int,
ma_sach int,
ma_trang_thai int,
foreign key (ma_the) references hoc_sinh (ma_the),
foreign key (ma_sach) references book (ma_sach),
foreign key (ma_trang_thai) references trang_thai_muon_sach (ma_trang_thai)
);






