insert into INSTRUCTION2(id, instructedtemperature, defaulttemperature, timelimit, cycleduration, test) values (1,  4, 10, CURRENT_TIMESTAMP        ,60, 1);
insert into PLANNING_INSTRUCTION(instructed_temperature, default_temperature, start_date, end_date, cycle_duration, priority) values (19, 15, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP+1.0/24 ,60, 5.5);
insert into PLANNING_INSTRUCTION(instructed_temperature, default_temperature, start_date, end_date, cycle_duration, priority) values (20, 15, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP+1/24   ,60, 10.0);

select 1 from DUAL;

