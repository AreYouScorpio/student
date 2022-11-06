package hu.webuni.student.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.Set;

//@Getter
//@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Entity
public class Student {

    @Id
    @GeneratedValue // (strategy = GenerationType.AUTO)
    @ToString.Include
    @EqualsAndHashCode.Include()
    private long id;

    @ToString.Include
    //@Size(min = 3, max = 20)
    private String name;
    //@Size (min = 3, max = 10)
    private LocalDate birthdate;
    private int semester;

    @JsonIgnore
    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;



    public Student(String name, LocalDate birthdate, int semester) {
        this.name = name;
        this.birthdate = birthdate;
        this.semester = semester;
    }
}
