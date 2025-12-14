--SELECT * FROM EMPLOYEES ;
--
--CREATE TABLE EMPLOYEE_COPY_909 AS SELECT * FROM Employees WHERE first_name = 'Alexander';
--
--DROP TABLE EMPLOYEE_COPY_909 ;
--
--SELECT * FROM Employees WHERE salary >=1000 AND SALARY <= 5000;
--CREATE TABLE EMPLOYEE_COPY_909 AS SELECT * FROM Employees WHERE first_name = 'Alexander';

CREATE TABLE Manager (
    id NUMBER(3) NOT NULL,
    name VARCHAR2(50) DEFAULT 'No name',
    age NUMBER(3),
    birth_date DATE,
    address VARCHAR2(200)
);

ALTER TABLE manager DROP COLUMN address;
ALTER TABLE manager
ADD (
    city_address VARCHAR2(200),
    street VARCHAR2(200)
);

ALTER TABLE manager RENAME COLUMN full_name TO name;

ALTER TABLE manager READ ONLY;

CREATE TABLE owner AS SELECT id, name , birth_date FROM manager;

ALTER TABLE manager RENAME TO master;


BEGIN
  FOR t IN (SELECT table_name FROM all_tables WHERE owner = 'HR') LOOP
    EXECUTE IMMEDIATE 'DROP TABLE HR.' || t.table_name || ' CASCADE CONSTRAINTS';
  END LOOP;
END;
