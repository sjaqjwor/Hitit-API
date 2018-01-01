package me.hitit.api.domains;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QChat is a Querydsl query type for Chat
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QChat extends EntityPathBase<Chat> {

    private static final long serialVersionUID = -491391439L;

    public static final QChat chat = new QChat("chat");

    public final CollectionPath<ChatMember, QChatMember> chatMembers = this.<ChatMember, QChatMember>createCollection("chatMembers", ChatMember.class, QChatMember.class, PathInits.DIRECT2);

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final StringPath title = createString("title");

    public final DateTimePath<java.sql.Timestamp> ts = createDateTime("ts", java.sql.Timestamp.class);

    public QChat(String variable) {
        super(Chat.class, forVariable(variable));
    }

    public QChat(Path<? extends Chat> path) {
        super(path.getType(), path.getMetadata());
    }

    public QChat(PathMetadata metadata) {
        super(Chat.class, metadata);
    }

}

