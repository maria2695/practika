CREATE TABLE staff(
                      id INT PRIMARY KEY,
                      first_name VARCHAR(255) NOT NULL,
                      last_name VARCHAR(255) NOT NULL,
                      position VARCHAR(255) NOT NULL,
                      salary_of_week NUMERIC(10,3) NOT NULL
);