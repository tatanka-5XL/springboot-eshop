create table cart
(
    id          int8 not null,
    created_at  timestamp,
    modified_at timestamp,
    primary key (id)
);
create table eshop_order
(
    id           int8 not null,
    created_at   timestamp,
    modified_at  timestamp,
    order_status varchar(255),
    primary key (id)
);
create table manufacturer
(
    id          int8 not null,
    created_at  timestamp,
    modified_at timestamp,
    about       varchar(255),
    name        varchar(255),
    vat_nr      varchar(255),
    primary key (id)
);
create table product
(
    id               int8 not null,
    created_at       timestamp,
    modified_at      timestamp,
    description      varchar(512),
    image            varchar(255),
    name             varchar(255),
    price            int8,
    stock            int8,
    id_manufacturer  int8,
    id_product_group int8,
    primary key (id)
);
create table product_group
(
    id          int8 not null,
    created_at  timestamp,
    modified_at timestamp,
    description varchar(255),
    name        varchar(255),
    primary key (id)
);
create table r_cart_product
(
    id_cart    int8 not null,
    id_product int8 not null
);
create table r_order_product
(
    id_order   int8 not null,
    id_product int8 not null
);
create sequence hibernate_sequence start with 1000 increment by 1;
alter table if exists product
    add constraint fk_product_manufacturer foreign key (id_manufacturer) references manufacturer;
alter table if exists product
    add constraint fk_product_product_group foreign key (id_product_group) references product_group;
alter table if exists r_cart_product
    add constraint fk_r_cart_product_product foreign key (id_product) references product;
alter table if exists r_cart_product
    add constraint fk_r_cart_product_cart foreign key (id_cart) references cart;
alter table if exists r_order_product
    add constraint fk_r_order_product_product foreign key (id_product) references product;
alter table if exists r_order_product
    add constraint fk_r_order_product_eshop_order foreign key (id_order) references eshop_order;