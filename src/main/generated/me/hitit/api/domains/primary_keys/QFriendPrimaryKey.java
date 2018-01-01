package me.hitit.api.domains.primary_keys;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFriendPrimaryKey is a Querydsl query type for FriendPrimaryKey
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QFriendPrimaryKey extends BeanPath<FriendPrimaryKey> {

    private static final long serialVersionUID = -1033895937L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFriendPrimaryKey friendPrimaryKey = new QFriendPrimaryKey("friendPrimaryKey");

    public final me.hitit.api.domains.QUser friendUser;

    public final me.hitit.api.domains.QUser targetUser;

    public QFriendPrimaryKey(String variable) {
        this(FriendPrimaryKey.class, forVariable(variable), INITS);
    }

    public QFriendPrimaryKey(Path<? extends FriendPrimaryKey> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFriendPrimaryKey(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFriendPrimaryKey(PathMetadata metadata, PathInits inits) {
        this(FriendPrimaryKey.class, metadata, inits);
    }

    public QFriendPrimaryKey(Class<? extends FriendPrimaryKey> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.friendUser = inits.isInitialized("friendUser") ? new me.hitit.api.domains.QUser(forProperty("friendUser"), inits.get("friendUser")) : null;
        this.targetUser = inits.isInitialized("targetUser") ? new me.hitit.api.domains.QUser(forProperty("targetUser"), inits.get("targetUser")) : null;
    }

}

