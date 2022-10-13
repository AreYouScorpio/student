package hu.webuni.student.model;

import java.time.LocalDateTime;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Flight.class)
public abstract class Flight_ {

	public static volatile SingularAttribute<Flight, Airport> landing;
	public static volatile SingularAttribute<Flight, Airport> takeoff;
	public static volatile SingularAttribute<Flight, LocalDateTime> takeoffTime;
	public static volatile SingularAttribute<Flight, Long> id;
	public static volatile SingularAttribute<Flight, String> flightNumber;

	public static final String LANDING = "landing";
	public static final String TAKEOFF = "takeoff";
	public static final String TAKEOFF_TIME = "takeoffTime";
	public static final String ID = "id";
	public static final String FLIGHT_NUMBER = "flightNumber";

}

