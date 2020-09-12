set foreign_key_checks = 0;

delete from user;

set foreign_key_checks = 1;

alter table user auto_increment = 1;

insert into user(id,name,username,password,role) values (1,"Talisson Melo","Talisson","123","ADMIN");
insert into user(id,name,username,password,role) values (2,"Tales Melo","Tales","123","USER");