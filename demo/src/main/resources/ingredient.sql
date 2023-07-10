CREATE TABLE ingredients(
                        id INT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL,
                        acquisition_cost NUMERIC(10,3) NOT NULL,
                        retail_price NUMERIC(10,3) NOT NULL,
                        number_of_sales INT NOT NULL,
                        count INT NOT NULL
);