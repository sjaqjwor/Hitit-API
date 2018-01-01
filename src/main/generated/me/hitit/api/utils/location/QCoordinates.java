package me.hitit.api.utils.location;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCoordinates is a Querydsl query type for Coordinates
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QCoordinates extends BeanPath<Coordinates> {

    private static final long serialVersionUID = 1589179673L;

    public static final QCoordinates coordinates = new QCoordinates("coordinates");

    public final NumberPath<Double> latitude = createNumber("latitude", Double.class);

    public final NumberPath<Double> longitude = createNumber("longitude", Double.class);

    public QCoordinates(String variable) {
        super(Coordinates.class, forVariable(variable));
    }

    public QCoordinates(Path<? extends Coordinates> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCoordinates(PathMetadata metadata) {
        super(Coordinates.class, metadata);
    }

}

