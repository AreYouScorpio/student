package hu.webuni.student.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFlight is a Querydsl query type for Flight
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFlight extends EntityPathBase<Flight> {

    private static final long serialVersionUID = -541285383L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFlight flight = new QFlight("flight");

    public final StringPath flightNumber = createString("flightNumber");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QAirport landing;

    public final QAirport takeoff;

    public final DateTimePath<java.time.LocalDateTime> takeoffTime = createDateTime("takeoffTime", java.time.LocalDateTime.class);

    public QFlight(String variable) {
        this(Flight.class, forVariable(variable), INITS);
    }

    public QFlight(Path<? extends Flight> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFlight(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFlight(PathMetadata metadata, PathInits inits) {
        this(Flight.class, metadata, inits);
    }

    public QFlight(Class<? extends Flight> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.landing = inits.isInitialized("landing") ? new QAirport(forProperty("landing")) : null;
        this.takeoff = inits.isInitialized("takeoff") ? new QAirport(forProperty("takeoff")) : null;
    }

}

