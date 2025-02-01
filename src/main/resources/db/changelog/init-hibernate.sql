--liquibase formatted sql

--changeset JT:3
-- PostgreSQL sequences are automatically initialized
-- This changeset is kept for tracking purposes but no action is needed
SELECT setval('book_id_seq', 0, false);