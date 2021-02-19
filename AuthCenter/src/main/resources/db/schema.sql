CREATE TABLE IF NOT EXISTS UserIdentity
(
    userId int PRIMARY KEY auto_increment,
    username varchar (64),
    password varchar (1024),
    status int,
    authority bigint,
    signUpDate timestamp
);
GRANT ALL ON UserIdentity TO sa;
