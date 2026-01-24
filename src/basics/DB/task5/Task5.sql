--Task 1

CREATE TABLE Player (
    id   NUMBER NOT NULL,
    name VARCHAR(100),
    age  NUMBER,

    CONSTRAINT uq_player_id UNIQUE (id),
    CONSTRAINT uq_player_name UNIQUE (name)
);

--pls create Manger WITH id name salary -id must be not NULL -id and name must be unique together
CREATE TABLE Manger (
    id     NUMBER NOT NULL,
    name   VARCHAR(100) NOT NULL,
    salary NUMBER(10,2),

    CONSTRAINT uq_manger_id_name UNIQUE (id, name)
);

--pls create Manger WITH id name age make id not null and unique (Primary Key)
CREATE TABLE Manger (
    id   INT NOT NULL,
    name VARCHAR(100),
    age  INT,

    CONSTRAINT pk_manger PRIMARY KEY (id)
);

------------------------------------------------
--Task2
--create Doctor with  id name salary
--create Patient WITH id name age
--doctor has many patient patient has many doctor - please create classes with relation

CREATE TABLE Doctor(
	id NUMBER PRIMARY KEY,
	name VARCHAR2(50),
	salary Number(10,2)
);

CREATE TABLE Patient(
	id NUMBER PRIMARY KEY,
	name VARCHAR2(50),
	age Number
);

CREATE TABLE Doctor_Patient(
	doctor_id NUMBER NOT NULL, 
	patient_id NUMBER NOT NULL,
	
	CONSTRAINT doctor_fk FOREIGN KEY (doctor_id) REFERENCES Doctor(id),
	CONSTRAINT patient_fk FOREIGN KEY (patient_id) REFERENCES Patient(id),
	CONSTRAINT  Doctor_Patient_PK UNIQUE(doctor_id, patient_id )
);

------------------------------------------------
--Task3
--create Teacher with  id name salary
--create Language WITH id name 
--Teacher has only LANGUAGE Language has many Teacher - please create classes with relation

CREATE TABLE Teacher(
	id NUMBER PRIMARY KEY,
	name VARCHAR2(50),
	salary Number(10,2)
);

CREATE TABLE Language(
	id NUMBER PRIMARY KEY,
	name VARCHAR2(50),
	Teacher_id NUMBER NOT NULL,
	CONSTRAINT Teacher_fk FOREIGN KEY(Teacher_id) REFERENCES Teacher (id)
);

------------------------------------------------
--Task4
--create Employee with  id name age
--create Phone WITH id phoneNumber 
--Employee has only Phone Phone has only Employee - please create classes with relation

CREATE TABLE Employee(
	id NUMBER PRIMARY KEY,
	name VARCHAR2(50),
	age Number
);

CREATE TABLE Phone(
	id NUMBER PRIMARY KEY,
	PhoneNumber VARCHAR2(20),
	Employee_id NUMBER UNIQUE NOT NULL, 
	CONSTRAINT Employee_fk FOREIGN KEY (Employee_id) REFERENCES Employee (id)
);

------------------------------------------------
--Task5
--create Doctor with id name salary
--create Patient WITH id name age
--doctor has many patient patient has many doctor

CREATE TABLE Doctor(
	id NUMBER PRIMARY KEY,
	name VARCHAR2(50),
	salary Number(10,2)
);

CREATE TABLE Patient(
	id NUMBER PRIMARY KEY,
	name VARCHAR2(50),
	age Number
);

CREATE TABLE Doctor_Patient(
	doctor_id NUMBER NOT NULL,
	patient_id NUMBER NOT NULL,
	
	CONSTRAINT doctor_fk FOREIGN KEY (doctor_id) REFERENCES Doctor(id),
	CONSTRAINT patient_fk FOREIGN KEY (patient_id) REFERENCES Patient(id),
	CONSTRAINT Doctor_Patient UNIQUE (doctor_id, patient_id)
);


------------------------------------------------
--Task6
--create Teacher with  id name salary
--create Language WITH id name 
--Teacher has only LANGUAGE Language has many Teacher

CREATE TABLE Teacher(
	id NUMBER PRIMARY KEY,
	name VARCHAR2(50),
	salary Number(10,2)
);

CREATE TABLE Language(
	id NUMBER PRIMARY KEY,
	name VARCHAR2(50),
	Teacher_id NUMBER NOT NULL, 
	CONSTRAINT Teacher_fk FOREIGN KEY(Teacher_id) REFERENCES Teacher (id) 
);

------------------------------------------------
--Task7
--create Employee with  id name age
--create Phone WITH id phoneNumber 
--Employee has only Phone Phone has only Employee

CREATE TABLE Employee(
	id NUMBER PRIMARY KEY,
	name VARCHAR2(50),
	age Number
);

CREATE TABLE Phone(
	id NUMBER PRIMARY KEY,
	PhoneNumber VARCHAR2(20),
	Employee_id NUMBER UNIQUE NOT NULL,
	CONSTRAINT Employee_fk FOREIGN KEY (Employee_id) REFERENCES Employee (id)
);











