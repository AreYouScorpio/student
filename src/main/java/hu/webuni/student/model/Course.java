package hu.webuni.student.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Course {

    @Id
    @GeneratedValue // (strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include()
    private long id;

    //@Size(min = 3, max = 20)
    private String name;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Teacher teacher;

    public Course(String name, Student student, Teacher teacher) {
        this.name = name;
        this.student = student;
        this.teacher = teacher;
    }


    public Course(String name) {
        this.name = name;
    }
}
