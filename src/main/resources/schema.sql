DROP TABLE IF EXISTS employee;

CREATE TABLE employee
(
    wwid  INTEGER PRIMARY KEY auto_increment,
    email     VARCHAR(128),
    firstname VARCHAR(128),
    lastname VARCHAR(256)
);