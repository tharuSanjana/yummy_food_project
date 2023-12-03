create database yummy_food;
use yummy_food;

create table user(
                     user_id varchar(50) primary key,
                     user_name varchar(50) not null,
                     password varchar(50) not null
);

create table employee(
                         emp_id varchar(50) primary key,
                         name varchar(100) not null,
                         address text not null,
                         tel varchar(50) not null,
                         emp_type varchar(100) not null,
                         user_id varchar(50) not null,
                         constraint foreign key (user_id) references user(user_id) on delete cascade on update cascade
);

create table customer(
                         cus_id varchar(50) primary key,
                         name varchar(100) not null,
                         address text not null,
                         tel varchar(50) not null,
                         user_id varchar(50),
                         constraint foreign key (user_id) references user(user_id) on delete cascade on update cascade
);

create table payment(
                        p_id varchar(50) primary key,
                        amount double(100,3) not null,
date date
);

create table orders(
                       or_id varchar(50) primary key,
                       date date not null,
                       order_type varchar(100) not null,
                       Time time,
                       p_id varchar(50),
                       emp_id varchar(50),
                       cus_id varchar(50) not null,
                       constraint foreign key (cus_id) references customer(cus_id) on delete cascade on update cascade,
                       constraint foreign key (emp_id) references employee(emp_id) on delete cascade on update cascade,
                       constraint foreign key (p_id) references payment(p_id) on delete cascade on update cascade
);



create table food(
                     food_id varchar(50) primary key,
                     name varchar(50),
                     price double not null,
                     description text not null
);

create table order_food_details(
                                   food_id varchar(50) not null,
                                   or_id varchar(50) not null,
                                   constraint foreign key (food_id) references food(food_id) on delete cascade on update cascade,
                                   constraint foreign key (or_id) references orders(or_id) on delete cascade on update cascade
);


create table ingredients(
                            ing_id varchar(50) primary key,
                            name varchar(50) not null,
                            price double not null,
                            qty double not null,
                            p_id varchar(50),
                            constraint foreign key (p_id) references payment(p_id) on delete cascade on update cascade
);

create table food_ingredients_details(
                                         food_id varchar(50) not null,
                                         ing_id varchar(50) not null,
                                         constraint foreign key (food_id) references food(food_id) on delete cascade on update cascade,
                                         constraint foreign key (ing_id) references ingredients(ing_id) on delete cascade on update cascade
);

create table supplier(
                         sup_id varchar(50) primary key,
                         name varchar(50) not null,
                         tel varchar(50) not null,
                         email varchar(100)
);


create table supplier_ingredients_details(
                                             sup_id varchar(50) not null,
                                             ing_id varchar(50) not null,
                                             sup_name varchar(100),
                                             ing_name varchar(100),
                                             total double(10,2),
p_id varchar(100),
constraint foreign key (sup_id) references supplier(sup_id) on delete cascade on update cascade,
constraint foreign key (ing_id) references ingredients(ing_id) on delete cascade on update cascade
);


create table registration(
                             name varchar(100) not null,
                             email varchar(100) not null,
                             job_roll varchar(100) not null,
                             address varchar(100) not null,
                             username varchar(100) not null,
                             password varchar(100) primary key
);




