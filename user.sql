create user bases identified by bases;
grant connect, resource, dba to bases;
grant unlimited tablespace to bases;
grant create session to bases;
GRANT create session TO bases;
GRANT create table TO bases;
GRANT create view TO bases;
GRANT create any trigger TO bases;
GRANT create any procedure TO bases;
GRANT create sequence TO bases;
GRANT create synonym TO bases;
GRANT create any table TO bases;
--User works as a schema.
--Log in
connect bases/bases; --

/* grant permission to other users on a schema
GRANT
  SELECT,
  INSERT,
  UPDATE,
  DELETE
ON
  schema.books
TO
  books_admin;
*/ 
--Create tables on user bases
create table t1(a int, b int) on bases; --No funciona :v
create index pkt1(a) on t1 on index;
unique alter table add contraint pkt1 primary key;
