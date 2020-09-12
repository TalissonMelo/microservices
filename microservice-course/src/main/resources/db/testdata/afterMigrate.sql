set foreign_key_checks = 0;

delete from course;
delete from transaction;

set foreign_key_checks = 1;

alter table course auto_increment = 1;
alter table transaction auto_increment = 1;

 INSERT INTO course (id, title, author, category, publish_date) VALUES(1, 'Microservices', 'Instructor 1', 'Programming', NOW());
 INSERT INTO course (id, title, author, category, publish_date) VALUES(2, 'Java Programming', 'Instructor 2', 'Programming', NOW());
 INSERT INTO course (id, title, author, category, publish_date) VALUES(3, 'Web Development', 'Instructor 3', 'Web', NOW());
 INSERT INTO course (id, title, author, category, publish_date) VALUES(4, 'Mobile Application', 'Instructor 4', 'Mobile', NOW());
 INSERT INTO course (id, title, author, category, publish_date) VALUES(5, 'Amazon Web Services', 'Instructor 5', 'Administration', NOW());
 
  INSERT INTO transaction (id, course_id, user_id, date_of_issue) VALUES(1, 1, 1, NOW());