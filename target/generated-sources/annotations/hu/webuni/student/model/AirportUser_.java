package hu.webuni.student.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AirportUser.class)
public abstract class AirportUser_ {

	public static volatile SingularAttribute<AirportUser, String> password;
	public static volatile SetAttribute<AirportUser, String> roles;
	public static volatile SingularAttribute<AirportUser, String> username;

	public static final String PASSWORD = "password";
	public static final String ROLES = "roles";
	public static final String USERNAME = "username";

}

