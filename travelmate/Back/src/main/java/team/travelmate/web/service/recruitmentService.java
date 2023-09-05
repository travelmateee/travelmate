package team.travelmate.web.service;

import team.travelmate.common.SearchCondition;
import team.travelmate.domain.Entity.recruitment.Recruitment;

import java.util.List;

public interface recruitmentService {

    Recruitment saveRecuitment(Recruitment recruitment);

    Recruitment updateRecuitment(Long Rid, Recruitment updateParam);

    void deleteRecruitment(Long Rid);

    Recruitment findByRid(Long Rid);

    List<Recruitment> findRecuitents(SearchCondition con);

}
