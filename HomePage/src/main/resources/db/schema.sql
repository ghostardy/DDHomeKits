CREATE TABLE IF NOT EXISTS MeterRecord
(
    recordId int PRIMARY KEY auto_increment,
    recordNumber double,
    meterType varchar (64),
    recorder varchar (64),
    recordDate timestamp
);
GRANT ALL ON MeterRecord TO sa;
