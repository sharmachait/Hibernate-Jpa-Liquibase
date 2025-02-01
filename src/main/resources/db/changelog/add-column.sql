-- liquibase formatted sql

-- changeset chait:1677335672894-5
ALTER TABLE book 
ADD COLUMN author_id BIGINT, 
ADD CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES author(id);