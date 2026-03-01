--------------------------------------TASK 1---------------------------------------------------
--1) Write a query to display the names of employees and their department names using a natural join.
SELECT FIRST_NAME, LAST_NAME,  DEPARTMENT_NAME FROM EMPLOYEES NATURAL JOIN DEPARTMENTS;

--Write a query to list all orders with their corresponding customer names using a natural join.
SELECT FULL_NAME, order_Name FROM CUSTOMERS NATURAL JOIN ORDERS;

--Write a query to show student names and the courses they are enrolled in using a natural join.
SELECT student_name, course_name FROM students NATURAL JOIN courses;

--Write a query to display project names and the employees working on them using a natural join.
SELECT  project_name, employees_name FROM PROJECTS NATURAL JOIN EMPLOYEES;

--Write a query to retrieve invoice details along with product names using a natural join.
SELECT invoice_id, invoice_date, product_name, quantity, price FROM invoices
NATURAL JOIN invoice_items
NATURAL JOIN products;

--Write a query to find all books with their respective author names using a natural join.
SELECT book_name, author_name FROM BOOKS NATURAL JOIN AUTHOR;

--Write a query to list all class schedules along with their instructors’ names using a natural join.
SELECT class_schedule, instructor_name FROM CLASSES NATURAL JOIN INSTRUCTORS;

--Write a query to show supplier names and the products they supply using a natural join.
SELECT supplier_name, product_name FROM SUPPLIERS NATURAL JOIN PRODUCTS;

--Write a query to display customer orders along with shipping details using a natural join.
SELECT order_id, order_date, shipping_address, shipping_date FROM ORDERS NATURAL JOIN SHIPPING;

--Write a query to list employees along with their job titles using a natural join.
SELECT employee_name, job_title FROM EMPLOYEES NATURAL JOIN JOBS;


--------------------------------------TASK 2---------------------------------------------------
--Write a query to display employee names and department names by joining the employees and departments tables using the USING clause on department_id.
SELECT employee_name, department_name FROM EMPLOYEES JOIN DEPARTMENTS USING(department_id);

--Write a query to list all orders and their corresponding customer names using the USING clause on customer_id.
SELECT order_id, customer_name FROM ORDERS JOIN CUSTOMERS USING(customer_id);

--Write a query to retrieve product names and supplier names from the products and suppliers tables using the USING clause on supplier_id.
SELECT product_name, supplier_name FROM PRODUCTS JOIN SUPPLIERS USING(supplier_id);

--Write a query to show student names and course titles by joining students and enrollments using the USING clause on student_id.
SELECT student_name, course_title FROM STUDENTS JOIN ENROLLMENTS USING (student_id);

--Write a query to display invoice numbers and product names by joining invoices and products using the USING clause on product_id.
SELECT invoice_number, product_name FROM invoices JOIN PRODUCTS USING (product_id);

--Write a query to list project names and employee names using the USING clause on project_id.
SELECT project_name, employee_name FROM PROJECTS JOIN EMPLOYEES USING(project_id);

--Write a query to retrieve author names and book titles using the USING clause on author_id.
SELECT book_name, author_name FROM BOOKS JOIN AUTHOR USING(author_id);

--Write a query to show sales order details with employee names using the USING clause on employee_id.
SELECT order_id, order_date, shipping_address, shipping_date, employee_name FROM ORDERS JOIN EMPLOYEES USING(employee_id);

--Write a query to display course schedules and instructor names using the USING clause on instructor_id.
SELECT course_schedule, instructor_name FROM COURSES JOIN INSTRUCTORS USING(instructor_id);

--Write a query to list transactions along with account holder names using the USING clause on account_id.
SELECT transaction_details, account_name FROM TRANSACTIONS JOIN ACCOUNTS USING(account_id);


--------------------------------------TASK 3-----------------------------------------------------------------------

--Write a query to retrieve employee names and their manager names from the employees table, handling ambiguous column names for employee_id and manager_id.
SELECT e.employee_name AS employee, m.employee_name AS manager FROM EMPLOYEES e LEFT JOIN EMPLOYEES m USING (employee_id);

--Write a query to list customer names and salesperson names from the customers and employees tables, where both tables have a column named name.
SELECT customer_name, salesperson_name FROM customers JOIN employees USING(name);

--Write a query to display order IDs and product IDs from orders and order_details, both of which have an order_id column.
SELECT order_id, order_details FROM orders JOIN order_details USING(order_id);

--Write a query to retrieve student names and instructor names from students and instructors tables using an alias to handle the name column.
SELECT s.name AS student_name, i.name AS instructor_name FROM STUDENTS s JOIN INSTRUCTORS i USING (instructor_id);

--Write a query to show employee salaries and department budgets, both of which have a budget or salary column that could conflict.
SELECT e.salary AS employee_salary, d.department_budget AS department_budget FROM EMPLOYEES e JOIN DEPARTMENTS d USING (department_id);

--Write a query to display project names and task names where both projects and tasks tables contain a name column.
SELECT p.name AS project_name, t.name AS task_name FROM project p JOIN task t using(project_id);

--Write a query to join courses and exams tables and retrieve their date fields, resolving ambiguity between the columns.
SELECT c.date AS course_date, e.date AS exam_date FROM COURSES c JOIN EXAMS e USING (course_id);

--Write a query to show the product name and category name from the products and categories tables, where both have a name column.
SELECT p.name AS product_name, c.name AS category_name FROM PRODUCTS p JOIN CATEGORIES c USING (category_id);

--Write a query to display the book title and publisher name from books and publishers, avoiding column name conflicts.
SELECT b.title AS book_title, p.name AS publisher_name FROM BOOKS b JOIN PUBLISHERS p USING (publisher_id);

--Write a query to list employee names and their department's location, resolving ambiguity in the location column from both tables.
SELECT e.employee_name AS employee_name, d.location AS department_location FROM EMPLOYEES e JOIN DEPARTMENTS d USING (department_id);

