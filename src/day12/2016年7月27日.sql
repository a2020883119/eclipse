CREATE TABLE USERS(
       ID    NUMBER(5),
       ACCOUNT         VARCHAR2(10),
       PASSWORD        VARCHAR2(10)
       )
INSERT INTO USERS VALUES(101, '1', '1');
select * from users where id = 100
update users set id = 101 where id = 102
