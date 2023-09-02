package team.travelmate.file;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @author yeongwoonshin
 * @version v0.0
 * upload 된 파일은 server pc folder 내 저장하고
 * original file name [ user 가 upload 한 file 이름 ] 과
 * store file name [ server 에서 자동으로 만든 file 이름 ] 을 DB에 저장한다.
 * @see FileStore
 */
@Data
@Entity
@Table(name = "upload_file")
public class UploadFile {

    // 파일 고유 id, DB 에서 자동으로 할당, IDENTITY 전략을 취한다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fid;

    // user 가 upload 한 file 이름
    @Column(nullable = false)
    private String originalFileName;
    // server 가 만든 file 이름
    @Column(nullable = false)
    private String storeFileName;

    // 첨부 파일 여부 - true : 첨부 파일 , false ; 본문 삽입 img
    private boolean attach;

    public UploadFile(String originalFileName, String storeFileName) {
        this.originalFileName = originalFileName;
        this.storeFileName = storeFileName;
    }

    public UploadFile() {

    }

}
