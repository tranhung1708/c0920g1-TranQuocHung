-- drop database if exists case_study;
create database case_study;
use case_study;
create table vi_tri(
id_vi_tri int PRIMARY KEY,
ten_vi_tri varchar(45)
);
create table trinh_do(
id_trinh_do int PRIMARY KEY,
trinh_do varchar(45)
);
create table bo_phan(
id_bo_phan int PRIMARY KEY,
ten_bo_phan varchar(45)
);
create table nhan_vien(
id_nhan_vien int PRIMARY KEY,
ho_ten varchar(45),
id_vi_tri int,
id_trinh_do int,
id_bo_phan int,
ngay_sinh date,
so_cmnd varchar(45),
luong varchar(45),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45),
FOREIGN KEY (id_vi_tri) REFERENCES vi_tri(id_vi_tri),
FOREIGN KEY (id_trinh_do) REFERENCES trinh_do(id_trinh_do),
FOREIGN KEY (id_bo_phan) REFERENCES bo_phan(id_bo_phan)
);
create table dich_vu_di_kem(
id_dich_vu_di_kem int PRIMARY KEY,
ten_dich_vu_di_kem varchar(45),
gia int,
don_vi int,
trang_thai_kha_dung varchar(45)
);
create table loai_khach(
id_loai_khach int PRIMARY KEY,
ten_loai_khach varchar(45)
);
create table khach_hang(
id_khach_hang int PRIMARY KEY,
id_loai_khach int,
ho_ten varchar(45),
ngay_sinh date,
so_cmnd varchar(45),
sdt varchar(45),
email varchar(45),
dia_chi varchar(45),
FOREIGN KEY (id_loai_khach) REFERENCES loai_khach(id_loai_khach)
);
create table kieu_thue(
id_kieu_thue int PRIMARY KEY,
ten_kieu_thue varchar(45),
gia int
);
create table loai_dich_vu(
id_loai_dich_vu int PRIMARY KEY,
ten_loai_dich_vu varchar(45)
);
create table dich_vu(
id_dich_vu int PRIMARY KEY,
ten_dich_vu varchar(45),
dien_tich int,
so_tang int,
so_nguoi_toi_da varchar(45),
chi_phi_thue varchar(45),
id_kieu_thue int,
id_loai_dich_vu int,
trang_thai varchar(45),
FOREIGN KEY (id_kieu_thue) REFERENCES kieu_thue(id_kieu_thue),
FOREIGN KEY (id_loai_dich_vu) REFERENCES loai_dich_vu(id_loai_dich_vu)
);
create table hop_dong(
id_hop_dong int PRIMARY KEY,
id_nhan_vien int,
id_khach_hang int,
id_dich_vu int,
ngay_lam_hop_dong date,
ngay_ket_thuc date,
tien_dat_coc int,
tong_tien int,
FOREIGN KEY (id_nhan_vien) REFERENCES nhan_vien(id_nhan_vien),
FOREIGN KEY (id_khach_hang) REFERENCES khach_hang(id_khach_hang),
FOREIGN KEY (id_dich_vu) REFERENCES dich_vu(id_dich_vu)
);
create table hop_dong_chi_tiet(
id_hop_dong_chi_tiet int PRIMARY KEY,
id_hop_dong int,
id_dich_vu_di_kem int,
so_luong int,
FOREIGN KEY (id_dich_vu_di_kem) REFERENCES dich_vu_di_kem(id_dich_vu_di_kem),
FOREIGN KEY (id_hop_dong) REFERENCES hop_dong(id_hop_dong)
);

insert into bo_phan (id_bo_phan, ten_bo_phan )
value (1,'le tan');

insert into bo_phan (id_bo_phan, ten_bo_phan )
value (2,'giám đốc');

insert into bo_phan (id_bo_phan, ten_bo_phan )
value (3,'nhân viên');

insert into bo_phan (id_bo_phan, ten_bo_phan )
value (4,'chủ tịch');

insert into vi_tri (id_vi_tri , ten_vi_tri)
value (1 , 'giám đốc');

insert into vi_tri (id_vi_tri , ten_vi_tri)
value (2, 'nhân viên');

insert into vi_tri (id_vi_tri , ten_vi_tri)
value (3 , 'dọn vệ sinh');

insert into trinh_do (id_trinh_do , trinh_do)
value(1,'cao đẳng');

