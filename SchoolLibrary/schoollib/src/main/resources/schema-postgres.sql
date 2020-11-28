DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS books;
CREATE TABLE users(id serial PRIMARY KEY, firstname VARCHAR(255), lastname VARCHAR(255), email VARCHAR(255), password VARCHAR(255));
CREATE TABLE books(id serial PRIMARY KEY, name VARCHAR(255), writer VARCHAR(255));
