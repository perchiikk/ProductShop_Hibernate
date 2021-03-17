create table customers if not exists (
    id int primary key not null auto_increment,
    name varchar (200),
    int age
);

create table orders if not exists (
    id int primary key not null auto_increment,
    customer_id int,
    price int,
    order_date date
    foreign key (customer_id) references customers(id);
);

create table products if not exists (
    id int primary key not null auto_increment,
    quantity int,
    alco boolean,
    name varchar (200),
    price int
);

create table list_of_orders if not exists (
    id int primary key not null auto_increment,
    order_id int,
    product_id int,
    quantity int,
    foreign key (order_id) references orders(id),
    foreign key (product_id) references products(id)
);