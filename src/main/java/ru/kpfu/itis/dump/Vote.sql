CREATE TABLE users
(
    id            BIGSERIAL PRIMARY KEY,
    first_name    VARCHAR(30),
    last_name     VARCHAR(30),
    email         VARCHAR(30),
    hash_password VARCHAR(100),
    deputies_id   VARCHAR
);


CREATE TABLE deputies
(
    id         BIGSERIAL PRIMARY KEY,
    first_name VARCHAR(30),
    last_name  VARCHAR(30),
    age        INTEGER,
    photo      VARCHAR(500),
    vote       REAL,
    fraction   VARCHAR(50),
    title      VARCHAR (500)
);



