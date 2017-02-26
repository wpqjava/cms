drop database cms_test;
create database cms_test;
use cms_test;
SET FOREIGN_KEY_CHECKS=0;
drop table if exists t_user;
create table t_user(
	id int(50) primary key auto_increment,
	username varchar(50),
	password varchar(50),
	nickname varchar(50),
	email varchar(50),
	phone varchar(50),
	status int(4),
	create_date datetime
);
drop table if exists t_group;
create table t_group(
	id int(50) primary key auto_increment,
	name varchar(50),
	descri text
);
drop table if exists t_role;
create table t_role(
	id int(50) primary key auto_increment,
	name varchar(50),
	role_type varchar(50)
);
drop table if exists t_user_group;
create table t_user_group(
	id int(50) primary key auto_increment,
	user_id int(50) ,
	group_id int(50),
	constraint foreign key (user_id) references t_user (id),
	constraint foreign key (group_id) references t_group (id)
);
drop table if exists t_user_role;
create table t_user_role(
	id int(50) primary key auto_increment,
	user_id int(50),
	role_id int(50),
	constraint foreign key (user_id) references t_user (id),
	constraint foreign key (role_id) references t_role (id)
);
drop table if exists t_channel;
create table t_channel(
	id int(50) primary key auto_increment,
	name varchar(50),
	custom_link int(2),
	custom_link_url varchar(50),
	channel_type varchar(50),
	is_top_intro int(2),
	is_nav int(2),
	is_recommend int(2),
	status int(2),
	orders int(2),
	channel_id int(50),
	constraint foreign key (channel_id) references t_channel (id)
);
drop table if exists t_group_channel;
create table t_group_channel(
	id int(50) primary key auto_increment,
	group_id int(50),
	channel_id int(50),
	constraint foreign key (group_id) references t_group (id),
	constraint foreign key (channel_id) references t_channel (id)
);
drop table if exists t_topic;
create table t_topic(
	id int(50) primary key auto_increment,
	title varchar(50),
	keyword varchar(50),
	status int(50),
	recommend int(50),
	content text,
	summary varchar(50),
	channel_pic_id int(50),
	create_date datetime,
	publish_date datetime,
	author varchar(50),
	channel_id int(50),
	user_id int(50),
	constraint foreign key (user_id) references t_user (id),
	constraint foreign key (channel_id) references t_channel (id)
);
drop table if exists t_keyword;
create table t_keyword(
	id int(50) primary key auto_increment,
	name varchar(50),
	fullpy varchar(50),
	shortpy varchar(50)
);
drop table if exists t_attach;
create table t_attach(
	id int(50) primary key auto_increment,
	old_name varchar(50),
	new_name varchar(50),
	attach_type  varchar(50),
	suffix varchar(50),
	size BIGINT,
	is_index_pic int(2),
	is_img int(2),
	is_attach int(2),
	topic_id int(50),
	constraint foreign key (topic_id) references t_topic (id)
);
SET FOREIGN_KEY_CHECKS=1;