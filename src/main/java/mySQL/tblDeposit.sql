/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  THAIHB.B19CN638
 * Created: Apr 26, 2022
 */

use cnpm;
create table tblDeposit(
    id int AUTO_INCREMENT primary key,
    idCustomer int,
    idBorrowCard int,
    deposit float,
    note varchar(200),
    FOREIGN KEY (idCustomer) REFERENCES  tblCustomer(id),
    FOREIGN KEY (idBorrowCard) REFERENCES  tblBorrowCard(id)
);