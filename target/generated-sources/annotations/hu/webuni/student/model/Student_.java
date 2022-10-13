package hu.webuni.student.model;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Student.class)
public abstract class Student_ {

	public static volatile SingularAttribute<Student, LocalDate> birthdate;
	public static volatile SingularAttribute<Student, String> name;
	public static volatile SingularAttribute<Student, Integer> semester;
	public static volatile SingularAttribute<Student, Long> id;

	public static final String BIRTHDATE = "birthdate";
	public static final String NAME = "name";
	public static final String SEMESTER = "semester";
	public static final String ID = "id";

}

