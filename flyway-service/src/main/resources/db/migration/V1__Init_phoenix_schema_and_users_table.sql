-- Created the schema phoenix
create schema phoenix;

-- created a table users
CREATE TABLE phoenix.users
(
    id           SERIAL PRIMARY KEY,
    name         VARCHAR(25)         NOT NULL,
    phone_number VARCHAR(20),
    email        VARCHAR(255) UNIQUE NOT NULL,
    role         VARCHAR(50)         NOT NULL DEFAULT 'USER',
    created_by   INTEGER REFERENCES phoenix.users (id),                  -- Fixed schema reference
    created_at   TIMESTAMP                    DEFAULT CURRENT_TIMESTAMP, -- Fixed: TIMESTAMP not INTEGER
    updated_at   TIMESTAMP                    DEFAULT CURRENT_TIMESTAMP,
    updated_by   varchar(50)
);
