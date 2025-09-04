
create schema bank;

use bank;

create table users (
    uid integer primary key auto_increment,
    name varchar(100) not null,
    id varchar(50) not null,
    password varchar(50) not null,
    email varchar(100) unique,
    phone varchar(20) unique,
    created_at timestamp default current_timestamp
);

alter table users
add column id varchar(50) not null,
add column password varchar(50) not null;

create table accounts (
    uid int not null,
    account_id int auto_increment primary key,
    account_number varchar(50) unique not null,
    balance decimal(15, 2) default 0.00,
    created_at timestamp default current_timestamp,

    constraint fk_accounts_users foreign key (uid)
    references users(uid)
    on delete cascade

);

insert into users (name, id, password, email, phone)
values ("홍길동", "test", "1234" , "hong@test.com", "010-0000-0000");

select * from users;