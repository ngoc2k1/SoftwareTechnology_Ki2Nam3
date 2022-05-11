/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  THAIHB.B19CN638
 * Created: Apr 26, 2022
 */

use cnpm;
create table tblBorrowCard(
    id int AUTO_INCREMENT primary key,
    dayrent date not null, 
    daypay date not null,
    totalcost float, 
    deposit float,
    idUser int,
    idCustomer int,
    foreign key (idUser) REFERENCES  tblUser(id),
    foreign key (idCustomer) REFERENCES  tblCustomer(id)
);