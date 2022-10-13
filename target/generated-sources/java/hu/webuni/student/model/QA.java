package hu.webuni.student.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QA is a Querydsl query type for A
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QA extends EntityPathBase<A> {

    private static final long serialVersionUID = 115314488L;

    public static final QA a = new QA("a");

    public final NumberPath<Long> a1 = createNumber("a1", Long.class);

    public final StringPath a2 = createString("a2");

    public QA(String variable) {
        super(A.class, forVariable(variable));
    }

    public QA(Path<? extends A> path) {
        super(path.getType(), path.getMetadata());
    }

    public QA(PathMetadata metadata) {
        super(A.class, metadata);
    }

}