insert into  trinh_do (id_trinh_do,trinh_do)
value(2,'đại học');

insert into  trinh_do (id_trinh_do,trinh_do)
value(3,'tiến sĩ');

insert into  trinh_do (id_trinh_do,trinh_do)
value(4,'thạc sĩ');


insert into nhan_vien (id_nhan_vien , ho_ten , id_vi_tri , id_trinh_do , id_bo_phan , ngay_sinh, so_cmnd ,luong , sdt , email , dia_chi)
value (1,1 , 1 , 1, 1 , '1999-12-12' , 123123123 , 123123123 ,12312312 , 'abc@abc.com' , 'đà nẵng');

insert into nhan_vien (id_nhan_vien , ho_ten , id_vi_tri , id_trinh_do , id_bo_phan , ngay_sinh, so_cmnd ,luong , sdt , email , dia_chi)
value (2,2 , 2 , 2, 2 , '1999-12-12' , 123123123 , 123123123 ,12312312 , 'abc@abc.com' , 'đà nẵng');

insert into nhan_vien (id_nhan_vien , ho_ten , id_vi_tri , id_trinh_do , id_bo_phan , ngay_sinh, so_cmnd ,luong , sdt , email , dia_chi)
value (3,3 , 3 , 3, 3 , '1999-12-12' , 123123123 , 123123123 ,12312312 , 'abc@abc.com' , 'quảng nam');

insert into nhan_vien (id_nhan_vien , ho_ten , id_vi_tri , id_trinh_do , id_bo_phan , ngay_sinh, so_cmnd ,luong , sdt , email , dia_chi)
value (4,4 , 4 , 4, 4 , '1999-12-12' , 123123123 , 123123123 ,12312312 , 'abc@abc.com' , 'đà nẵng');

insert into loai_khach (id_loai_khach, ten_loai_khach)
value (1,'Mai nam khánh');

insert into loai_khach (id_loai_khach, ten_loai_khach)
value (2,'Trần Quốc Hưng');

insert into loai_khach (id_loai_khach, ten_loai_khach)
value (3,'Nguyễn Văn Phúc');

insert into loai_khach (id_loai_khach, ten_loai_khach)
value (4,'Lê nguyễn Phúc Khang');

insert into khach_hang (id_khach_hang, id_loai_khach, ho_ten , ngay_sinh , so_cmnd , sdt , email , dia_chi)
value (1,1,'Mai Nam Khanh' , '2000-12-12' , 1313213213,1312312, 'abc@anc.com' , 'đà nẵng');

insert into khach_hang (id_khach_hang, id_loai_khach, ho_ten , ngay_sinh , so_cmnd , sdt , email , dia_chi)
value (2,2,'Trần Quốc HƯng' , '2002-12-12' , 1313213213,1312312, 'abc@anc.com' , 'quảng binh');

insert into khach_hang (id_khach_hang, id_loai_khach, ho_ten , ngay_sinh , so_cmnd , sdt , email , dia_chi)
value (3,3,'Nguyễn Văn Phúc' , '1999-12-12' , 1313213213,1312312, 'abc@anc.com' , 'đà nẵng');

insert into khach_hang (id_khach_hang, id_loai_khach, ho_ten , ngay_sinh , so_cmnd , sdt , email , dia_chi)
value (4,4,'Lê Nguyễn Phúc Khang' , '1997-12-12' , 1313213213,1312312, 'abc@anc.com' , 'Hội An');

insert into dich_vu_di_kem (id_dich_vu_di_kem , ten_dich_vu_di_kem , gia , don_vi , trang_thai_kha_dung)
value (1,'vip' , 123333,123123 , 'trong');

insert into dich_vu_di_kem (id_dich_vu_di_kem , ten_dich_vu_di_kem , gia , don_vi , trang_thai_kha_dung)
value (2,'thường' , 123333,123123 , 'trong');

insert into dich_vu_di_kem (id_dich_vu_di_kem , ten_dich_vu_di_kem , gia , don_vi , trang_thai_kha_dung)
value (3,'trung bình' , 123333,123123 , 'trong');

insert into dich_vu_di_kem (id_dich_vu_di_kem , ten_dich_vu_di_kem , gia , don_vi , trang_thai_kha_dung)
value (4,'yếu' , 123333,123123 , 'trong');

insert into hop_dong_chi_tiet (id_hop_dong_chi_tiet , id_hop_dong , id_dich_vu_di_kem , so_luong)
value (2,2,2,13);

