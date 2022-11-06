package hu.webuni.student.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Entity
@NamedEntityGraph(
        name = "Course.students",
        attributeNodes = @NamedAttributeNode("students"))
@NamedEntityGraph(
        name = "Course.teachers",
        attributeNodes = @NamedAttributeNode("teachers"))
public class Course {

    @Id
    @GeneratedValue // (strategy = GenerationType.AUTO)
    @ToString.Include
    @EqualsAndHashCode.Include
    private long id;

    //@Size(min = 3, max = 20)
    @ToString.Include
    private String name;

    @JsonIgnore
    @ManyToMany
    private Set<Student> students;

    @JsonIgnore
    @ManyToMany
    private Set<Teacher> teachers;

//    public Course(String name, Student student, Teacher teacher) {
//        this.name = name;
//        this.student = student;
//        this.teacher = teacher;
//    }


    public Course(String name, Set<Student> students, Set<Teacher> teachers) {
        this.name = name;
        this.students = students;
        this.teachers = teachers;
    }

    public Course(String name) {
        this.name = name;
    }

}
