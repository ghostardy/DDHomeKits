CREATE TABLE IF NOT EXISTS Identification
(
    userId int PRIMARY KEY auto_increment,
    username varchar (50),
    password varchar (1024),
    status int,
    authority bigint,
    signUpDate timestamp
);
GRANT ALL ON Identification TO sa;