insert into hop_dong_chi_tiet (id_hop_dong_chi_tiet , id_hop_dong , id_dich_vu_di_kem , so_luong)
value (3,3,3,14);


insert into hop_dong_chi_tiet (id_hop_dong_chi_tiet , id_hop_dong , id_dich_vu_di_kem , so_luong)
value (4,4,4,15);


insert into hop_dong (id_hop_dong , id_nhan_vien , id_khach_hang , id_dich_vu , ngay_lam_hop_dong , ngay_ket_thuc, tien_dat_coc ,tong_tien)
value (2,2 , 2 , 2, '1999-12-12', '1999-12-12' , 123123123 , 123123123 );

insert into hop_dong (id_hop_dong , id_nhan_vien , id_khach_hang , id_dich_vu , ngay_lam_hop_dong , ngay_ket_thuc, tien_dat_coc ,tong_tien)
value (3,3 , 3 , 3, '1999-12-12', '1999-12-12' , 123123123 , 123123123 );

insert into hop_dong (id_hop_dong , id_nhan_vien , id_khach_hang , id_dich_vu , ngay_lam_hop_dong , ngay_ket_thuc, tien_dat_coc ,tong_tien)
value (4,4 , 4 , 4, '1999-12-12', '1999-12-12' , 123123123 , 123123123 );

insert into loai_dich_vu (id_loai_dich_vu , ten_loai_dich_vu) 
value (1,'vip');

insert into loai_dich_vu (id_loai_dich_vu , ten_loai_dich_vu) 
value (2,'thường');

insert into loai_dich_vu (id_loai_dich_vu , ten_loai_dich_vu) 
value (3,'trung bình');

insert into loai_dich_vu (id_loai_dich_vu , ten_loai_dich_vu) 
value (4,'yếu');

insert into kieu_thue (id_kieu_thue , ten_kieu_thue , gia)
value (1 , 'vip');

insert into kieu_thue (id_kieu_thue , ten_kieu_thue , gia)
value (2 , 'thường');

insert into kieu_thue (id_kieu_thue , ten_kieu_thue , gia)
value (3 , 'trung bình');

insert into kieu_thue (id_kieu_thue , ten_kieu_thue , gia)
value (4 , 'yếu');


insert into dich_vu (id_dich_vu , ten_dich_vu , dien_tich , so_tang , so_nguoi_toi_da , chi_phi_thue , id_kieu_thue,id_loai_dich_vu, trang_thai)
value (1,'du lịch' , 123, 123,13 ,1231312, 1 ,1 ,'trong');

insert into dich_vu (id_dich_vu , ten_dich_vu , dien_tich , so_tang , so_nguoi_toi_da , chi_phi_thue , id_kieu_thue,id_loai_dich_vu, trang_thai)
value (2,'ở nhà' , 123, 123,13 ,1231312, 1 ,1 ,'trong');

insert into dich_vu (id_dich_vu , ten_dich_vu , dien_tich , so_tang , so_nguoi_toi_da , chi_phi_thue , id_kieu_thue,id_loai_dich_vu, trang_thai)
value (3,'đi chơi' , 123, 123,13 ,1231312, 1 ,1 ,'trong');

insert into dich_vu (id_dich_vu , ten_dich_vu , dien_tich , so_tang , so_nguoi_toi_da , chi_phi_thue , id_kieu_thue,id_loai_dich_vu, trang_thai)
value (4,'ăn ngủ' , 123, 123,13 ,1231312, 1 ,1 ,'trong');

drop table tong_tien;
create table tong_tien (
tong_tien int primary key ,
id_hop_dong int ,
id_dich_vu_di_kem int,
foreign key (id_hop_dong)references hop_dong (id_hop_dong),
foreign key (id_dich_vu_di_kem) references dich_vu_di_kem (id_dich_vu_di_kem)
);


select ho_ten from nhan_vien where ho_ten like '%h%'; 


select * from nhan_vien where char_length (ho_ten) > 10 and (ho_ten like '%h%' or ho_ten like '%k%' or ho_ten like '%t%') ;
select * from hop_dong_chi_tiet order by so_luong asc; 
-- tack3 

select * from khach_hang where (year(curdate()))- year(ngay_sinh) >= 18 and (year(curdate()))-year(ngay_sinh) <= 50 and dia_chi like '%đà nẵng%' or dia_chi like '%quang tri%';
-- task4
 
