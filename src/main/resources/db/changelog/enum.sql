-- liquibase formatted sql

-- changeset chait:1677335672894-6
DO 
'
BEGIN
  IF NOT EXISTS (SELECT 1 FROM pg_type WHERE typname = ''user_roles'') THEN
    CREATE TYPE user_roles AS ENUM (''ADMIN'', ''EDITOR'', ''VIEWER'');
  END IF;
END
'
-- rollback DROP TYPE user_roles;