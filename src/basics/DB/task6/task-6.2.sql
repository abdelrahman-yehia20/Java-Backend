------------------------------------------------------------task1---------------------------------------------------------------------
--💡 Oracle SQL – LEFT OUTER JOIN Coding Questions
--Retrieve all employees and their department names.
--Write an Oracle SQL query using LEFT OUTER JOIN to show all employees, including those who are not assigned to any department.
SELECT e.name, d.name FROM EMPLOYEES e LEFT JOIN DEPARTMENT d ON e.department_id = d.id ;

--List all products and their associated categories.
--Some products may not belong to any category. Write a query using LEFT JOIN to include all products regardless of category association.
SELECT p.product_name, c.category_name FROM PRODUCT p LEFT OUTER JOIN CATEGORY c ON p.category_id = c.id;

--Find all students and the courses they are enrolled in.
--Use a LEFT OUTER JOIN to include students who are not enrolled in any course.
SELECT s.student_name, c.course_name FROM STUDENTS s
LEFT OUTER JOIN ENROLLMENTS e ON s.student_id = e.student_id
LEFT OUTER JOIN COURSES c ON e.course_id = c.course_id;

--Display all orders with customer names, including orders without a matched customer.
--Assume the orders table has a foreign key customer_id. Use LEFT JOIN to include all orders.
SELECT o.name AS order_name, c.name AS customer_name FROM ORDERS o LEFT OUTER JOIN CUSTOMERS c ON o.customer_id = c.id;

--Show all departments and their managers.
--Write a query to return all departments using a LEFT OUTER JOIN to show their assigned managers, including departments with no manager.
SELECT d.department_name, e.employee_name AS manager_name FROM DEPARTMENTS d LEFT OUTER JOIN EMPLOYEES e ON d.manager_id = e.employee_id;

--List all books and their authors from the books and authors tables.
--Include books that don’t have an assigned author using a LEFT JOIN.
SELECT b.book_title, a.author_name FROM BOOKS b LEFT JOIN AUTHORS a ON b.author_id = a.author_id;

--Write a query that retrieves all invoices along with their corresponding payment status.
--Use LEFT JOIN to include invoices with no payment.
SELECT i.invoice_number, p.payment_status FROM INVOICES i LEFT JOIN PAYMENTS p ON i.invoice_id = p.invoice_id;

--Get all employees and their projects from employees and projects_assigned tables.
--Include employees who are not assigned to any project.
SELECT e.employee_name, p.project_name FROM EMPLOYEES e LEFT JOIN PROJECTS_ASSIGNED p ON e.employee_id = p.employee_id;


------------------------------------------------------------task2---------------------------------------------------------------------

--💡 Oracle SQL – RIGHT OUTER JOIN Coding Questions
--List all departments and the employees working in them.
--Use a RIGHT OUTER JOIN to ensure all departments are shown, even if they have no employees.
SELECT e.name, d.name FROM EMPLOYEES e RIGHT OUTER JOIN DEPARTMENTS d ON d.id = e.department_id;

--Retrieve all orders and their corresponding customers.
--Use a RIGHT JOIN to include all customers, even if they haven't placed any orders.
SELECT o.details, c.name FROM orders o RIGHT OUTER JOIN customer c ON o.customer_id = c.id;

--Show all courses and enrolled students.
--Use RIGHT JOIN to return all courses, including those without any enrolled students.
SELECT s.student_name, c.course_name FROM STUDENTS s
RIGHT OUTER JOIN ENROLLMENTS e ON s.student_id = e.student_id
RIGHT OUTER JOIN COURSES c ON e.course_id = c.course_id;

--Display all projects and the employees assigned to them.
--Use a RIGHT OUTER JOIN to include all projects even if no employee is assigned.
SELECT e.employee_name, p.project_name FROM EMPLOYEES e RIGHT OUTER JOIN PROJECTS p ON e.employee_id = p.employee_id;
--Write a query to show all payment methods and their related transactions.
--Include payment methods with no transactions using RIGHT JOIN.

