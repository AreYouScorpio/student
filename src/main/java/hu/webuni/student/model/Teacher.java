package hu.webuni.student.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Teacher {

    @Id
    @GeneratedValue // (strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include()
    private long id;

    //@Size(min = 3, max = 20)
    private String name;
    //@Size (min = 3, max = 10)
    private LocalDate birthdate;

    public Teacher(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }
}
