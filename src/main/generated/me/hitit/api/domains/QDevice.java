package me.hitit.api.domains;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDevice is a Querydsl query type for Device
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDevice extends EntityPathBase<Device> {

    private static final long serialVersionUID = 245706479L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDevice device = new QDevice("device");

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final StringPath token = createString("token");

    public final DateTimePath<java.sql.Timestamp> ts = createDateTime("ts", java.sql.Timestamp.class);

    public final EnumPath<Device.Type> type = createEnum("type", Device.Type.class);

    public final QUser user;

    public final StringPath uuid = createString("uuid");

    public QDevice(String variable) {
        this(Device.class, forVariable(variable), INITS);
    }

    public QDevice(Path<? extends Device> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDevice(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDevice(PathMetadata metadata, PathInits inits) {
        this(Device.class, metadata, inits);
    }

    public QDevice(Class<? extends Device> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

