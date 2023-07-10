CREATE TABLE transactions (
                              id INT PRIMARY KEY,
                              transaction_date DATE NOT NULL,
                              transaction_amount NUMERIC (10, 3) NOT NULL,
                              client_id INT NOT NULL,
                              drink_id INT NOT NULL,
                              pizza_id INT NOT NULL,
                              FOREIGN KEY (client_id) REFERENCES clients (id),
                              FOREIGN KEY (drink_id) REFERENCES drinks (id),
                              FOREIGN KEY (pizza_id) REFERENCES pizzas (id)
);
