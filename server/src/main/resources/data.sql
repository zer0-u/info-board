INSERT INTO articles(author, title, content, created_at)
VALUES ('投稿者1', 'サンプル1', '本文1', '2024-05-01 09:30:50');
INSERT INTO articles(author, title, content, created_at)
VALUES ('投稿者2', 'サンプル2', '本文2', '2024-05-02 10:00:50');
INSERT INTO articles(author, title, content, created_at)
VALUES ('投稿者3', 'サンプル3', '本文3', '2024-05-03 15:45:50');

INSERT INTO images(article_id, name, header, base64)
VALUES (1, 'みかん', 'data:image/png;base64', pg_read_binary_file('images/food/mikan.png'));
INSERT INTO images(article_id, name, header, base64)
VALUES (1, '琥珀糖', 'data:image/jpeg;base64', pg_read_binary_file('images/food/kohaku.jpg'));
INSERT INTO images(article_id, name, header, base64)
VALUES (2, 'たいやき', 'data:image/png;base64', pg_read_binary_file('images/food/taiyaki.png'));
