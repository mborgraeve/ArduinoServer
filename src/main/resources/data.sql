--insert into INSTRUCTION2(id, instructedtemperature, defaulttemperature, timelimit, cycleduration, test) values (1,  4, 10, CURRENT_TIMESTAMP        ,60, 1);
insert into INSTRUCTION(instructedtemperature, defaulttemperature, timelimit, cycleduration) values (19, 15, CURRENT_TIMESTAMP+1.0/24 ,60);
insert into INSTRUCTION(instructedtemperature, defaulttemperature, timelimit, cycleduration) values (20, 15, CURRENT_TIMESTAMP+1/24   ,60);

--select 1 from DUAL;