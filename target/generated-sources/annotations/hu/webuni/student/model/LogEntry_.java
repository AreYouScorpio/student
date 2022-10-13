package hu.webuni.student.model;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LogEntry.class)
public abstract class LogEntry_ {

	public static volatile SingularAttribute<LogEntry, String> description;
	public static volatile SingularAttribute<LogEntry, Long> id;
	public static volatile SingularAttribute<LogEntry, LocalDateTime> ts;
	public static volatile SingularAttribute<LogEntry, String> username;

	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String TS = "ts";
	public static final String USERNAME = "username";

}

