INSERT INTO articles(author, title, content, created_at)
VALUES ('サンプル投稿者', '投稿サンプル', 'これは投稿のサンプルです。', '2024-05-01 09:30:50');
INSERT INTO articles(author, title, content, created_at)
VALUES ('サンプル投稿者2', '2つ目の投稿', 'サンプル文字列2', '2024-05-02 09:30:50');

INSERT INTO images(name, schema, image)
VALUES ('みかん', 'data:image/png;base64', pg_read_binary_file('images/food/mikan.png'));
INSERT INTO images(name, schema, image)
VALUES ('琥珀糖', 'data:image/jpg;base64', pg_read_binary_file('images/food/kohaku.jpg'));
INSERT INTO images(name, schema, image)
VALUES ('金平糖', 'data:image/jpg;base64', pg_read_binary_file('images/food/konpeito.jpg'));
INSERT INTO images(name, schema, image)
VALUES ('マカロン', 'data:image/jpg;base64', pg_read_binary_file('images/food/macaron.jpg'));
INSERT INTO images(name, schema, image)
VALUES ('たいやき', 'data:image/png;base64', pg_read_binary_file('images/food/taiyaki.png'));
INSERT INTO images(name, schema, image)
VALUES ('秋', 'data:image/jpg;base64', pg_read_binary_file('images/autumn.jpg'));
INSERT INTO images(name, schema, image)
VALUES ('タブレットとスマートフォン', 'data:image/jpg;base64', pg_read_binary_file('images/tablet_smartphone.jpg'));