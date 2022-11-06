create table course (id int8 not null, name varchar(255), primary key (id))
create table course_students (courses_id int8 not null, students_id int8 not null, primary key (courses_id, students_id))
create table course_teachers (course_id int8 not null, teachers_id int8 not null, primary key (course_id, teachers_id))
alter table if exists course_students add constraint FK_students_id foreign key (students_id) references student;
alter table if exists course_students add constraint FK_courses_id foreign key (courses_id) references course;
alter table if exists course_teachers add constraint FK_teachers_id foreign key (teachers_id) references teacher;
alter table if exists course_teachers add constraint FK_course_id foreign key (course_id) references course;