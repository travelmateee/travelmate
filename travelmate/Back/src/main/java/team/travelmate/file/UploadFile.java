package team.travelmate.file;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "upload_file")
public class UploadFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fid;

    @Column(nullable = false)
    private String originalFileName;
    @Column(nullable = false)
    private String storeFileName;

    private boolean attach;

    public UploadFile(String originalFileName, String storeFileName) {
        this.originalFileName = originalFileName;
        this.storeFileName = storeFileName;
    }

    public UploadFile() {

    }
}
