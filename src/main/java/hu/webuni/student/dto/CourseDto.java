package hu.webuni.student.dto;

import hu.webuni.student.model.Student;
import hu.webuni.student.model.Teacher;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CourseDto {


    private long id;

    //@Size(min = 3, max = 20)
    private String name;

    private Set<Student> students;

    private Set<Teacher> teachers;
}
