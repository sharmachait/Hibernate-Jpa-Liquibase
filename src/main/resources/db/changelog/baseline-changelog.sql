--liquibase formatted sql

--changeset JT:1677335672894-1


CREATE TABLE book (
    id BIGINT PRIMARY KEY,
    isbn VARCHAR(255),
    publisher VARCHAR(255),
    title VARCHAR(255)
);

--changeset JT:1677335672894-2
CREATE SEQUENCE IF NOT EXISTS book_id_seq
    INCREMENT BY 1
    START WITH 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

-- Alter the book table to use the sequence
--changeset JT:1677335672894-3
ALTER TABLE book ALTER COLUMN id SET DEFAULT nextval('book_id_seq');