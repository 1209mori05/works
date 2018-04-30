set names utf8;
set foreign_key_checks = 0;

drop database if exists teatime;
create database if not exists teatime;
use teatime;

drop table if exists user_info;
create table user_info(
	id int not null primary key auto_increment,
	user_id varchar(16) not null unique,
	password varchar(16) not null,
	family_name varchar(32) not null,
	first_name varchar(32) not null,
	family_name_kana varchar(32) not null,
	first_name_kana varchar(32) not null,
	sex tinyint default 1 not null,
	email varchar (32) not null,
	logined tinyint default 0 not null,
	insert_date datetime not null,
	update_date datetime
	);


drop table if exists product_info;
create table product_info(
	id int primary key not null auto_increment,
	product_id int not null unique,
	product_name varchar(100) not null unique,
	product_name_eng varchar(100) not null unique,
	product_description varchar(255) not null,
	category_id int not null,
	price int,
	image_file_path varchar(100),
	product_coo varchar(50),
	status tinyint default 0 not null,
	regist_date datetime not null,
	update_date datetime
	);


drop table if exists purchase_history_info;
create table purchase_history_info(
	id int primary key not null auto_increment,
	user_id varchar(16) not null,
	product_id int not null,
	product_count int not null,
	price int not null,
	regist_date datetime not null
	);


INSERT INTO user_info(user_id, password, family_name, first_name,
	family_name_kana, first_name_kana, sex, email,insert_date)
VALUES("hanako", "123", "田中", "花子", "たなか", "はなこ", "2", "bbbb@com", now()),
	  ("taro", "123", "佐藤", "太郎", "さとう", "たろう", "1", "aaaa@com", now());


INSERT INTO product_info(product_id, product_name, product_name_eng,
	product_description, category_id, price, product_coo,regist_date)
VALUES("0", "商品その1", "product_no1", "商品その1の説明文", "1", "1000", "アメリカ", now()),
	  ("1", "商品その2", "product_no2", "商品その2の説明文", "1", "1500", "日本", now());