package me.hitit.api.domains;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTimeline is a Querydsl query type for Timeline
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTimeline extends EntityPathBase<Timeline> {

    private static final long serialVersionUID = 1009853082L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTimeline timeline = new QTimeline("timeline");

    public final StringPath contents = createString("contents");

    public final me.hitit.api.utils.location.QCoordinates coordinates;

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final NumberPath<Short> openRange = createNumber("openRange", Short.class);

    public final CollectionPath<Tag, QTag> tags = this.<Tag, QTag>createCollection("tags", Tag.class, QTag.class, PathInits.DIRECT2);

    public final CollectionPath<TimelineComment, QTimelineComment> timelineComments = this.<TimelineComment, QTimelineComment>createCollection("timelineComments", TimelineComment.class, QTimelineComment.class, PathInits.DIRECT2);

    public final CollectionPath<TimelineImage, QTimelineImage> timelineImages = this.<TimelineImage, QTimelineImage>createCollection("timelineImages", TimelineImage.class, QTimelineImage.class, PathInits.DIRECT2);

    public final QTimelineMusic timelineMusics;

    public final DateTimePath<java.sql.Timestamp> ts = createDateTime("ts", java.sql.Timestamp.class);

    public final QUser user;

    public QTimeline(String variable) {
        this(Timeline.class, forVariable(variable), INITS);
    }

    public QTimeline(Path<? extends Timeline> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTimeline(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTimeline(PathMetadata metadata, PathInits inits) {
        this(Timeline.class, metadata, inits);
    }

    public QTimeline(Class<? extends Timeline> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.coordinates = inits.isInitialized("coordinates") ? new me.hitit.api.utils.location.QCoordinates(forProperty("coordinates")) : null;
        this.timelineMusics = inits.isInitialized("timelineMusics") ? new QTimelineMusic(forProperty("timelineMusics"), inits.get("timelineMusics")) : null;
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user"), inits.get("user")) : null;
    }

}

