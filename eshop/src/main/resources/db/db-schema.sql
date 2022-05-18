DROP TABLE IF EXISTS product_product_categories;

DROP TABLE IF EXISTS product;
CREATE TABLE product
(
    id                BIGINT PRIMARY KEY AUTO_INCREMENT,
    product_id        UUID           NOT NULL,
    name              VARCHAR(20)    NOT NULL,
    quantity_in_stock INT            NOT NULL,
    price             DECIMAL(20, 2) NOT NULL,
    description       VARCHAR(500) DEFAULT NULL
);

DROP TABLE IF EXISTS product_category;
CREATE TABLE product_category
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(20) NOT NULL
);

CREATE TABLE product_product_categories
(
    products_id   BIGINT,
    product_categories_id BIGINT,
    FOREIGN KEY (products_id) REFERENCES product(id),
    FOREIGN KEY (product_categories_id) REFERENCES product_category(id)
);

DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    id                BIGINT PRIMARY KEY AUTO_INCREMENT,
    name              VARCHAR(20)    NOT NULL,
    surname           VARCHAR(50)    NOT NULL,
    email             VARCHAR(100)   NOT NULL,
    password          VARCHAR(255)   NOT NULL,
    zip_code          VARCHAR(10)    NOT NULL,
    phone_number      VARCHAR(12)    NOT NULL
);