--Find all authors and their books.
--Use a RIGHT OUTER JOIN to list all authors, even those who haven't written any books.
SELECT b.book_title, a.author_name FROM BOOKS b RIGHT JOIN AUTHORS a ON b.author_id = a.author_id;

--List all categories and the products under them.
--Use a RIGHT JOIN to ensure all categories are shown, even those with no products.
SELECT c.name, p.name FROM products p  RIGHT JOIN categories c ON c.id = p.category_id;

--Retrieve all students and their assigned dorm rooms.
--Use a RIGHT OUTER JOIN to include dorm rooms even if they are unassigned.

SELECT s.name, r.name FROM students s RIGHT JOIN rooms r ON s.room_id = r.id;

--------------------------------------------------------------Task 3--------------------------------------------------------------------------
--💡 Oracle SQL – FULL OUTER JOIN Coding Questions
--Write a query to list all customers and all orders.
--Use a FULL OUTER JOIN to include customers with no orders and orders with no matching customer.
SELECT c.customer_name, o.order_id FROM CUSTOMERS c FULL OUTER JOIN ORDERS o ON c.customer_id = o.customer_id;

--Display all employees and all projects.
--Some employees may not be assigned to any project, and some projects may not have any employee. Use a FULL OUTER JOIN.
SELECT e.employee_name, p.project_name FROM EMPLOYEES e FULL OUTER JOIN PROJECTS p ON e.project_id = p.project_id;

--Show all products and all suppliers.
--Include products without suppliers and suppliers without products using FULL OUTER JOIN.
SELECT p.product_name, s.supplier_name FROM PRODUCTS p FULL OUTER JOIN SUPPLIERS s ON p.supplier_id = s.supplier_id;

--List all students and all courses.
--Write a FULL OUTER JOIN query to include students not enrolled in any course and courses with no students.
SELECT s.student_name, c.course_name FROM STUDENTS s FULL OUTER JOIN COURSES c ON s.course_id = c.course_id;

--Retrieve all authors and all books.
--Include authors with no books and books without an assigned author using FULL OUTER JOIN.
SELECT a.author_name, b.book_title FROM AUTHORS a FULL OUTER JOIN BOOKS b ON a.author_id = b.author_id;

--Write a query to find all employees and all departments.
--Include employees not assigned to any department and departments with no employees.
SELECT e.employee_name, d.department_name FROM EMPLOYEES e FULL OUTER JOIN DEPARTMENTS d ON e.department_id = d.department_id;

--Show all transactions and all payment methods.
--Include unmatched records from both sides using a FULL OUTER JOIN.
SELECT t.transaction_id, p.method_name FROM TRANSACTIONS t FULL OUTER JOIN PAYMENT_METHODS p ON t.method_id = p.method_id;

--Combine two customer lists from two different regions.
--Use FULL OUTER JOIN to include all customers from both regions, even if they don’t exist in both lists.
SELECT r1.name AS region1_customer, r2.name AS region2_customer FROM CUSTOMERS_REGION1 r1
FULL OUTER JOIN CUSTOMERS_REGION2 r2
ON r1.customer_id = r2.customer_id;


--------------------------------------------------------------Task 4--------------------------------------------------------------------------
--💡 Oracle SQL – Subqueries Coding Questions
--Find the names of employees who earn more than the average salary.
--Use a subquery to calculate the average salary.
SELECT employee_name FROM EMPLOYEES WHERE SALARY > (SELECT AVG(salary) FROM EMPLOYEES);

--List the customers who placed the highest number of orders.
--Use a subquery to count orders per customer and compare with the max count.
SELECT customer_id FROM ORDERS
GROUP BY customer_id
HAVING COUNT(*) = (
    SELECT MAX(order_count)
    FROM ( SELECT COUNT(*) AS order_count FROM ORDERS
        GROUP BY customer_id
    ));

--Retrieve all products whose price is higher than any product in the ‘Accessories’ category.
--Use a subquery inside a WHERE clause with ANY.
SELECT product_name FROM PRODUCTS WHERE price > ANY ( SELECT price FROM PRODUCTS WHERE category = 'Accessories' );

