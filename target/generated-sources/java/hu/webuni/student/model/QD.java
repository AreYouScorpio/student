package hu.webuni.student.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QD is a Querydsl query type for D
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QD extends EntityPathBase<D> {

    private static final long serialVersionUID = 115314491L;

    public static final QD d1 = new QD("d1");

    public final QC _super = new QC(this);

    //inherited
    public final NumberPath<Long> a1 = _super.a1;

    //inherited
    public final StringPath a2 = _super.a2;

    //inherited
    public final StringPath c = _super.c;

    public final StringPath d = createString("d");

    public QD(String variable) {
        super(D.class, forVariable(variable));
    }

    public QD(Path<? extends D> path) {
        super(path.getType(), path.getMetadata());
    }

    public QD(PathMetadata metadata) {
        super(D.class, metadata);
    }

}

