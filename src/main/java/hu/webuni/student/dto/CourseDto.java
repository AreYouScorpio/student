package hu.webuni.student.dto;

import hu.webuni.student.model.Student;
import hu.webuni.student.model.Teacher;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CourseDto {


    private long id;

    //@Size(min = 3, max = 20)
    private String name;

    private Student student;


    private Teacher teacher;
}
