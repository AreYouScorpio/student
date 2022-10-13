package hu.webuni.student.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QB is a Querydsl query type for B
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QB extends EntityPathBase<B> {

    private static final long serialVersionUID = 115314489L;

    public static final QB b1 = new QB("b1");

    public final QA _super = new QA(this);

    //inherited
    public final NumberPath<Long> a1 = _super.a1;

    //inherited
    public final StringPath a2 = _super.a2;

    public final StringPath b = createString("b");

    public QB(String variable) {
        super(B.class, forVariable(variable));
    }

    public QB(Path<? extends B> path) {
        super(path.getType(), path.getMetadata());
    }

    public QB(PathMetadata metadata) {
        super(B.class, metadata);
    }

}

