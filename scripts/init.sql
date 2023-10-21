CREATE TABLE product (
    id SERIAL PRIMARY KEY,
    name varchar(20) NOT NULL UNIQUE,
    type varchar(10) NOT NULL,
    calories smallint NOT NULL
);

insert into product(id, name, type, calories) VALUES
(1, 'water', 'beverage', 0),
(2, 'carpaccio', 'entry', 50),
(3, 'stake', 'main', 500),
(4, 'fish', 'main', 200);