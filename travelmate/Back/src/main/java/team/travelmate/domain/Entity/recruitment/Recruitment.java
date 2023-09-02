package team.travelmate.domain.Entity.recruitment;

import lombok.Data;
import team.travelmate.domain.Entity.user.User;
import team.travelmate.file.UploadFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

/**
 * @author yeongwoonshin
 * @version v0.0
 * 모집글 Entity
 */

@Data
@Entity
@Table(name = "recruitment")
public class Recruitment {

    // PK : DB 자동 생성 IDENTITY 전략을 취한다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rid;

    // User Entity 와 N : 1 관계를 가진다.
    @ManyToOne
    @JoinColumn(name="UID")
    private User user;

    //모집 글 제목
    @NotNull
    @Column(name = "title" , nullable = false)
    private String title;

    //모집 글 본문
    @Column(nullable = false)
    private String body;

    //여행 출발일
    @Column(nullable = false)
    private Date startDate;

    //여행 종료일
    @Column(nullable = false)
    private Date dueDate;

    //모집글 작성일
    @Column(nullable = false)
    private Date writeDate;

    //여행 장소
    @Column(nullable = false)
    private String place;

    //예산
    @Column(nullable = false)
    private Long budge;

    // Upload File List : attach field 를 통해 첨부 파일 여부 확인
    // true : 첨부 파일 , false : 본문 삽입 img
    @OneToMany(mappedBy = "fid")
    private List<UploadFile> uploadImgs;

}
