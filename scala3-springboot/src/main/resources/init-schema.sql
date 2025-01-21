create table users (
    id uuid not null default uuid() primary key,
    name varchar(300),
    email varchar(300)
);