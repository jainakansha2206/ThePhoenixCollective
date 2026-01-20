-- V1__Init_phoenix_schema_and_users_table.sql
CREATE SCHEMA IF NOT EXISTS phoenix;

CREATE TABLE phoenix.users
(
    id           SERIAL PRIMARY KEY,
    name         VARCHAR(25)         NOT NULL,
    phone_number VARCHAR(20),
    email        VARCHAR(255) UNIQUE NOT NULL,
    role         VARCHAR(50)         NOT NULL DEFAULT 'USER',
    created_by   VARCHAR(50),
    created_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_by   VARCHAR(50),
    updated_at   TIMESTAMP DEFAULT CURRENT_TIMESTAMP

);