--Display employees who work in the same department as 'John Smith'.
--Use a subquery to get John Smith’s department ID.
SELECT employee_name FROM EMPLOYEES WHERE department_id = ( SELECT department_id FROM EMPLOYEES WHERE employee_name = 'John Smith');

--Get all orders that were placed by customers from 'New York'.
--Use a subquery to filter customers based on city.
SELECT * FROM ORDERS WHERE customer_id IN (SELECT customer_id FROM CUSTOMERS WHERE city = 'New York');


--Find the departments that have no employees.
--Use a NOT EXISTS subquery to check for departments without employees.
SELECT department_name FROM DEPARTMENTS d WHERE NOT EXISTS ( SELECT 1 FROM EMPLOYEES e WHERE e.department_id = d.department_id );


--List the students who are not enrolled in any course.
--Use a subquery with NOT IN or NOT EXISTS.
SELECT student_name FROM STUDENTS s WHERE NOT EXISTS ( SELECT 1 FROM ENROLLMENTS e WHERE e.student_id = s.student_id );

--Retrieve the second highest salary from the employees table.
--Use a subquery with MAX and WHERE.
SELECT MAX(salary) FROM EMPLOYEES WHERE salary < ( SELECT MAX(salary) FROM EMPLOYEES );


--Display products that have a price greater than the average price of all products.
--Use a scalar subquery to get the average price.
SELECT product_name  FROM PRODUCTS WHERE price > ( SELECT AVG(price) FROM PRODUCTS);

--Find customers who have ordered all products in category 'A'.
--Use a correlated subquery with NOT EXISTS.
SELECT c.customer_id
FROM CUSTOMERS c
WHERE NOT EXISTS (
    SELECT p.product_id
    FROM PRODUCTS p
    WHERE p.category = 'A'
    AND NOT EXISTS (
        SELECT 1
        FROM ORDERS o
        WHERE o.customer_id = c.customer_id
        AND o.product_id = p.product_id
    )
);

-------------------------------------------------------------Task 5-------------------------------------------------------------------------
--💡 Oracle SQL – Single Row Subqueries Coding Questions
--Find the employee(s) with the highest salary.
--Use a single-row subquery to get the maximum salary.
SELECT employee_name FROM EMPLOYEES WHERE salary = ( SELECT MAX(salary) FROM EMPLOYEES );
--
--List the names of employees who work in the same department as employee 'Alice'.
--Use a subquery to get the department ID of 'Alice'.
SELECT employee_name FROM EMPLOYEES WHERE department_id = ( SELECT department_id FROM EMPLOYEES WHERE employee_name = 'Alice' );
--
--Display the details of the product with the lowest price.
--Use a single-row subquery to get the minimum price.
SELECT * FROM PRODUCTS WHERE price = ( SELECT MIN(price) FROM PRODUCTS);
--
--Retrieve the department name of the employee with the highest salary.
--Use nested subqueries: one to find the employee, and one to find the department.
SELECT department_name FROM DEPARTMENTS WHERE department_id = ( SELECT department_id FROM EMPLOYEES WHERE salary = ( SELECT MAX(salary)FROM EMPLOYEES));
--
--Find the manager of the employee who was hired most recently.
--Use a subquery to get the employee with the latest hire date.
SELECT m.employee_name AS manager_name
FROM EMPLOYEES m
WHERE m.employee_id = (
    SELECT manager_id
    FROM EMPLOYEES
    WHERE hire_date = (
        SELECT MAX(hire_date)
        FROM EMPLOYEES
    )
);
--
--Show the employee whose salary is equal to the average salary of the company.
--Use a single-row subquery with AVG().
SELECT employee_name FROM EMPLOYEES WHERE salary = (SELECT AVG(salary) FROM EMPLOYEES);
--
--List the order(s) with the earliest order date.
--Use a subquery to get the minimum order date.
SELECT * FROM ORDERS WHERE order_date = ( SELECT MIN(order_date) FROM ORDERS );
--
--Get the name and salary of the employee who earns more than the employee with ID = 101.
--Use a single-row subquery to get the salary of employee 101.
SELECT employee_name, salary FROM EMPLOYEES WHERE salary > ( SELECT salary FROM EMPLOYEES WHERE employee_id = 101 );
--
--Find the student who has the same GPA as student 'John Doe'.
--Use a subquery to get 'John Doe’s GPA'.
SELECT student_name FROM STUDENTS WHERE gpa = ( SELECT gpa FROM STUDENTS WHERE student_name = 'John Doe' );
--
--Display all books that have the same price as the most expensive book in the ‘Science’ category.
--Use a subquery to find the max price from the 'Science' category.
SELECT book_title FROM BOOKS WHERE price = ( SELECT MAX(price) FROM BOOKS WHERE category = 'Science');



