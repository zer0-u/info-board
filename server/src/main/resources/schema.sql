DROP TABLE IF EXISTS images;
DROP TABLE IF EXISTS articles;

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