select khach_hang.id_khach_hang , loai_khach.id_loai_khach , hop_dong.cnt from khach_hang 
join(select hop_dong.id_khach_hang , count(hop_dong.id_khach_hang) as cnt from hop_dong group by id_khach_hang) hop_dong
on khach_hang.id_khach_hang = hop_dong.id_khach_hang 
join loai_khach on khach_hang.id_loai_khach  = loai_khach.id_loai_khach 
where khach_hang.id_loai_khach  = 1 order by hop_dong.cnt asc; 

-- task5 
select khach_hang.id_khach_hang , khach_hang.ho_ten , hop_dong.id_hop_dong
 , hop_dong.ngay_lam_hop_dong , hop_dong.ngay_ket_thuc , hop_dong_chi_tiet.so_luong , dich_vu_di_kem.gia
 from khach_hang 
 left join hop_dong on khach_hang.id_khach_hang = hop_dong.id_khach_hang 
 left join  hop_dong_chi_tiet on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong 
 left join dich_vu_di_kem on hop_dong_chi_tiet.id_dich_vu_di_kem  = dich_vu_di_kem.id_dich_vu_di_kem;
 
 
 
 
--  task6

 select dich_vu.id_dich_vu , dich_vu.ten_dich_vu , dich_vu.dien_tich , dich_vu.chi_phi_thue , dich_vu.id_loai_dich_vu,
 hop_dong.ngay_lam_hop_dong
 from dich_vu join hop_dong on dich_vu.id_dich_vu = hop_dong.id_hop_dong  join khach_hang 
 on hop_dong.id_hop_dong = khach_hang.id_khach_hang where not hop_dong.ngay_lam_hop_dong  = year('2019-01-31') or 
hop_dong.ngay_lam_hop_dong  = year('2019-02-31') or hop_dong.ngay_lam_hop_dong  = year('2019-03-31');

-- task7

select dich_vu.id_dich_vu , dich_vu.ten_dich_vu , dich_vu.dien_tich ,
dich_vu.so_nguoi_toi_da , dich_vu.chi_phi_thue, loai_dich_vu.ten_loai_dich_vu 
from dich_vu join loai_dich_vu on dich_vu.id_dich_vu = loai_dich_vu.id_loai_dich_vu 
join hop_dong on hop_dong.id_hop_dong = loai_dich_vu.id_loai_dich_vu
where not hop_dong.ngay_lam_hop_dong = '2019-01-01';

-- task8
select distinct khach_hang.ho_ten from khach_hang;
select *from khach_hang group by ho_ten;

select khach_hang.ho_ten from khach_hang union
select khach_hang.ho_ten from khach_hang;
-- task9
select month(hop_dong.ngay_lam_hop_dong) as 'tháng' ,count(hop_dong.id_khach_hang) as'số lượng đặt ' from hop_dong   group by tháng;
-- task10
select  hop_dong.id_hop_dong , hop_dong.ngay_lam_hop_dong , hop_dong.ngay_ket_thuc , 
hop_dong.tien_dat_coc,count(hop_dong_chi_tiet.id_hop_dong_chi_tiet) 
as 'tổng số lần sư dụng dịch vụ đi kèm'
from hop_dong  join hop_dong_chi_tiet on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
group by hop_dong.id_hop_dong ;

-- task11

select * from dich_vu_di_kem join hop_dong_chi_tiet on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem 
join hop_dong on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong join khach_hang 
on khach_hang.id_khach_hang = hop_dong.id_khach_hang
join loai_khach on loai_khach.id_loai_khach = khach_hang.id_loai_khach where loai_khach.id_loai_khach = 1
and khach_hang.dia_chi = 'quảng ngãi' or khach_hang.dia_chi = 'vinh'; 
-- task12
select hop_dong.id_hop_dong , nhan_vien.ho_ten , khach_hang.ho_ten , khach_hang.sdt , dich_vu.ten_dich_vu ,
hop_dong_chi_tiet.so_luong from dich_vu_di_kem join hop_dong_chi_tiet
on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem
join hop_dong on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
join nhan_vien on nhan_vien.id_nhan_vien = hop_dong.id_nhan_vien
join khach_hang on khach_hang.id_khach_hang = hop_dong.id_khach_hang
join dich_vu on dich_vu.id_dich_vu = hop_dong.id_dich_vu
where ((month(hop_dong.ngay_lam_hop_dong) in (10,11,12)) and (year(hop_dong.ngay_lam_hop_dong) = 2019) 
and hop_dong.ngay_lam_hop_dong not in (select hop_dong.id_dich_vu from hop_dong where year(hop_dong.ngay_lam_hop_dong) = 2019
and month(hop_dong.ngay_lam_hop_dong) between 1 and 9)) group by hop_dong.id_hop_dong;


