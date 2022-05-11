/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  THAIHB.B19CN638
 * Created: Apr 26, 2022
 */
use cnpm;
create table tblClothes(
    id int AUTO_INCREMENT primary key,
    idclo varchar(20) unique,
    name varchar(200), 
    trademark varchar(100), 
    producer varchar(100), 
    nsx date, 
    cost float, 
    rentcost float
);
insert into tblclothes(id, idclo, name, trademark, producer, nsx, cost, rentcost) values( 1, "aodai1", "áo dài loại 1", "áo dài việt", "công ty việt hoa", "2020-04-05", 400000, 20000  )
insert into tblclothes(idclo, name, trademark, producer, nsx, cost, rentcost) values( "aodai2", "áo dài loại 2", "áo dài việt", "công ty việt hoa", "2020-05-05", 300000, 15000  )
insert into tblclothes(idclo, name, trademark, producer, nsx, cost, rentcost) values( "aodai3", "áo dài loại 1", "thời trang việt", "công ty việt hoa", "2019-05-05", 600000, 30000  )
insert into tblclothes(idclo, name, trademark, producer, nsx, cost, rentcost) values( "aodai4", "áo dài loại 2", "thời trang việt", "công ty việt hoa", "2019-10-30", 400000, 20000  )
insert into tblclothes(idclo, name, trademark, producer, nsx, cost, rentcost) values( "vay1", "váy loại 1", "thời trang việt", "công ty việt hoa", "2019-10-30", 200000, 10000  )
insert into tblclothes(idclo, name, trademark, producer, nsx, cost, rentcost) values( "vay2", "váy loại 2", "vnclo", "xưởng may hà đông", "2019-10-30", 100000, 5000  )
