package team.travelmate.domain.Entity.uploadfiles;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUploadFiles is a Querydsl query type for UploadFiles
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUploadFiles extends EntityPathBase<UploadFiles> {

    private static final long serialVersionUID = -3097761L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUploadFiles uploadFiles = new QUploadFiles("uploadFiles");

    public final team.travelmate.domain.Entity.recruitment.QRecruitment recruitment;

    public final team.travelmate.file.QUploadFile uploadFile;

    public final NumberPath<Long> uploadFileId = createNumber("uploadFileId", Long.class);

    public QUploadFiles(String variable) {
        this(UploadFiles.class, forVariable(variable), INITS);
    }

    public QUploadFiles(Path<? extends UploadFiles> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUploadFiles(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUploadFiles(PathMetadata metadata, PathInits inits) {
        this(UploadFiles.class, metadata, inits);
    }

    public QUploadFiles(Class<? extends UploadFiles> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.recruitment = inits.isInitialized("recruitment") ? new team.travelmate.domain.Entity.recruitment.QRecruitment(forProperty("recruitment"), inits.get("recruitment")) : null;
        this.uploadFile = inits.isInitialized("uploadFile") ? new team.travelmate.file.QUploadFile(forProperty("uploadFile")) : null;
    }

}

