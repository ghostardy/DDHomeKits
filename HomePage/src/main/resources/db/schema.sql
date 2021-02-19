CREATE TABLE IF NOT EXISTS MeterRecord
(
    recordId int PRIMARY KEY auto_increment,
    recordNumber double,
    meterType varchar (64),
    recorder varchar (64),
    recordDate timestamp
);
GRANT ALL ON MeterRecord TO sa;

CREATE TABLE IF NOT EXISTS MessageBoard
(
    msgId int PRIMARY KEY auto_increment,
    title varchar (128),
    content varchar (256),
    author varchar (64),
    pubDate timestamp default current_timestamp
);
GRANT ALL ON MessageBoard TO sa;