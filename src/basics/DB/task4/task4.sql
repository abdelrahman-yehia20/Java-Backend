-----------------------------------------------Task1 ----------------------------------------

-- Q1. Create a table called EMP_TEST with a column NAME having leading and trailing spaces.
CREATE TABLE EMP_TEST(
		NAME varchar2(50)
);

INSERT INTO EMP_TEST (NAME) VALUES ('   Ahmed   ');
INSERT INTO EMP_TEST (NAME) VALUES ('   Mohamed');
INSERT INTO EMP_TEST (NAME) VALUES ('Abdelrahman   ');
INSERT INTO EMP_TEST (NAME) VALUES ('###Ali###');


-- Q2. Display all names using TRIM to remove both leading and trailing spaces.
SELECT TRIM(NAME) FROM EMP_TEST;
-- Q3. Use LTRIM to remove only leading spaces.
SELECT LTRIM(NAME) FROM EMP_TEST;

-- Q4. Use RTRIM to remove only trailing spaces.
SELECT RTRIM(NAME) FROM EMP_TEST;

-- Q5. Use TRIM to remove a specific character (e.g., ‘*’ or ‘#’) from both sides of a string.
SELECT TRIM('#' FROM NAME) FROM EMP_TEST;

-----------------------------------------------Task2 ----------------------------------------
-- Q1. Use REPLACE to replace the letter 'a' with '@' in the word 'database'.
SELECT REPLACE('database','a','@')  AS result FROM dual;

-- Q2. Use REPLACE to replace a full word in a string (e.g., "old" with "new").
SELECT REPLACE('new old new','old','new')  AS result FROM dual;

-- Q3. Create a table PRODUCT with a product_name column, and insert 3 sample products.
CREATE TABLE product( product_name varchar2(50));
INSERT INTO product(product_name) VALUES ('Ahmed');
INSERT INTO product(product_name) VALUES ('Mohamed');
INSERT INTO product(product_name) VALUES ('Taher');

-- Q4. Use LPAD to format product names to 15 characters by padding with '*' on the left.
SELECT LPAD(product_name, 15, '*') AS result FROM product;

-- Q5. Use RPAD to format product names to 15 characters by padding with '#' on the right.
SELECT RPAD(product_name, 15, '#') AS result FROM product;

-----------------------------------------------Task3 ----------------------------------------

-- Q1. Display current date in the format 'DD-MON-YYYY'.
SELECT TO_CHAR(SYSDATE, 'DD-MON-YYYY') AS Current_date FROM dual;

-- Q2. Display current date in the format 'Month YYYY'.
SELECT TO_CHAR(SYSDATE, 'Month YYYY') AS Current_date FROM dual;

-- Q3. Convert a number to character using TO_CHAR with formatting (e.g., 12345.67 as '12,345.67').
SELECT TO_CHAR(12345.67, '99,999.99') AS formatted_number FROM dual;

-- Q4. Show salary formatted with a currency symbol.
SELECT TO_CHAR(12345.67, '$99,999.99') AS formatted_salary FROM dual;


-----------------------------------------------Task4 ----------------------------------------

-- Q1. Create a table STUDENTS with columns: name, marks.
CREATE TABLE students(
						name varchar2(50),
						marks number(3)
	);	 
-- Q2. Insert 5 sample students with marks.
INSERT INTO students(name, marks) VALUES ('ahmed', 95);
INSERT INTO students(name, marks) VALUES ('mohamed', 82);
INSERT INTO students(name, marks) VALUES ('ali', 76);
INSERT INTO students(name, marks) VALUES ('tamer', 65);
INSERT INTO students(name, marks) VALUES ('samer', 88);

-- Q3. Use CASE to assign grades: 
--     >=90 => 'A', 80–89 => 'B', 70–79 => 'C', else => 'F'

SELECT name, marks, CASE 
						WHEN marks >=90 THEN 'A'
						WHEN marks >=80 AND marks <= 89 THEN 'B'
						WHEN marks >=70 AND marks <= 79 THEN 'c'
						ELSE 'F'
END AS grade 
FROM students;

-----------------------------------------------Task5 ----------------------------------------
-- Q1. Use DECODE to achieve the same result as the CASE example above.
SELECT 
    name, 
    marks,
    DECODE(
        FLOOR(marks / 10),  
        10, 'A',            
        9,  'A' ,  
        8,  'B', 
        7,  'C',
        'F' 
    ) AS grade
FROM STUDENTS;

-- Q2. Create a table ORDERS with a column status ('P', 'S', 'D').
CREATE TABLE orders( id number(3),
					status CHAR(1));

INSERT INTO orders(id, status) VALUES (1, 'P');
INSERT INTO orders(id, status) VALUES (2, 'S');
INSERT INTO orders(id, status) VALUES (3, 'D');

-- Q3. Use DECODE to display full form of status:
--     'P' => 'Pending', 'S' => 'Shipped', 'D' => 'Delivered'
SELECT id, status ,DECODE(status, 'P', 'Pending', 'S', 'Shipped', 'D', 'Delivered') AS full_status FROM orders;

-----------------------------------------------Task6 ----------------------------------------
-- Q1. Use DECODE to achieve the same result as the CASE example above.
SELECT 
    name, 
    marks,
    DECODE(
        FLOOR(marks / 10),  
        10, 'A',            
        9,  'A' ,  
        8,  'B', 
        7,  'C',
        'F' 
    ) AS grade
FROM STUDENTS;

-- Q2. Create a table ORDERS with a column status ('P', 'S', 'D').
CREATE TABLE orders( id number(3),
					status CHAR(1));

INSERT INTO orders(id, status) VALUES (1, 'P');
INSERT INTO orders(id, status) VALUES (2, 'S');
INSERT INTO orders(id, status) VALUES (3, 'D');

-- Q3. Use DECODE to display full form of status:
--     'P' => 'Pending', 'S' => 'Shipped', 'D' => 'Delivered'
SELECT id, status ,DECODE(status, 'P', 'Pending', 'S', 'Shipped', 'D', 'Delivered') AS full_status FROM orders;

-----------------------------------------------Task7 ----------------------------------------

--1. Character Functions – Part 3 (TRIM, LTRIM, RTRIM)
--Create a table customers with a full_name column. Insert names with extra spaces at the beginning and/or end.
CREATE TABLE customers(
		full_name varchar2(50)
);

INSERT INTO customers (full_name) VALUES ('   Ahmed   ');
INSERT INTO customers (full_name) VALUES ('   Mohmaed');
INSERT INTO customers (full_name) VALUES ('Ali   ');

--Write a query to remove both leading and trailing spaces from the names using TRIM.
SELECT TRIM(full_name) FROM customers;

--Display only the names with leading spaces removed using LTRIM.
SELECT LTRIM(full_name) FROM customers;

--Display only the names with trailing spaces removed using RTRIM.
SELECT RTRIM(full_name) FROM customers;

--Trim specific characters (e.g., $, *, or #) from both sides of a given string.
SELECT TRIM('*'FROM  '***Ahmed***') FROM dual;


----------------------
--2. Character Functions – Part 4 (REPLACE, LPAD, RPAD)
--Replace all occurrences of the letter 'o' with '0' in the word “promotion”.
SELECT REPLACE('promotion','o','0') FROM dual;

--Replace the word “basic” with “advanced” in the sentence “This is a basic course”.
SELECT REPLACE('This is a basic course','basic','advanced') FROM dual;

--Create a departments table with dept_name column. Insert at least 3 department names.
CREATE TABLE departmentss(dept_name varchar2(50));
INSERT INTO departmentss(dept_name) VALUES ('Ahmed');
INSERT INTO departmentss(dept_name) VALUES ('mddhshu');
INSERT INTO departmentss(dept_name) VALUES ('saeed');

--Format each department name to 15 characters by padding with ‘*’ on the left using LPAD.
SELECT LPAD(dept_name, 15, '*')  FROM departmentss;

--Format each department name to 15 characters by padding with ‘-’ on the right using RPAD.
SELECT RPAD(dept_name, 15, '*')  FROM departmentss;


--------------------------------
--3. TO_CHAR Function
--Display the current date in the format DD-MON-YYYY.
SELECT TO_CHAR(SYSDATE, 'DD-MON-YYYY') AS current_date FROM dual;

--Display the current date in the format Day, Month YYYY.
SELECT TO_CHAR(SYSDATE, 'Month YYYY') AS current_date FROM dual;

--Convert a number to a formatted string with commas and two decimal places using TO_CHAR.
SELECT TO_CHAR(12345.7, '99,999.99') AS formatted_number FROM dual;

--Format an employee’s salary to include a currency symbol using TO_CHAR.
SELECT TO_CHAR(12345.7, '$99,999.99') AS salary FROM dual;

--Display system date in the format: YYYY/MM/DD HH24:MI:SS.
SELECT TO_CHAR(SYSDATE, 'YYYY/MM/DD HH24:MI:SS') AS current_datetime FROM dual;

---------------------------------------------
--4. Oracle Conditional Expressions – CASE Expressions
--Create a students table with name and score columns. Insert at least 5 records.
CREATE TABLE STUDENTS (
    name VARCHAR2(50),
    score NUMBER(3)
);

INSERT INTO STUDENTS (name, score) VALUES ('Alice', 95);
INSERT INTO STUDENTS (name, score) VALUES ('Bob', 82);
INSERT INTO STUDENTS (name, score) VALUES ('Charlie', 76);
INSERT INTO STUDENTS (name, score) VALUES ('David', 65);
INSERT INTO STUDENTS (name, score) VALUES ('Eva', 58);

--Write a query using CASE to assign grades based on the score:
--90 and above: A 80–89: B 70–79: C Below 70: F
SELECT 
    name,
    score,
    CASE 
        WHEN score >= 90 THEN 'A'
        WHEN score >= 80 THEN 'B'
        WHEN score >= 70 THEN 'C'
        ELSE 'F'
    END AS grade
FROM STUDENTS;


--Modify the query to display “Pass” if score is 60 or more, otherwise “Fail”.
SELECT 
    name,
    score,
    CASE 
    	WHEN score >= 60 THEN 'Pass'
    	ELSE 'Fail'
    END AS grade FROM STUDENTS;
    
--Use CASE to display a message for each student:
--"Excellent" for A, "Good" for B, "Average" for C, and "Needs Improvement" for F.
SELECT 
    name,
    score,
    CASE 
        WHEN score >= 90 THEN 'Excellent'
        WHEN score >= 80 THEN 'Good'
        WHEN score >= 70 THEN 'Average'
        ELSE 'Needs Improvement'
    END AS message
FROM STUDENTS;

--Write a CASE expression using system date to return the name of the day (e.g., “Today is Monday”).
SELECT 
    TO_CHAR(SYSDATE, 'DD-MON-YYYY') AS today_date,
    CASE TO_CHAR(SYSDATE, 'DY')
        WHEN 'MON' THEN 'Today is Monday'
        WHEN 'TUE' THEN 'Today is Tuesday'
        WHEN 'WED' THEN 'Today is Wednesday'
        WHEN 'THU' THEN 'Today is Thursday'
        WHEN 'FRI' THEN 'Today is Friday'
        WHEN 'SAT' THEN 'Today is Saturday'
        WHEN 'SUN' THEN 'Today is Sunday'
    END AS day_message
FROM dual;


----------------------------------------------------
------------------------------
--5. Oracle Conditional Expressions – DECODE Function
--Use DECODE to return grade letters ('A', 'B', 'C', 'F') based on specific score values (e.g., 100 = A, 90 = B, etc.).
SELECT 
    name, 
    marks,
    DECODE(
        FLOOR(marks / 10),  
        10, 'A',            
        9,  'A' ,  
        8,  'B', 
        7,  'C',
        'F' 
    ) AS grade
FROM STUDENTS;


--Create a status_log table with a status_code column containing values like ‘N’, ‘I’, ‘C’.
--Use DECODE to convert: ‘N’ → ‘New’ ‘I’ → ‘In Progress’ ‘C’ → ‘Completed’
CREATE TABLE STATUS_LOG (
    status_code CHAR(1)
);

INSERT INTO STATUS_LOG (status_code) VALUES ('N');
INSERT INTO STATUS_LOG (status_code) VALUES ('I');
INSERT INTO STATUS_LOG (status_code) VALUES ('C');
INSERT INTO STATUS_LOG (status_code) VALUES ('X'); -- unknown code

SELECT 
    status_code,
    DECODE(status_code,
           'N', 'New',
           'I', 'In Progress',
           'C', 'Completed',
           'Unknown') AS status_description
FROM STATUS_LOG;


--Use DECODE to check if a product’s quantity is 0, and display “Out of Stock”, otherwise “Available”.
CREATE TABLE PRODUCTS (
    product_name VARCHAR2(50),
    quantity NUMBER
);

INSERT INTO PRODUCTS (product_name, quantity) VALUES ('Laptop', 5);
INSERT INTO PRODUCTS (product_name, quantity) VALUES ('Mouse', 0);

SELECT 
    product_name,
    quantity,
    DECODE(quantity, 0, 'Out of Stock', 'Available') AS stock_status
FROM PRODUCTS;

--Write a query using DECODE to display a bonus:
--If department is ‘HR’ → 500
--If department is ‘IT’ → 1000
--If department is ‘Sales’ → 1500
--Else → 300

CREATE TABLE EMPLOYEES (
    emp_name VARCHAR2(50),
    department VARCHAR2(10)
);

INSERT INTO EMPLOYEES (emp_name, department) VALUES ('Alice', 'HR');
INSERT INTO EMPLOYEES (emp_name, department) VALUES ('Bob', 'IT');
INSERT INTO EMPLOYEES (emp_name, department) VALUES ('Charlie', 'Sales');
INSERT INTO EMPLOYEES (emp_name, department) VALUES ('David', 'Finance');

SELECT 
    emp_name,
    department,
    DECODE(department,
           'HR', 500,
           'IT', 1000,
           'Sales', 1500,
           300) AS bonus
FROM EMPLOYEES;


-----------------------------------------------Task8 ----------------------------------------
--1. AVG Function --Write an SQL query to calculate the average salary of all employees from the EMPLOYEES table.
SELECT AVG(salary) AS average_salary  FROM EMPLOYEES ;


--2. COUNT FUNCTION Write an SQL query to count the total number of employees in the EMPLOYEES table.
SELECT COUNT(*) AS total_employee  FROM EMPLOYEES ;

--3. MAX FUNCTION Write an SQL query to find the maximum salary offered in the EMPLOYEES table.
SELECT MAX(salary) AS max_salary  FROM EMPLOYEES ;

--4. MIN FUNCTION Write an SQL query to find the minimum salary offered in the EMPLOYEES table.
SELECT MIN(salary) AS min_salary  FROM EMPLOYEES ;

--5. SUM FUNCTION Write an SQL query to calculate the total salary that the company pays to all employees.
SELECT SUM(salary) AS min_salary  FROM EMPLOYEES ;

--6. GROUP BY Clause (Part 1) Write an SQL query to display the department ID and the average salary of employees grouped by department from the EMPLOYEES table.
SELECT department_id , AVG(salary) AS avg_salary FROM EMPLOYEES GROUP BY department_id;

--7. GROUP BY Clause (Part 2) Write an SQL query to show job ID and the total number of employees for each job title in the EMPLOYEES table.
SELECT  JOB_ID , COUNT(*) FROM EMPLOYEES GROUP BY JOB_ID ;

--8. HAVING Clause Question:Write an SQL query to display the department ID and the total salary of employees only for departments where the total salary exceeds 50,000.(Hint: Use GROUP BY and HAVING together.)
SELECT department_id, SUM(salary) FROM EMPLOYEES 
GROUP BY department_id;
HAVING SUM(salary) > 50000;

--9. AVG Function (Advanced) Question:Write a query to find the average commission (COMMISSION_PCT) given to employees who have a non-null commission in the EMPLOYEES table.
SELECT AVG(COMMISSION_PCT) AS avg_commission FROM EMPLOYEES 
WHERE COMMISSION_PCT IS NOT NULL;

--10. COUNT Function (Advanced) Question:Write a query to count how many employees have a salary greater than 10,000.
SELECT COUNT(*) AS employees FROM EMPLOYEES
WHERE salary > 10000;

--11. MAX and MIN Together Question: Write a query to find the maximum and minimum salary within each job ID using GROUP BY.
SELECT JOB_ID , MAX(salary) AS max_salary, MIN(salary) AS min_salary FROM EMPLOYEES 
GROUP BY JOB_ID ;

--12. SUM Function (Advanced) Question:Write a query to sum the salaries for each manager (MANAGER_ID) in the EMPLOYEES table.
SELECT  MANAGER_ID, SUM(SALARY) AS total_salary FROM EMPLOYEES
GROUP BY MANAGER_ID;

--13. GROUP BY with Multiple Columns Question:Write a query to display department ID and job ID, and show the total salary for each group (department + job combination).
SELECT department_id, job_id, SUM(salary) AS total_salary FROM EMPLOYEES
GROUP BY department_id, job_id
ORDER BY department_id, job_id;

--14. HAVING with COUNT Question: Write a query to display job ID and count of employees for each job, only show jobs that have more than 5 employees.
SELECT JOB_ID, COUNT(*) AS employee_count FROM EMPLOYEES
GROUP BY JOB_ID
HAVING COUNT(*) > 5
ORDER BY employee_count DESC;

--15. Using Aggregate Functions Together Question: Write a query to show each department ID with: Total employees, Average salary, Maximum salary, Minimum salary, and group them by department ID
SELECT 
    department_id,
    COUNT(*) AS total_employees,
    AVG(salary) AS avg_salary,
    MAX(salary) AS max_salary,
    MIN(salary) AS min_salary
FROM EMPLOYEES
GROUP BY department_id
ORDER BY department_id;


--16. Complex HAVING Question: Write a query to find all departments where: The average salary is more than 8000, And the number of employees is less than 10.

SELECT 
    department_id,
    COUNT(*) AS total_employees,
    AVG(salary) AS avg_salary
FROM EMPLOYEES
GROUP BY department_id
HAVING AVG(salary) > 8000
   AND COUNT(*) < 10
ORDER BY department_id;


--17. Nested Aggregation Question: Write a query to find the department that has the highest total salary among all departments. (Hint: You can use GROUP BY + ORDER BY DESC + FETCH FIRST 1 ROW ONLY.)
SELECT 
    department_id,
    SUM(salary) AS total_salary
FROM EMPLOYEES
GROUP BY department_id
ORDER BY total_salary DESC
FETCH FIRST 1 ROW ONLY;


--18. Using Aliases with Aggregates Question: Write a query to show department ID, sum of salaries as Total_Salary, and average salary as Average_Salary, grouped by department ID.
SELECT 
    department_id,
    SUM(salary) AS Total_Salary,
    AVG(salary) AS Average_Salary
FROM EMPLOYEES
GROUP BY department_id
ORDER BY department_id;

