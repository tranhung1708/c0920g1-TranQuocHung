create database thi_module_3;
use thi_module_3;

create table benh_nhan(
ma_benh_nhan int primary key,
ten_benh_nhan varchar(45)
);


create table benh_an(
ma_benh_an int primary key,
ma_benh_nhan int,
ngay_nhap_vien date,
ngay_ra_vien date,
ly_do_nhap_vien varchar(45),
foreign key(ma_benh_nhan) references benh_nhan(ma_benh_nhan)
);


