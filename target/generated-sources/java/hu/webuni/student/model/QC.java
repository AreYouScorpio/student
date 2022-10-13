package hu.webuni.student.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QC is a Querydsl query type for C
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QC extends EntityPathBase<C> {

    private static final long serialVersionUID = 115314490L;

    public static final QC c1 = new QC("c1");

    public final QA _super = new QA(this);

    //inherited
    public final NumberPath<Long> a1 = _super.a1;

    //inherited
    public final StringPath a2 = _super.a2;

    public final StringPath c = createString("c");

    public QC(String variable) {
        super(C.class, forVariable(variable));
    }

    public QC(Path<? extends C> path) {
        super(path.getType(), path.getMetadata());
    }

    public QC(PathMetadata metadata) {
        super(C.class, metadata);
    }

}

