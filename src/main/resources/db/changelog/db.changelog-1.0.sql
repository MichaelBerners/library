--liquibase formatted sql

--changeset belonogov:1
create table persons
(
    id              bigserial,
    constraint persons_pk primary key (id),
    first_name      varchar(150) not null,
    last_name       varchar(150) not null,
    birth_year      date         not null,
    passport_number varchar(10)  not null,
    phone_number    varchar(12)  not null,
    email           varchar(150) not null,
    create_at       timestamp    not null,
    status          int          not null

);
--rollback drop table persons

--changeset belonogov:2
create table books
(
    id        bigserial,
    constraint books_pk primary key (id),
    title     varchar(150) not null,
    author    varchar(150) not null,
    year      varchar(4)   not null,
    condition int          not null,
    status    int          not null,
    person_id bigint,
    constraint books_fk foreign key (person_id) references persons (id)

)
--rollback drop table books