CREATE TABLE clients(
    id INT PRIMARY KEY,
    first_name VARCHAR(255) NOT NULL,
    last_name VARCHAR(255) NOT NULL,
    age INT NOT NULL,
    credit_balance NUMERIC(10,3) NOT NULL,
    login VARCHAR(255) UNIQUE,
    password VARCHAR(255) NOT NULL
);