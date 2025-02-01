--liquibase formatted sql

--includeAll path:db/changelog/
CREATE SCHEMA IF NOT EXISTS bookdb;
-- Alternative if you want to control the exact order:

----include file:db/changelog/baseline-changelog.sql
----include file:db/changelog/init-hibernate.sql
----include file:db/changelog/add-author.sql