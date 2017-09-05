--Crear usuario y dar permisos.
create user bases identified by bases;
grant connect, resource, dba to bases;
grant unlimited tablespace to bases;
grant create session to bases;
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
ALTER USER bases DEFAULT TABLESPACE Bschema; --ASignar un tablespace al usuario!!
CREATE TABLESPACE Bschema DATAFILE 'tbs_f2.dbf' SIZE 40M     ONLINE;--Crear un tablespace
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
create table bases.t1(a int, b int);
create index pkt1(a) on t1 on index;
unique alter table add contraint pkt1 primary key;


--Consultas
select df.tablespace_name "Tablespace",
       totalusedspace "Used MB",
       (df.totalspace - tu.totalusedspace) "Free MB",
       df.totalspace "Total MB",
       round(100 * ( (df.totalspace - tu.totalusedspace)/ df.totalspace)) "Pct. Free"
  from (select tablespace_name,
               round(sum(bytes) / 1048576) TotalSpace
          from dba_data_files 
         group by tablespace_name) df,
       (select round(sum(bytes)/(1024*1024)) totalusedspace,
               tablespace_name
          from dba_segments 
         group by tablespace_name) tu
 where df.tablespace_name = tu.tablespace_name 
   and df.totalspace <> 0;


   create table bases.grafico(
     fecha date,
     name varchar(25),
     usedMB integer,
     freeMB integer,
     freePr float,
     totalMB integer,
     hwm float
   );