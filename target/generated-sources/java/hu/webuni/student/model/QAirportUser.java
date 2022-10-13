package hu.webuni.student.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAirportUser is a Querydsl query type for AirportUser
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAirportUser extends EntityPathBase<AirportUser> {

    private static final long serialVersionUID = -234648243L;

    public static final QAirportUser airportUser = new QAirportUser("airportUser");

    public final StringPath password = createString("password");

    public final SetPath<String, StringPath> roles = this.<String, StringPath>createSet("roles", String.class, StringPath.class, PathInits.DIRECT2);

    public final StringPath username = createString("username");

    public QAirportUser(String variable) {
        super(AirportUser.class, forVariable(variable));
    }

    public QAirportUser(Path<? extends AirportUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAirportUser(PathMetadata metadata) {
        super(AirportUser.class, metadata);
    }

}

