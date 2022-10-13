package hu.webuni.student.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QAirport is a Querydsl query type for Airport
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAirport extends EntityPathBase<Airport> {

    private static final long serialVersionUID = 180170338L;

    public static final QAirport airport = new QAirport("airport");

    public final StringPath iata = createString("iata");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QAirport(String variable) {
        super(Airport.class, forVariable(variable));
    }

    public QAirport(Path<? extends Airport> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAirport(PathMetadata metadata) {
        super(Airport.class, metadata);
    }

}

