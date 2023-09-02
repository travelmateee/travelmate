package team.travelmate.domain.repository;

import team.travelmate.common.SearchCondition;
import team.travelmate.domain.Entity.recruitment.Recruitment;

import java.util.List;
import java.util.Optional;

/**
 * @author yeongwoonshin
 * @version v0.0
 * Service -> RecruitmentRepository Dependency
 */
public interface RecruitmentRepository {

    /**
     * Recruitment 객체를 받아와 DB에 저장
     * DataSpringJpa 사용
     * @param recruitment
     * @return DB auto_increment 값 포함하여 반환
     */
    Recruitment save(Recruitment recruitment);

    /**
     * 전체 Field 를 대상 update 한다.
     * null 을 파악하기에는 Logic 이 길어져 전체 field 대상으로 진행
     * @param Rid Recruitment id
     * @param updateParam 수정 parameter : update 되지 않은 field 는 이전 Data를 사용
     */
    void update(Long Rid, Recruitment updateParam);

    /**
     * Recruitment 삭제
     * @param Rid Recruitment id
     */
    void delete(Long Rid);

    /**
     * Recruitment ID 를 이용한 Recruitment 객체 반환
     * @param Rid Recruitment ID
     * @return Recruitment 객체 반환 : Optional 사용
     */
    Optional<Recruitment> findByRid(Long Rid);

    /**
     * Recruitment List 받아오기 Search Condition 에 따라 다르게 적용
     * Querydsl을 이용하여 동적 SQL 적용
     * @param condition 검색 조건
     * @see SearchCondition
     * @return Recruitment List 반환
     */
    List<Recruitment> findAll(SearchCondition condition);

}
