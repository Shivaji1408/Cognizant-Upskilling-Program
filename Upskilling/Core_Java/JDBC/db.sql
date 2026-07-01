CREATE DATABASE college;

USE college;

CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    age INT
);

INSERT INTO students VALUES
(101,'Shiv',20),
(102,'Rahul',21),
(103,'Aman',22);