package team.travelmate.domain.repository.recruitment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import team.travelmate.common.SearchCondition;
import team.travelmate.domain.Entity.recruitment.Recruitment;
import team.travelmate.domain.repository.JPARecruitmentRepository;
import team.travelmate.domain.repository.RecruitmentRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class RecruitmentRepositoryImple implements RecruitmentRepository {

    private final JPARecruitmentRepository jpaRepository;
    private final RecruitmentQueryRepository queryRepository;

    @Override
    public Recruitment save(Recruitment recruitment) {
        return jpaRepository.save(recruitment);
    }

    @Override
    public void update(Long Rid, Recruitment updateParam) {
        Recruitment recruitment = jpaRepository.findById(Rid).orElseThrow();
        log.info("original title ={}",recruitment.getTitle());
        updateParamToRecruitment(updateParam,recruitment);
        jpaRepository.save(recruitment);
    }

    @Override
    public void delete(Long Rid) {
        jpaRepository.deleteById(Rid);
    }

    @Override
    public Optional<Recruitment> findByRid(Long Rid) {
        return jpaRepository.findById(Rid);
    }

    @Override
    public List<Recruitment> findAll(SearchCondition condition,Pageable pageable) {
        return queryRepository.findAll(condition,pageable);
    }

    private static void updateParamToRecruitment(Recruitment updateParam, Recruitment recruitment) {
        recruitment.setTitle(updateParam.getTitle());
        log.info("title ={} ", updateParam.getTitle());
        recruitment.setBody(updateParam.getBody());
        recruitment.setPlace(updateParam.getPlace());
        recruitment.setStartDate(updateParam.getStartDate());
        recruitment.setDueDate(updateParam.getDueDate());
        recruitment.setBudge(updateParam.getBudge());
        recruitment.setUser(updateParam.getUser());
        recruitment.setUploadImgs(updateParam.getUploadImgs());
        recruitment.setWriteDate(updateParam.getWriteDate());
    }

}
