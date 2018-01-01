package me.hitit.api.domains;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChatMember is a Querydsl query type for ChatMember
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QChatMember extends EntityPathBase<ChatMember> {

    private static final long serialVersionUID = 756958251L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QChatMember chatMember = new QChatMember("chatMember");

    public final QChat chat;

    public final me.hitit.api.domains.primary_keys.QChatMemberPrimaryKey chatMemberPk;

    public final DateTimePath<java.sql.Timestamp> ts = createDateTime("ts", java.sql.Timestamp.class);

    public QChatMember(String variable) {
        this(ChatMember.class, forVariable(variable), INITS);
    }

    public QChatMember(Path<? extends ChatMember> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QChatMember(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QChatMember(PathMetadata metadata, PathInits inits) {
        this(ChatMember.class, metadata, inits);
    }

    public QChatMember(Class<? extends ChatMember> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.chat = inits.isInitialized("chat") ? new QChat(forProperty("chat")) : null;
        this.chatMemberPk = inits.isInitialized("chatMemberPk") ? new me.hitit.api.domains.primary_keys.QChatMemberPrimaryKey(forProperty("chatMemberPk"), inits.get("chatMemberPk")) : null;
    }

}

