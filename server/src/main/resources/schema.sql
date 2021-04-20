CREATE EXTENSION IF NOT EXISTS pgcrypto;
CREATE SCHEMA IF NOT EXISTS store;

CREATE TABLE IF NOT EXISTS users
(
    username    VARCHAR(10)
        CONSTRAINT valid_username CHECK (char_length(ltrim(username)) > 2) PRIMARY KEY,
    password    text
        CONSTRAINT valid_password CHECK (char_length(password) > 2),
    enabled     boolean      NOT NULL,
    firstName   VARCHAR(50)  NOT NULL,
    lastName    VARCHAR(50)  NOT NULL,
    email       VARCHAR(320) NOT NULL,
    address     VARCHAR(50)  NOT NULL,
    accountType VARCHAR(8)
        CONSTRAINT valid_account_type CHECK (lower(accountType) in ('customer', 'employee', 'manager'))
);

CREATE TABLE IF NOT EXISTS store.items (
    uuid bigint NOT NULL PRIMARY KEY ,
    name VARCHAR(50) NOT NULL,
    description VARCHAR(512) NOT NULL,
    quantity integer NOT NULL,
    price NUMERIC(6, 2) CONSTRAINT positive_price CHECK (price > 0)
);

CREATE TABLE IF NOT EXISTS store.saved_orders (
    username VARCHAR(10) NOT NULL,
    items text NOT NULL
);