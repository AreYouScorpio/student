package hu.webuni.student.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Airport.class)
public abstract class Airport_ {

	public static volatile SingularAttribute<Airport, String> iata;
	public static volatile SingularAttribute<Airport, String> name;
	public static volatile SingularAttribute<Airport, Long> id;

	public static final String IATA = "iata";
	public static final String NAME = "name";
	public static final String ID = "id";

}

