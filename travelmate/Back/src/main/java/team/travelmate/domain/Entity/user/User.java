package team.travelmate.domain.Entity.user;

import lombok.Data;

import javax.persistence.*;

/**
 * @author yeongwoonshin
 * @version v0.0
 *
 * recruitment 작성자 입력 용 임시 User 객체
 * update 필요
 */
@Data
@Entity
@Table(name = "user")
public class User {

    // DB 에서 자동 할당 IDENTITY 전략을 취함
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 모집글에 작성될 작성자 이름
    @Column(name = "name", nullable = false)
    private String name;
}
