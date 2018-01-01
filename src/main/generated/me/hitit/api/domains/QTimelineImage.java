package me.hitit.api.domains;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTimelineImage is a Querydsl query type for TimelineImage
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTimelineImage extends EntityPathBase<TimelineImage> {

    private static final long serialVersionUID = -902420767L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTimelineImage timelineImage = new QTimelineImage("timelineImage");

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final StringPath objectKey = createString("objectKey");

    public final QTimeline timeline;

    public final DateTimePath<java.sql.Timestamp> ts = createDateTime("ts", java.sql.Timestamp.class);

    public QTimelineImage(String variable) {
        this(TimelineImage.class, forVariable(variable), INITS);
    }

    public QTimelineImage(Path<? extends TimelineImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTimelineImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTimelineImage(PathMetadata metadata, PathInits inits) {
        this(TimelineImage.class, metadata, inits);
    }

    public QTimelineImage(Class<? extends TimelineImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.timeline = inits.isInitialized("timeline") ? new QTimeline(forProperty("timeline"), inits.get("timeline")) : null;
    }

}

