package me.hitit.api.domains.primary_keys;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChatMemberPrimaryKey is a Querydsl query type for ChatMemberPrimaryKey
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QChatMemberPrimaryKey extends BeanPath<ChatMemberPrimaryKey> {

    private static final long serialVersionUID = 1853512307L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QChatMemberPrimaryKey chatMemberPrimaryKey = new QChatMemberPrimaryKey("chatMemberPrimaryKey");

    public final me.hitit.api.domains.QChat chat;

    public final me.hitit.api.domains.QUser user;

    public QChatMemberPrimaryKey(String variable) {
        this(ChatMemberPrimaryKey.class, forVariable(variable), INITS);
    }

    public QChatMemberPrimaryKey(Path<? extends ChatMemberPrimaryKey> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QChatMemberPrimaryKey(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QChatMemberPrimaryKey(PathMetadata metadata, PathInits inits) {
        this(ChatMemberPrimaryKey.class, metadata, inits);
    }

    public QChatMemberPrimaryKey(Class<? extends ChatMemberPrimaryKey> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.chat = inits.isInitialized("chat") ? new me.hitit.api.domains.QChat(forProperty("chat")) : null;
        this.user = inits.isInitialized("user") ? new me.hitit.api.domains.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

