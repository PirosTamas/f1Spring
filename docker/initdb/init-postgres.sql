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
    id         SERIAL PRIMARY KEY,
    username   VARCHAR(100) NOT NULL UNIQUE,
    password   VARCHAR(100) NOT NULL,
    daily_vote BOOLEAN
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
    team            VARCHAR(100) NOT NULL,
    votes           NUMERIC
);

INSERT INTO users (username, password, daily_vote)
VALUES ('admin', '$2a$12$AlrROU6TkYmEMaqCMuUX1OXvbBU1DC0Ft9aTyrEOSncX7wdODjmDW', false);
INSERT INTO users (username, password, daily_vote)
VALUES ('player1', '$2a$12$AlrROU6TkYmEMaqCMuUX1OXvbBU1DC0Ft9aTyrEOSncX7wdODjmDW', true);
INSERT INTO users (username, password, daily_vote)
VALUES ('player2', '$2a$12$AlrROU6TkYmEMaqCMuUX1OXvbBU1DC0Ft9aTyrEOSncX7wdODjmDW', true);
INSERT INTO users (username, password, daily_vote)
VALUES ('player3', '$2a$12$AlrROU6TkYmEMaqCMuUX1OXvbBU1DC0Ft9aTyrEOSncX7wdODjmDW', true);

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

INSERT INTO driver (driver_name, team, votes)
VALUES ('SEBASTIAN VETTEL', 'ASTON_MARTIN', 5);
INSERT INTO driver (driver_name, team, votes)
VALUES ('LEWIS HAMILTON', 'MERCEDES', 3);
INSERT INTO driver (driver_name, team, votes)
VALUES ('Lando Norris', 'MCLAREN', 3);
INSERT INTO driver (driver_name, team, votes)
VALUES ('Max Verstappen', 'RED_BULL', 0);
