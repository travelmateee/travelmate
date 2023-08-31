package team.travelmate.domain.Entity.recruitment;

import lombok.Data;
import team.travelmate.domain.Entity.user.User;
import team.travelmate.file.UploadFile;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "recruitment")
public class Recruitment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rid;

    @ManyToOne
    @JoinColumn(name="UID")
    private User user;

    @NotNull
    @Column(name = "title" , nullable = false)
    private String title;

    @Column(nullable = false)
    private String body;

    @Column(nullable = false)
    private Date startDate;

    @Column(nullable = false)
    private Date dueDate;

    @Column(nullable = false)
    private Date writeDate;

    @Column(nullable = false)
    private String place;

    @Column(nullable = false)
    private Long budge;

    @OneToMany(mappedBy = "fid")
    private List<UploadFile> uploadImgs;

}
