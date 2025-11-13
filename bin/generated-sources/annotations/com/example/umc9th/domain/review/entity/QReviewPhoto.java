package com.example.umc9th.domain.review.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.dsl.StringTemplate;

import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.annotations.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReviewPhoto is a Querydsl query type for ReviewPhoto
 */
@SuppressWarnings("this-escape")
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReviewPhoto extends EntityPathBase<ReviewPhoto> {

    private static final long serialVersionUID = -27529354L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReviewPhoto reviewPhoto = new QReviewPhoto("reviewPhoto");

    public final com.example.umc9th.global.entity.QBaseEntity _super = new com.example.umc9th.global.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> deletedAt = _super.deletedAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QReview review;

    public final StringPath reviewUrl = createString("reviewUrl");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QReviewPhoto(String variable) {
        this(ReviewPhoto.class, forVariable(variable), INITS);
    }

    public QReviewPhoto(Path<? extends ReviewPhoto> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReviewPhoto(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReviewPhoto(PathMetadata metadata, PathInits inits) {
        this(ReviewPhoto.class, metadata, inits);
    }

    public QReviewPhoto(Class<? extends ReviewPhoto> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.review = inits.isInitialized("review") ? new QReview(forProperty("review"), inits.get("review")) : null;
    }

}

