--drop table INSTRUCTION if exists;
drop table INSTRUCTION2 if exists;
--create table INSTRUCTION2 (id INT primary key, instructedTemperature float DEFAULT 10.0, defaultTemperature float DEFAULT 10.0, timeLimit timestamp DEFAULT sysdate, cycleDuration int DEFAULT 60, test int default 5);