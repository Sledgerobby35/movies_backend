CREATE DATABASE IF NOT EXISTS movies_db;
USE movies_db;

DROP TABLE IF EXISTS movies;
CREATE TABLE movies
(
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    title VARCHAR(100),
    poster VARCHAR(200),
    release_date DATE,
    genre VARCHAR(150),
    director VARCHAR(75),
    rating INT NOT NULL,
    cast VARCHAR(255),
    plot VARCHAR(255),
    PRIMARY KEY(id)
);
DESCRIBE movies;