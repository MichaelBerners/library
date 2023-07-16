--liquibase formatted sql

--changeset belonogov:1
create table persons
(
    id         bigserial,
    constraint persons_pk primary key (id),
    first_name varchar(150) not null,
    last_name  varchar(150) not null,
    birth_year varchar(150) not null,
    passport_number varchar(150) not null
);
--rollback drop table persons

--changeset belonogov:2
create table books
(
    id        bigserial,
    constraint books_pk primary key (id),
    uuid uuid,
    title     varchar(150) not null,
    author    varchar(150) not null,
    year      varchar(150) not null,
    person_id bigint       not null,
    constraint books_fk foreign key (person_id) references persons (id)

)
--rollback drop table books