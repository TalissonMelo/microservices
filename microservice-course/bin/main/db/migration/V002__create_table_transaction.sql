CREATE TABLE transaction (
	id BIGINT NOT NULL AUTO_INCREMENT,
    course_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    date_of_issue DATETIME,
    
    CONSTRAINT pk_id PRIMARY KEY (id),
    CONSTRAINT fk_tran_course FOREIGN KEY (course_id) REFERENCES course(id) ON DELETE CASCADE ON UPDATE CASCADE
 
 )engine = InnoDB default charset=utf8;