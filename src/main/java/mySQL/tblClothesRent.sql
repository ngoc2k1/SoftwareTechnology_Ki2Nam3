/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  THAIHB.B19CN638
 * Created: Apr 26, 2022
 */

use cnpm;
create table tblClothesRent(
    id int AUTO_INCREMENT primary key,
    idClothes int,
    idBorrowCard int,
    number int not null,
    total float not null,
    foreign key (idClothes) REFERENCES  tblClothes(id),
    foreign key (idBorrowCard) REFERENCES  tblBorrowCard(id)
);
