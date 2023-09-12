--liquibase formatted sql

--changeset belonogov:1
alter table persons add column role varchar(150) not null