-- task13
select * from
(select dich_vu_di_kem.ten_dich_vu_di_kem ,count(hop_dong_chi_tiet.id_dich_vu_di_kem) as max_so_lan_dat 
from dich_vu_di_kem 
join hop_dong_chi_tiet on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem 
group by hop_dong_chi_tiet.id_dich_vu_di_kem ) as abc 
where max_so_lan_dat = (select count(hop_dong_chi_tiet.id_dich_vu_di_kem) as xyz from hop_dong_chi_tiet 
group by hop_dong_chi_tiet.id_dich_vu_di_kem order by  xyz desc limit 1);

 -- task14
 
 select hop_dong.id_hop_dong , loai_dich_vu.ten_loai_dich_vu , dich_vu_di_kem.ten_dich_vu_di_kem , count(hop_dong.id_hop_dong) as so_lan
 from dich_vu_di_kem join hop_dong_chi_tiet 
 on dich_vu_di_kem.id_dich_vu_di_kem = hop_dong_chi_tiet.id_dich_vu_di_kem 
 join hop_dong on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
 join dich_vu on dich_vu.id_dich_vu = hop_dong.id_dich_vu 
 join loai_dich_vu on loai_dich_vu.id_loai_dich_vu = dich_vu.id_loai_dich_vu
 group by hop_dong.id_hop_dong having so_lan = 1;
 
 -- task 15
 
 select nhan_vien.id_nhan_vien , nhan_vien.ho_ten , nhan_vien.id_trinh_do , nhan_vien.id_bo_phan ,nhan_vien.sdt
 , nhan_vien.dia_chi , count(hop_dong.id_hop_dong) as so_lan_lam_hop_dong
 from nhan_vien join hop_dong on hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien 
 where year(hop_dong.ngay_lam_hop_dong) between 2018 and 2019 group by nhan_vien.ho_ten having so_lan_lam_hop_dong >= 3;
 
 -- task16
 set sql_safe_updates = 0;
delete from nhan_vien where not exists (select hop_dong.id_nhan_vien from hop_dong 
where hop_dong.ngay_lam_hop_dong between '2017-01-01' and '2019-12-31'
and hop_dong.id_nhan_vien = nhan_vien.id_nhan_vien);
set sql_safe_updates =1;
 
 -- task17
 
set sql_safe_updates = 0;
update khach_hang set id_loai_khach =  1 
where khach_hang.id_khach_hang = (select hop_dong.id_khach_hang from hop_dong
where hop_dong.tien_dat_coc > 1000000 and year(hop_dong.ngay_lam_hop_dong) = 2019
and khach_hang.id_loai_khach = 2) ;
 set sql_safe_updates = 0;
 
 -- task18
 
  set sql_safe_updates = 0;
delete from khach_hang 
where exists (select * from hop_dong 
where year(hop_dong.ngay_lam_hop_dong)< 2016
and hop_dong.id_khach_hang = khach_hang.id_khach_hang);
set sql_safe_updates =1;
-- task19
update dich_vu_di_kem set dich_vu_di_kem.gia = dich_vu_di_kem.gia*2 where dich_vu_di_kem.id_dich_vu_di_kem
in (select abc  from
(select hop_dong_chi_tiet.id_dich_vu_di_kem as abc,count(hop_dong_chi_tiet.id_hop_dong_chi_tiet) as solansudung from hop_dong_chi_tiet
join hop_dong on hop_dong.id_hop_dong = hop_dong_chi_tiet.id_hop_dong
group by hop_dong_chi_tiet.id_dich_vu_di_kem
having solansudung > 10) as xyz);
-- task20
select id_nhan_vien as id, ho_ten , email, sdt , ngay_sinh , dia_chi ,'nhân viên' as loại from nhan_vien union all
select id_khach_hang as id, ho_ten , email, sdt , ngay_sinh , dia_chi, "khách hang" as loại from khach_hang; 





