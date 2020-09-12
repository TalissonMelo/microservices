CREATE TABLE course (
	id BIGINT NOT NULL AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    category VARCHAR(255),
    publish_date DATE,
    
    CONSTRAINT  PRIMARY KEY (id)
 )engine = InnoDB default charset=utf8;