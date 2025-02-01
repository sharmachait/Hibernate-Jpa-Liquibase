-- liquibase formatted sql

-- changeset chait:1738394810241-1
CREATE SEQUENCE  IF NOT EXISTS "book_seq" AS bigint START WITH 1 INCREMENT BY 50 MINVALUE 1 MAXVALUE 9223372036854775807 CACHE 1;

--changeset chait:1677335672894-2
CREATE TABLE book (
    id BIGINT PRIMARY KEY,
    isbn VARCHAR(255),
    publisher VARCHAR(255),
    title VARCHAR(255)
);

--changeset chait:1677335672894-3
ALTER TABLE book ALTER COLUMN id SET DEFAULT nextval('book_seq');