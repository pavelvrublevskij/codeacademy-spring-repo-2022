DROP TABLE IF EXISTS product_product_categories;

DROP TABLE IF EXISTS product;
CREATE TABLE product
(
    id                BIGSERIAL PRIMARY KEY,
    product_id        UUID           NOT NULL,
    name              VARCHAR(20)    NOT NULL,
    quantity_in_stock INT            NOT NULL,
    price             DECIMAL(20, 2) NOT NULL,
    description       VARCHAR(500) DEFAULT NULL
);

DROP TABLE IF EXISTS product_category;
CREATE TABLE product_category
(
    id         BIGSERIAL PRIMARY KEY,
    name       VARCHAR(20) NOT NULL,
    CONSTRAINT product_category_key UNIQUE (name)
);

CREATE TABLE product_product_categories
(
    products_id   BIGINT,
    product_categories_id BIGINT,
    FOREIGN KEY (products_id) REFERENCES product(id),
    FOREIGN KEY (product_categories_id) REFERENCES product_category(id)
);

DROP TABLE IF EXISTS users_authorities;

DROP TABLE IF EXISTS users;
CREATE TABLE users
(
    id                BIGSERIAL PRIMARY KEY,
    name              VARCHAR(20)    NOT NULL,
    surname           VARCHAR(50)    NOT NULL,
    email             VARCHAR(100)   NOT NULL,
    password          VARCHAR(255)   NOT NULL,
    zip_code          VARCHAR(10)    NOT NULL,
    phone_number      VARCHAR(12)    NOT NULL,
    CONSTRAINT users_key UNIQUE (email)
);

DROP TABLE IF EXISTS authority;
CREATE TABLE authority
(
    id                BIGSERIAL PRIMARY KEY,
    name              VARCHAR(100)    NOT NULL,
    CONSTRAINT authority_key UNIQUE (name)
);

CREATE TABLE users_authorities
(
    user_id         BIGINT NOT NULL,
    authorities_id  BIGINT NOT NULL,
    FOREIGN KEY (user_id) REFERENCES users(id),
    FOREIGN KEY (authorities_id) REFERENCES authority(id)
);

DROP TABLE IF EXISTS file;
CREATE TABLE file
(
    id                BIGSERIAL PRIMARY KEY,
    file_id           UUID           NOT NULL,
    file_name         VARCHAR(100)   NOT NULL,
    file_extension    VARCHAR(15)    NOT NULL,
    media_type        VARCHAR(10)    NOT NULL,
    size              BIGINT         NOT NULL,
    timestamp         TIMESTAMP      DEFAULT current_timestamp
);
