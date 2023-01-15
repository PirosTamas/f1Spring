CREATE ROLE f1app WITH
    LOGIN
    SUPERUSER
    CREATEDB
    CREATEROLE
    INHERIT
    REPLICATION
    CONNECTION LIMIT -1
    PASSWORD '12345678';

CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

CREATE TABLE role
(
    id        SERIAL PRIMARY KEY,
    role_name VARCHAR(100)
);

CREATE TABLE user_role
(
    id      SERIAL PRIMARY KEY,
    user_id SERIAL NOT NULL REFERENCES users (id),
    role_id SERIAL NOT NULL REFERENCES role (id)
);
CREATE TABLE driver
(
    id              SERIAL PRIMARY KEY,
    driver_name     VARCHAR(100) NOT NULL UNIQUE,
    team            VARCHAR(100) NOT NULL
);

INSERT INTO users (username, password)
VALUES ('admin', '$2a$12$AlrROU6TkYmEMaqCMuUX1OXvbBU1DC0Ft9aTyrEOSncX7wdODjmDW');
INSERT INTO users (username, password)
VALUES ('player1', '$2a$12$AlrROU6TkYmEMaqCMuUX1OXvbBU1DC0Ft9aTyrEOSncX7wdODjmDW');

INSERT INTO role (role_name)
VALUES ('ADMIN');
INSERT INTO role (role_name)
VALUES ('PLAYER');

INSERT INTO user_role (user_id, role_id)
SELECT *
FROM (SELECT u.id FROM users u WHERE u.username = 'admin') a,
     (SELECT r.id FROM "role" r WHERE r.role_name = 'ADMIN') b;
INSERT INTO user_role (user_id, role_id)
SELECT *
FROM (SELECT u.id FROM users u WHERE u.username = 'admin') a,
     (SELECT r.id FROM "role" r WHERE r.role_name = 'PLAYER') b;
INSERT INTO user_role (user_id, role_id)
SELECT *
FROM (SELECT u.id FROM users u WHERE u.username = 'player1') a,
     (SELECT r.id FROM "role" r WHERE r.role_name = 'PLAYER') b;

INSERT INTO driver (driver_name, team)
VALUES ('SEBASTIAN VETTEL', 'ASTON_MARTIN');
INSERT INTO driver (driver_name, team)
VALUES ('LEWIS HAMILTON', 'MERCEDES');