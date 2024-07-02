DROP TABLE IF EXISTS articles;

CREATE TABLE articles
(
    id SERIAL PRIMARY KEY ,
    author VARCHAR(256),
    title VARCHAR(256),
    content TEXT,
    created_at TIMESTAMP
);