-------------------------------------------------------task 6----------------------------------------------------------------------------

--💡 Oracle SQL – Multiple Row Subqueries Coding Questions
--Find all employees who earn more than at least one employee in department 10.
--Use a subquery with ANY or SOME.
SELECT employee_name
FROM EMPLOYEES
WHERE salary > ANY (
    SELECT salary
    FROM EMPLOYEES
    WHERE department_id = 10
);


--List the employees who earn less than all employees in department 20.
--Use a subquery with ALL.
SELECT employee_name
FROM EMPLOYEES
WHERE salary < ALL (
    SELECT salary
    FROM EMPLOYEES
    WHERE department_id = 20
);


--Display products that have a price equal to any product in the 'Electronics' category.
--Use a subquery inside an IN clause.
SELECT product_name
FROM PRODUCTS
WHERE price IN (
    SELECT price
    FROM PRODUCTS
    WHERE category = 'Electronics'
);


--Retrieve names of customers who have placed an order for a product with price greater than $1000.
--Use a subquery with IN or EXISTS.
SELECT customer_name
FROM CUSTOMERS
WHERE customer_id IN (
    SELECT customer_id
    FROM ORDERS
    WHERE product_id IN (
        SELECT product_id
        FROM PRODUCTS
        WHERE price > 1000
    )
);


--List the employees who work in the same job titles as at least one other employee.
--Use a subquery with IN on job titles.
SELECT employee_name
FROM EMPLOYEES
WHERE job_title IN (
    SELECT job_title
    FROM EMPLOYEES
    GROUP BY job_title
    HAVING COUNT(*) > 1
);


--Find the departments that have more than one employee.
--Use a subquery with GROUP BY and HAVING, or join with a subquery returning multiple department IDs.
SELECT department_name
FROM DEPARTMENTS
WHERE department_id IN (
    SELECT department_id
    FROM EMPLOYEES
    GROUP BY department_id
    HAVING COUNT(*) > 1
);


--Show all orders placed by customers who are from cities where other customers have placed orders too.
--Use a correlated subquery or a multiple-row subquery with IN.
SELECT *
FROM ORDERS
WHERE customer_id IN (
    SELECT c1.customer_id
    FROM CUSTOMERS c1
    WHERE c1.city IN (
        SELECT c2.city
        FROM CUSTOMERS c2
        JOIN ORDERS o ON c2.customer_id = o.customer_id
        GROUP BY c2.city
        HAVING COUNT(DISTINCT c2.customer_id) > 1
    )
);


--List all books that were written by authors who have published more than one book.
--Use a subquery with GROUP BY and HAVING.
SELECT book_title
FROM BOOKS
WHERE author_id IN (
    SELECT author_id
    FROM BOOKS
    GROUP BY author_id
    HAVING COUNT(*) > 1
);

--Display the names of students who are enrolled in any of the courses taught by professor 'Dr. Smith'.
--Use a subquery to get course IDs.
SELECT student_name
FROM STUDENTS
WHERE student_id IN (
    SELECT student_id
    FROM ENROLLMENTS
    WHERE course_id IN (
        SELECT course_id
        FROM COURSES
        WHERE instructor_name = 'Dr. Smith'
    )
);


--Retrieve all employees whose salary matches any of the salaries in department 30.
--Use a subquery with IN.
SELECT employee_name
FROM EMPLOYEES
WHERE salary IN (
    SELECT salary
    FROM EMPLOYEES
    WHERE department_id = 30
);


--
--
--
--
--
