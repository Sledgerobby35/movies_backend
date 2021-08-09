CREATE DATABASE IF NOT EXISTS movie_db;

USE movie_db;

CREATE TABLE IF NOT EXISTS movies (
                                      id INT UNSIGNED NOT NULL AUTO_INCREMENT,
                                      title VARCHAR(100),
                                      poster VARCHAR(200),
                                      release_date DATE,
                                      genre VARCHAR(150),
                                      director VARCHAR(75),
                                      cast VARCHAR(255),
                                      plot VARCHAR(255),
                                      PRIMARY KEY (id)
);