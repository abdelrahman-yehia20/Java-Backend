CREATE TABLE Doctor(
	id Number(3) NOT NULL,
	name varchar2(30) DEFAULT 'No name',
	salary Number(6),
	address varchar2(200)
	);


INSERT INTO Doctor VALUES (1,'ahmed',8000,'alex');
INSERT INTO Doctor VALUES (2,'ali',9000,'cairo');
INSERT INTO Doctor VALUES (3,'amr',7000,'alex');
INSERT INTO Doctor VALUES (4,'tamer',6000,'cairo');
INSERT INTO Doctor VALUES (5,'alaa',6500,'alex');
INSERT INTO Doctor VALUES (6,'samer',5000,'cairo');
INSERT INTO Doctor VALUES (7,'taher',6800,'cairo');
INSERT INTO Doctor VALUES (8,'eslam',9300,'alex');
INSERT INTO Doctor VALUES (9,'mahmoud',9100,'cairo');
INSERT INTO Doctor VALUES (10,'zaki',7800,'alex');


UPDATE Doctor 
SET salary = 20000
WHERE id =3;

DELETE FROM Doctor 
WHERE id = 9;


SELECT name || ' ' || salary AS name_salary FROM Doctor;

SELECT id, name, salary * 2 AS double_salary, address FROM Doctor;

SELECT * FROM Doctor WHERE salary =1000 OR salary = 2000 OR salary = 3000;

RENAME Doctor TO PRD_DOCTOR;

------------------------------------------------
--create Employees table wiith column ( EmployeeID, FirstName, LastName, Department, Salary )
CREATE TABLE Employees(
	EmployeeID Number(3) NOT NULL,
	FirstName varchar2(30) DEFAULT 'first name',
	LastName varchar2(30) DEFAULT 'last name',
	Department varchar2(30),
	salary Number(6)
	);

--Insert a new record into the Employees table.
INSERT INTO Employees VALUES (101, 'John1', 'Doe1', 'HR', 20000);
INSERT INTO Employees VALUES (102, 'John2', 'Doe2', 'IT', 50000);
INSERT INTO Employees VALUES (103, 'John3', 'Doe3', 'CS', 40000);
INSERT INTO Employees VALUES (104, 'John4', 'Doe4', 'IT', 10000);
INSERT INTO Employees VALUES (105, 'John5', 'Doe5', 'ZX', 30000);
INSERT INTO Employees VALUES (106, 'John6', 'Doe6', 'ZX', 25000);



--Update the salary of an employee to 600000 with EmployeeID     101.
UPDATE Employees
SET salary = 600000
WHERE EmployeeID = 101;


--Delete a record of an employee who Department = 101.
DELETE FROM Employees WHERE EmployeeID = 101;


--Retrieve all employees in the IT department.
SELECT * FROM Employees WHERE Department = 'IT';


--select * data from table but conatination  FirstName, LastName as one column
SELECT EmployeeID, FirstName || ' '|| LastName AS fullName , Department, salary FROM Employees;



