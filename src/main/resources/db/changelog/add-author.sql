-- liquibase formatted sql

-- changeset chait:1677335672894-4
CREATE TABLE author (
    id BIGINT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255)
);

CREATE SEQUENCE  IF NOT EXISTS "author_seq" AS bigint START WITH 1 INCREMENT BY 50 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

ALTER TABLE author ALTER COLUMN id SET DEFAULT nextval('author_seq');