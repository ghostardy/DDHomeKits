CREATE TABLE IF NOT EXISTS ORDER_DETAIL
(
order_id int PRIMARY KEY auto_increment,
order_user varchar(12),
order_at bigint,
order_status int,
order_extra varchar(100),
order_date timestamp
);
GRANT ALL ON ORDER_DETAIL TO sa;