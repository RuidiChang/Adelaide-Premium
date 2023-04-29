drop database if exists store ;

create database store charset = utf8;

use store;

create table goods(
      goods_id varchar(100) primary key,
      goods_type varchar(50),
      price double(13,3) not null,
      description varchar(200),
      size int not null,
      code_color int,
      stock int
);

create table catalog(
    catalog_id varchar(100),
    goods_id varchar(100)
#    constraint fk_catalog_goods foreign key(goods_id) references goods(goods_id)
);

create table csr(
        order_id varchar(100),
        name varchar(100),
        extension varchar(200)
);

create table store_order(
      order_id varchar(100) primary key,
      date datetime,
      catalog_id varchar(100),
      total_price double(13,3),
      payment_id varchar(100),
      CSR_id varchar(100),
      status varchar(100)
);

create table customer(
                         customer_id varchar(100) primary key,
                         name varchar(100),
                         address varchar(100),
                         email varchar(100),
                         order_id varchar(100)
#                         constraint fk_customer_order foreign key(order_id) references store_order(order_id)
);



create table payment(
                        customer_id varchar(100) primary key,
                        name varchar(100),
                        address varchar(100),
                        phone varchar(100),
                        email varchar(100),
                        order_id varchar(100)
);


insert into goods(goods_id, goods_type, price ,description ,size ,code_color, stock) value('a1001','white',100,'xxx',50,0xff0000,100);
insert into goods(goods_id, goods_type, price ,description ,size ,code_color, stock) value('a1002','white',100,'xxx',50,666666,100);
insert into goods(goods_id, goods_type, price ,description ,size ,code_color, stock) value('a1003','white',100,'xxx',50,666666,100);
insert into goods(goods_id, goods_type, price ,description ,size ,code_color, stock) value('a1004','white',100,'xxx',50,666666,100);
insert into goods(goods_id, goods_type, price ,description ,size ,code_color, stock) value('a1005','white',100,'xxx',50,666666,100);
insert into goods(goods_id, goods_type, price ,description ,size ,code_color, stock) value('a1006','white',100,'xxx',50,666666,100);
insert into goods(goods_id, goods_type, price ,description ,size ,code_color, stock) value('a1007','white',100,'xxx',50,666666,100);
insert into goods(goods_id, goods_type, price ,description ,size ,code_color, stock) value('a1008','white',100,'xxx',50,666666,100);
insert into goods(goods_id, goods_type, price ,description ,size ,code_color, stock) value('a1008','white',100,'xxx',50,666666,100);
insert into goods(goods_id, goods_type, price ,description ,size ,code_color, stock) value('a1008','white',100,'xxx',50,666666,100);
insert into goods(goods_id, goods_type, price ,description ,size ,code_color, stock) value('a1009','white',100,'xxx',50,666666,100);
insert into goods(goods_id, goods_type, price ,description ,size ,code_color, stock) value('a1010','white',100,'xxx',50,666666,100);
insert into goods(goods_id, goods_type, price ,description ,size ,code_color, stock) value('a1011','white',100,'xxx',50,666666,100);
insert into goods(goods_id, goods_type, price ,description ,size ,code_color, stock) value('a1012','white',100,'xxx',50,666666,100);
insert into goods(goods_id, goods_type, price ,description ,size ,code_color, stock) value('a1013','white',100,'xxx',50,666666,100);
insert into goods(goods_id, goods_type, price ,description ,size ,code_color, stock) value('a1014','white',100,'xxx',50,666666,100);
insert into goods(goods_id, goods_type, price ,description ,size ,code_color, stock) value('a1015','white',100,'xxx',50,666666,100);
insert into goods(goods_id, goods_type, price ,description ,size ,code_color, stock) value('a1016','white',100,'xxx',50,666666,100);
insert into goods(goods_id, goods_type, price ,description ,size ,code_color, stock) value('a1017','white',100,'xxx',50,0xffffff,100);
