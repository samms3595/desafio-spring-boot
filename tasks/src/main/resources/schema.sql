create sequence hibernate_sequence start with 1 increment by 1;
create table task (id bigint not null, description varchar(255) not null, due_date date not null, status integer not null, title varchar(255) not null, primary key (id));