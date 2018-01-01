package me.hitit.api.domains;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLocation is a Querydsl query type for Location
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLocation extends EntityPathBase<Location> {

    private static final long serialVersionUID = 692579854L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLocation location = new QLocation("location");

    public final me.hitit.api.utils.location.QCoordinates coordinates;

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final DateTimePath<java.sql.Timestamp> ts = createDateTime("ts", java.sql.Timestamp.class);

    public final QUser user;

    public QLocation(String variable) {
        this(Location.class, forVariable(variable), INITS);
    }

    public QLocation(Path<? extends Location> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLocation(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLocation(PathMetadata metadata, PathInits inits) {
        this(Location.class, metadata, inits);
    }

    public QLocation(Class<? extends Location> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.coordinates = inits.isInitialized("coordinates") ? new me.hitit.api.utils.location.QCoordinates(forProperty("coordinates")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

