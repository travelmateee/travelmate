package team.travelmate.web.service.recruitment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import team.travelmate.common.SearchCondition;
import team.travelmate.domain.Entity.recruitment.Recruitment;
import team.travelmate.domain.repository.RecruitmentRepository;
import team.travelmate.web.service.RecruitmentService;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RecruitmentsServiceImple implements RecruitmentService {

    private final RecruitmentRepository RecruitmentRepository;

    @Override
    public Recruitment saveRecruitment(Recruitment recruitment) {
        return null;
    }

    @Override
    public Recruitment updateRecruitment(Long Rid, Recruitment updateParam) {
        return null;
    }

    @Override
    public void deleteRecruitment(Long Rid) {

    }

    @Override
    public Recruitment findByRid(Long Rid) {
        return null;
    }


    /**
     *
     * @param con 검색 조건 객체
     * @param pageable pagination and sort
     * @return
     */
    @Override
    public List<Recruitment> findRecruitments(SearchCondition con, Pageable pageable) {
        return RecruitmentRepository.findAll(con,pageable);
    }
}
