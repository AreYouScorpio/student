create table course (id int8 not null, name varchar(255), primary key (id))
create table course_students (courses_id int8 not null, students_id int8 not null, primary key (courses_id, students_id))
create table course_teachers (course_id int8 not null, teachers_id int8 not null, primary key (course_id, teachers_id))