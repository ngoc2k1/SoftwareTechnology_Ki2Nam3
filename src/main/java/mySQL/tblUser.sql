/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  THAIHB.B19CN638
 * Created: Apr 26, 2022
 */
use cnpm;
create table tblUser(
        id int AUTO_INCREMENT primary key,
	username varchar(50) unique,
	password varchar(20) not null,
	name varchar(200) not null,
	position varchar(50) not null
);
insert into tblUser(username, password, name, position) values("nguoidung1", "password1", "nguyen van anh", "quan ly")
insert into tblUser(username, password, name, position) values("nguoidung2", "password2", "nguyen van an", "quan ly")
insert into tblUser(username, password, name, position) values("hothai", "hothaipw", "ho ba thai", "thu ngan")



