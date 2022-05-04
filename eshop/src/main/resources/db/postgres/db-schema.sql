DROP TABLE IF EXISTS product;

CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    product_id UUID NOT NULL,
    name VARCHAR(20) NOT NULL,
    quantity_in_stock INT NOT NULL,
    price DECIMAL(20, 2) NOT NULL,
    description VARCHAR(500) DEFAULT NULL
);
