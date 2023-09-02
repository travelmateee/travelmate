package team.travelmate.domain.Entity.uploadfiles;

import team.travelmate.domain.Entity.UploadFilesId;
import team.travelmate.domain.Entity.recruitment.Recruitment;
import team.travelmate.file.UploadFile;

import javax.persistence.*;

/**
 * @author yeongwoonshin
 * @version v0.0
 * @see UploadFile
 * @see UploadFilesId
 * @see Recruitment
 *
 * Recruitement 내 uploadImgs N : M 해소 용
 */
@Entity
@IdClass(UploadFilesId.class)
public class UploadFiles {

    //uploadFileId : DB 에서 자동으로 생성
    @Id
    @GeneratedValue
    private Long uploadFileId;

    //모집글 ID
    @ManyToOne
    @JoinColumn(name = "rid")
    private Recruitment recruitment;

    //File Id
    @ManyToOne
    @JoinColumn(name = "fid")
    private UploadFile uploadFile;
}
