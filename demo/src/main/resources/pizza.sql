CREATE TABLE pizzas (
                        id INT PRIMARY KEY,
                        name VARCHAR(255) NOT NULL
);

CREATE TABLE pizza_ingredients (
                                   pizza_id INT NOT NULL,
                                   ingredient_id INT NOT NULL,
                                   PRIMARY KEY (pizza_id, ingredient_id),
                                   FOREIGN KEY (pizza_id) REFERENCES pizzas (id),
                                   FOREIGN KEY (ingredient_id) REFERENCES ingredients (id)
);
