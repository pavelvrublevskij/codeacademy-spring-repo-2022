INSERT INTO product (product_id, name, quantity_in_stock, price, description)
VALUES ('e4dbc123-a7c2-4bee-a519-e1b9ba991341', 'iPhone XM', 200, 1599.99, 'Naujasias iPhone'),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991342', 'Samsung SX', 50, 999.99, 'Pats geriausias telefonas'),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991343', 'Big Mac', 20, 4.99, 'Big burger'),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991344', 'Mac Chicken', 200, 2.99, 'Chincken burger'),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991345', 'Chicken Nuggets', 150, 0.99, 'Small piece of chicken'),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991346', 'Cola', 200, 19.99, 'Dark soda'),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991347', 'Ice cream', 500, 2.99, 'Vanilla'),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991348', 'a', 20, 2.49, 'Hamburger with chseese'),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991358', 'A', 20, 2.49, 'Hamburger with chseese'),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991368', 'b', 20, 2.49, 'Hamburger with chseese'),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991378', 'B', 20, 2.49, 'Hamburger with chseese'),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991388', 'Cheese Burger', 20, 2.49, 'Hamburger with chseese'),
       ('e4dbc123-a7c2-4bee-a519-e1b9ba991349', 'Hamburger', 16, 1.99, 'Bun and meat');

INSERT INTO product_category(name)
VALUES ('Phones'),
       ('Food'),
       ('Drink'),
       ('Trash');

INSERT INTO product_product_categories(products_id, product_categories_id)
VALUES (1, 1),
       (3, 2);


INSERT INTO users(name, surname, email, password, zip_code, phone_number)
VALUES
    ('Admin', 'Pavardenis', 'admin@eshop.lt', '{bcrypt}$2a$10$kf8cJpZFe1z3hrI9O/Cjnuh.SKShYOMEGlYigeKxRvwqBAQ4jKJze', 'LT-00001', ''), -- pass is admin
    ('User', 'Pavardenis', 'user@eshop.lt', '{bcrypt}$2a$10$auHiOfM5qK7.M2ghqP5X/.U2XOa2OjADI7X/6cM9MEI3HglrZuWLW', 'LT-00001', ''); -- pass is user

INSERT INTO authority(name)
VALUES
    ('ADMIN'),
    ('USER');

INSERT INTO users_authorities(user_id, authorities_id)
VALUES
    (1, 1),
    (1, 2),
    (2, 2);


