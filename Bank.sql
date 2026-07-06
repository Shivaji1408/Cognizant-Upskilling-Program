CREATE TABLE Customers (
    CustomerID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    DOB DATE,
    Balance NUMBER,
    LastModified DATE
);

CREATE TABLE Accounts (
    AccountID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    AccountType VARCHAR2(20),
    Balance NUMBER,
    LastModified DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Transactions (
    TransactionID NUMBER PRIMARY KEY,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    FOREIGN KEY (AccountID) REFERENCES Accounts(AccountID)
);

CREATE TABLE Loans (
    LoanID NUMBER PRIMARY KEY,
    CustomerID NUMBER,
    LoanAmount NUMBER,
    InterestRate NUMBER,
    StartDate DATE,
    EndDate DATE,
    FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);

CREATE TABLE Employees (
    EmployeeID NUMBER PRIMARY KEY,
    Name VARCHAR2(100),
    Position VARCHAR2(50),
    Salary NUMBER,
    Department VARCHAR2(50),
    HireDate DATE
);

-- Customers table
INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (1, 'John Doe', TO_DATE('1963-05-15', 'YYYY-MM-DD'), 1000, SYSDATE);

INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (2, 'Jane Smith', TO_DATE('1990-07-20', 'YYYY-MM-DD'), 1500, SYSDATE);


-- Accounts table
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (1, 1, 'Savings', 1000, SYSDATE);

INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (2, 2, 'Checking', 1500, SYSDATE);


-- Transactions table
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (1, 1, SYSDATE, 200, 'Deposit');

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (2, 2, SYSDATE, 300, 'Withdrawal');


-- Loans table
INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (1, 1, 5000, 5, SYSDATE, ADD_MONTHS(SYSDATE, 60));

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (2, 2, 10000, 5, SYSDATE, SYSDATE + 25);


-- Employees table
INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', TO_DATE('2015-06-15', 'YYYY-MM-DD'));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (2, 'Sakthivel', 'Developer', 60000, 'IT', TO_DATE('2017-03-20', 'YYYY-MM-DD'));

-- Checking the DataBases
SELECT * FROM CUSTOMERS;
SELECT * FROM ACCOUNTS;
SELECT * FROM TRANSACTIONS;
SELECT * FROM LOANS;
SELECT * FROM EMPLOYEES;

SET SERVEROUTPUT ON;

ALTER TABLE Customers ADD IsVIP CHAR(1);


-- SCENARIO - 1
-- Procedure to apply interest discount to customers above 60 years old
CREATE OR REPLACE PROCEDURE ApplyInterestDiscount IS
    CURSOR cur IS
        SELECT CustomerID, DOB FROM Customers;
    
    cur_CustomerID Customers.CustomerID%TYPE;
    cur_DOB Customers.DOB%TYPE;
    currentDATE DATE := SYSDATE;
BEGIN
    FOR customer_rec IN cur LOOP
        IF MONTHS_BETWEEN(currentDATE, customer_rec.DOB) / 12 > 60 THEN
            UPDATE Loans
            SET InterestRate = InterestRate * 0.99
            WHERE CustomerID = customer_rec.CustomerID;
            DBMS_OUTPUT.PUT_LINE('CustomerID: ' || customer_rec.CustomerID || ' interest rate is decreased by 1%.');
        END IF;
    END LOOP;
END ApplyInterestDiscount;
/


-- SCENARIO - 2
-- Procedure to promote customers to VIP status based on balance
CREATE OR REPLACE PROCEDURE PromoteToVIP IS
    CURSOR cur IS
        SELECT CustomerID, Balance FROM Accounts;
    
    cur_CustomerID Accounts.CustomerID%TYPE;
    cur_Balance Accounts.Balance%TYPE;
BEGIN
    FOR account_record IN cur LOOP
        IF account_record.Balance > 5000 THEN
            UPDATE Customers
            SET IsVIP = 'Y'
            WHERE CustomerID = account_record.CustomerID;
            DBMS_OUTPUT.PUT_LINE('CustomerID: ' || account_record.CustomerID || ' promoted to VIP.');
        ELSE
            UPDATE Customers
            SET IsVIP = 'N'
            WHERE CustomerID = account_record.CustomerID;
            DBMS_OUTPUT.PUT_LINE('CustomerID: ' || account_record.CustomerID || ' demoted from VIP.');
        END IF;
    END LOOP;
END PromoteToVIP;
/