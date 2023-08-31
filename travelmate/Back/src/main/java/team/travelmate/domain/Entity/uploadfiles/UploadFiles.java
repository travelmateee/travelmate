package team.travelmate.domain.Entity.uploadfiles;

import team.travelmate.domain.Entity.UploadFilesId;
import team.travelmate.domain.Entity.recruitment.Recruitment;
import team.travelmate.file.UploadFile;

import javax.persistence.*;

@Entity
@IdClass(UploadFilesId.class)
public class UploadFiles {

    @Id
    @GeneratedValue
    private Long uploadFileId;

    @ManyToOne
    @JoinColumn(name = "rid")
    private Recruitment recruitment;


    @ManyToOne
    @JoinColumn(name = "fid")
    private UploadFile uploadFile;
}
