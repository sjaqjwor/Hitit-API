package me.hitit.api.domains;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTimelineMusic is a Querydsl query type for TimelineMusic
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTimelineMusic extends EntityPathBase<TimelineMusic> {

    private static final long serialVersionUID = -898470997L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTimelineMusic timelineMusic = new QTimelineMusic("timelineMusic");

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final StringPath objectKey = createString("objectKey");

    public final QTimeline timeline;

    public final DateTimePath<java.sql.Timestamp> ts = createDateTime("ts", java.sql.Timestamp.class);

    public QTimelineMusic(String variable) {
        this(TimelineMusic.class, forVariable(variable), INITS);
    }

    public QTimelineMusic(Path<? extends TimelineMusic> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTimelineMusic(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTimelineMusic(PathMetadata metadata, PathInits inits) {
        this(TimelineMusic.class, metadata, inits);
    }

    public QTimelineMusic(Class<? extends TimelineMusic> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.timeline = inits.isInitialized("timeline") ? new QTimeline(forProperty("timeline"), inits.get("timeline")) : null;
    }

}

