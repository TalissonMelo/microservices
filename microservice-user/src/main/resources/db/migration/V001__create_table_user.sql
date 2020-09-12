 CREATE TABLE user (
       id BIGINT NOT NULL AUTO_INCREMENT,
       username VARCHAR(255) NOT NULL,
       password VARCHAR(255) NOT NULL,
       name VARCHAR(255) NOT NULL,
       role VARCHAR(10) NOT NULL,

       CONSTRAINT PRIMARY KEY (id)
 )engine = InnoDB default charset=utf8;