CREATE TABLE IF NOT EXISTS UserInfo
(
    userId int PRIMARY KEY auto_increment,
    username varchar (50),
    password varchar (1024),
    nickName varchar (50),
    status int,
    authority bigint,
    extraInfo varchar (1024),
    signUpDate timestamp
);
GRANT ALL ON UserInfo TO sa;
