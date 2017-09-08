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
ALTER USER bases DEFAULT TABLESPACE Bschema; --ASignar un tablespace al usuario!! No es necesario, mejor asignar cuando se crea la tabla
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
create table bases.t2(a int, b int);
create index pkt1(a) on t1 on index;
unique alter table add constraint pkt1 primary key;
insert into t1 values(1,3);

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

-- Recuperado de:
-- https://stackoverflow.com/questions/15113716/how-to-determine-size-of-tablespace-oracle-11g
--Sacar registros por table space....
select count(*) from Student;
select table_name from dba_segments where tablespace_name='Bschema';
select count(*) from x;
--Crea tabla con un tablespace definido.!
create table x(a int) tablespace Bschema;




--select de las tablas segun su tablespace...
SELECT
  table_name, owner
FROM
  all_tables
  where tablespace_name='BSCHEMA';

--Select los index del table_space...!
select tablespace_name , owner, index_name, index_type, sample_size
from all_indexes
where owner = 'BASES';


--Index de la table Y en bschemx
create table y(a int) tablespace Bschema;
create index pky1 on y(a) tablespace BSCHEMA;


--Index de la tabla sin decirle el schema
create table lentes(a int) tablespace BSCHEMA;
create index pkl1 on lentes(a);

create table gato(a int) tablespace BSCHEMA;
create index pkg1 on gato(a);
create table perro(a int, b int) tablespace Bschema;
alter table add constraint fkp1 foreign key on perro(a) references gato(a);

--Table e index en diferentes tablespace...!
create table yy(a int) tablespace Bschema;
create index pkyy1 on yy(a) tablespace USERS;

--....................................................
select tablespace_name , owner, index_name, index_type, sample_size
from all_indexes
where segment_name = 'lentes';

select SUM(bytes) from user_extents where tablespace_name= 'BSCHEMA';


select segment_type, bytes from dba_segments where tablespace_name= 'BSCHEMA';
select SUM(bytes) from dba_segments where tablespace_name= 'BSCHEMA';
select SUM(bytes) from dba_tables where tablespace_name= 'BSCHEMA';

 select * from dba_data_files where tablespace_name  = 'BSCHEMA'; 



and index_name = 'MYINDEX';


select  sample_size from all_indexes where tablespace_name ='USERS';
