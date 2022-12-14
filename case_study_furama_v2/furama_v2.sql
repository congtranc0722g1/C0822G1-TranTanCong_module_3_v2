create database furama_v2;
use furama_v2;

create table customer_type(
id int primary key,
name varchar(45)
);

create table customer(
id int primary key,
customer_type_id int,
`name` varchar(45),
date_of_birth date,
gender bit(1),
id_card varchar(45),
phone_number varchar(45),
email varchar(45),
address varchar(45),
foreign key(customer_type_id) references customer_type(id)
);

create table facility_type (
id int primary key,
facility_type_name varchar(45)
);

create table rent_type(
id int primary key,
rent_type_name varchar(45)
);

create table facility(
id int primary key,
`name` varchar(45),
area int,
cost double,
max_people int,
rent_type_id int,
facility_type_id int,
standard_room varchar(45),
description_other_convenience varchar(45),
pool_area double,
numbers_of_floors int,
facility_free text,
foreign key(rent_type_id) references rent_type(id),
foreign key(facility_type_id) references facility_type(id)
);

create table `position`(
id int primary key,
position_name varchar(45)
);

create table education_degree (
id int primary key,
education_degree_name varchar(45)
);

create table division (
id int primary key,
division_name varchar(45)
);

create table employee (
id int auto_increment primary key,
`name` varchar(45),
date_of_birth date,
id_card varchar(45),
salary double,
phone_number varchar(45),
email varchar(45),
address varchar(45),
position_id int,
education_degree_id int,
division_id int,
foreign key(position_id) references `position`(id),
foreign key(education_degree_id) references education_degree(id),
foreign key(division_id) references division(id)
);

drop table division;
drop table facility;
drop table rent_type;