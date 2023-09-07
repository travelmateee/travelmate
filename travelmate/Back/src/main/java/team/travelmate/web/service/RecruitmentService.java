package team.travelmate.web.service;

import org.springframework.data.domain.Pageable;
import team.travelmate.common.SearchCondition;
import team.travelmate.domain.Entity.recruitment.Recruitment;
import team.travelmate.domain.Entity.user.User;
import team.travelmate.web.form.RecruitmentAddForm;
import team.travelmate.web.returnjson.DeleteResult;

import java.util.List;
import java.util.Optional;


/**
 * @author yeongwoonshin
 * @version v0.0
 */
public interface RecruitmentService {

    /**
     * 모집글 저장하기
     * @param recruitment recruitment
     * @return 저장된 recruitment
     */
    Recruitment saveRecruitment(RecruitmentAddForm recruitment, Long userId);

    /**
     * 모집글 수정하기
     * @param Rid : Rid 로 수정 대상 모집글 찾기
     * @param updateParam : update 할 parameter
     * @return 수정 완료 후 DB 에 적용 된 모집글
     */
    Recruitment updateRecruitment(Long Rid, Recruitment updateParam);

    /**
     * 모집글 삭제하기
     * @param Rid : Rid 로 삭제 대상 모집글 찾기
     */
    DeleteResult deleteRecruitment(Long Rid);

    /**
     * Rid 를 이용하여 모집글 찾기 : 단일 모집글 조회
     * @param Rid
     * @return DB에서 모집글 조회 후 반환
     */
    Optional<Recruitment> findByRid(Long Rid);

    /**
     * 다중 모집글 조회
     * @param con 검색 조건 객체
     * @see SearchCondition
     * @param page page
     * @param size pageOfSize
     * @return 검색조건, pagination 에 적합한 모집글s 반환
     */
    List<Recruitment> findRecruitments(SearchCondition con, Integer page, Integer size);


    boolean targetCheck(Long Rid);

}
