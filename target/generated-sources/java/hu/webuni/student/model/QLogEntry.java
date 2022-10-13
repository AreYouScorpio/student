package hu.webuni.student.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QLogEntry is a Querydsl query type for LogEntry
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QLogEntry extends EntityPathBase<LogEntry> {

    private static final long serialVersionUID = -338214697L;

    public static final QLogEntry logEntry = new QLogEntry("logEntry");

    public final StringPath description = createString("description");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> ts = createDateTime("ts", java.time.LocalDateTime.class);

    public final StringPath username = createString("username");

    public QLogEntry(String variable) {
        super(LogEntry.class, forVariable(variable));
    }

    public QLogEntry(Path<? extends LogEntry> path) {
        super(path.getType(), path.getMetadata());
    }

    public QLogEntry(PathMetadata metadata) {
        super(LogEntry.class, metadata);
    }

}

