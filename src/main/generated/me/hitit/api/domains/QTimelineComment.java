package me.hitit.api.domains;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTimelineComment is a Querydsl query type for TimelineComment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTimelineComment extends EntityPathBase<TimelineComment> {

    private static final long serialVersionUID = -604495259L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTimelineComment timelineComment = new QTimelineComment("timelineComment");

    public final StringPath contents = createString("contents");

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final QTimeline timeline;

    public final DateTimePath<java.sql.Timestamp> ts = createDateTime("ts", java.sql.Timestamp.class);

    public final QUser user;

    public QTimelineComment(String variable) {
        this(TimelineComment.class, forVariable(variable), INITS);
    }

    public QTimelineComment(Path<? extends TimelineComment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTimelineComment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTimelineComment(PathMetadata metadata, PathInits inits) {
        this(TimelineComment.class, metadata, inits);
    }

    public QTimelineComment(Class<? extends TimelineComment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.timeline = inits.isInitialized("timeline") ? new QTimeline(forProperty("timeline"), inits.get("timeline")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

