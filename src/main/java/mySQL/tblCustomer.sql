/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  THAIHB.B19CN638
 * Created: Apr 26, 2022
 */

use cnpm;
create table tblCustomer(
    id int AUTO_INCREMENT primary key,
    name varchar(200) not null,  
    idCard varchar(200) unique, 
    address varchar(300) not null,
    tel varchar(20) unique, 
    email varchar(50) not null, 
    note varchar(300)
);
