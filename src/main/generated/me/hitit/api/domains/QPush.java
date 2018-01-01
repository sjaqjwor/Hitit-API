package me.hitit.api.domains;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPush is a Querydsl query type for Push
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPush extends EntityPathBase<Push> {

    private static final long serialVersionUID = -490991117L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPush push = new QPush("push");

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final BooleanPath isRead = createBoolean("isRead");

    public final StringPath payload = createString("payload");

    public final EnumPath<Push.Status> status = createEnum("status", Push.Status.class);

    public final DateTimePath<java.sql.Timestamp> ts = createDateTime("ts", java.sql.Timestamp.class);

    public final EnumPath<Push.Type> type = createEnum("type", Push.Type.class);

    public final QUser user;

    public QPush(String variable) {
        this(Push.class, forVariable(variable), INITS);
    }

    public QPush(Path<? extends Push> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPush(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPush(PathMetadata metadata, PathInits inits) {
        this(Push.class, metadata, inits);
    }

    public QPush(Class<? extends Push> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

