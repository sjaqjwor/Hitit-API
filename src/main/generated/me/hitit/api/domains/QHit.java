package me.hitit.api.domains;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHit is a Querydsl query type for Hit
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHit extends EntityPathBase<Hit> {

    private static final long serialVersionUID = -570035814L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHit hit = new QHit("hit");

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final QTimeline timeline;

    public final DateTimePath<java.sql.Timestamp> ts = createDateTime("ts", java.sql.Timestamp.class);

    public final QUser user;

    public QHit(String variable) {
        this(Hit.class, forVariable(variable), INITS);
    }

    public QHit(Path<? extends Hit> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHit(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHit(PathMetadata metadata, PathInits inits) {
        this(Hit.class, metadata, inits);
    }

    public QHit(Class<? extends Hit> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.timeline = inits.isInitialized("timeline") ? new QTimeline(forProperty("timeline"), inits.get("timeline")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

