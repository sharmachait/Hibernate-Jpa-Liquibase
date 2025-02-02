-- liquibase formatted sql

-- changeset chait:1677335672894-6

insert into author (first_name, last_name) values ('Stephen', 'King');
insert into author (first_name, last_name) values ('Eichiro', 'Oda');
insert into book (isbn, publisher, title, author_id) 
values(
  '2130-123421', 
  'Penguin', 
  'The Dark Half', 
  (
    select id from author where first_name = 'Stephen' and last_name='King'
  )
);

insert into book (isbn, publisher, title, author_id) 
values(
  '2130-123421dfsfae', 
  'VIZ', 
  'One Piece', 
  (
    select id from author where first_name = 'Eichiro' and last_name='Oda'
  )
);