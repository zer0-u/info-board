DROP TABLE IF EXISTS images;
DROP TABLE IF EXISTS articles;
DROP TABLE IF EXISTS user_role;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS roles;

CREATE TABLE articles
(
    id      SERIAL PRIMARY KEY,
    author  VARCHAR(256),
    title   VARCHAR(256),
    content TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE images
(
    id     SERIAL PRIMARY KEY,
    article_id SERIAL REFERENCES articles (id) ON DELETE CASCADE,
    name   VARCHAR(256),
    header VARCHAR(128),
    base64 BYTEA
);

CREATE TABLE roles
(
    id   INTEGER PRIMARY KEY,
    name VARCHAR(256)
);

CREATE TABLE users
(
    id       SERIAL PRIMARY KEY,
    login_id VARCHAR(256),
    password VARCHAR(256),
    name     VARCHAR(256)
);

CREATE TABLE user_role
(
    user_id SERIAL REFERENCES users (id) ON DELETE CASCADE,
    role_id INTEGER REFERENCES roles (id)
);