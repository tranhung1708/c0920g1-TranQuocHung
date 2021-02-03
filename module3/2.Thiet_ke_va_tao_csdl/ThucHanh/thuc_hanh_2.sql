create database users;
use users;
create table users1(
users_id int auto_increment primary key,
users_name varchar(40),
`password` varchar(50),
email varchar(255)
);

create table roles(
roles_id int not null,
roles_name varchar(255),
primary key (roles_id)
);

create table users_roles(
users_id int not null,
roles_id int not null,
primary key(users_id , roles_id),
foreign key(users_id) references users1(users_id),
foreign key(roles_id) references roles(roles_id)
);
alter table users1 add primary key (email);