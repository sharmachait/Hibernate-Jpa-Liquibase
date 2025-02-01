-- liquibase formatted sql

-- changeset chait:1677335672894-4
CREATE TABLE author (
    id BIGINT PRIMARY KEY,
    first_name VARCHAR(255),
    last_name VARCHAR(255)
);

CREATE SEQUENCE IF NOT EXISTS author_id_seq
    INCREMENT BY 1
    START WITH 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;

ALTER TABLE author ALTER COLUMN id SET DEFAULT nextval('author_id_seq');