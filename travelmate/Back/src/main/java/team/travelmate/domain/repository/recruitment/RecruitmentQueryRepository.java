package team.travelmate.domain.repository.recruitment;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;
import team.travelmate.common.SearchCondition;
import team.travelmate.domain.Entity.recruitment.Recruitment;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;

import static team.travelmate.domain.Entity.recruitment.QRecruitment.*;

/**
 * @author yeongwoonshin
 * @version v0.0
 * Querydsl 사용
 * 동적 쿼리 이용 Repository
 * Search condition 별 sql을 동적으로 생성
 */

@Repository
public class RecruitmentQueryRepository {

    private final JPAQueryFactory query;

    public RecruitmentQueryRepository(EntityManager em) {
        this.query = new JPAQueryFactory(em);
    }

    public List<Recruitment> findAll(SearchCondition con){

        return query.select(recruitment)
                .from(recruitment)
                .where(likeTitle(con.getTitle()),eqPlace(con.getPlace()),loeBudge(con.getBudge()),
                        eqUid(con.getUID()),eqDate(con.getStartDate(),con.getDueDate()))
                .fetch();
    }

    /*
    ### RECRUITMENTS SEARCH CONDITION

    String : title

    String : Place

    LONG : Budge

    Date : Start Date

    Date : Due Date

    LONG : UID
     */
    private BooleanExpression likeTitle(String title){
        if (StringUtils.hasText(title)){
            return recruitment.title.like("%" + title +"%");
        }
        return null;
    }

    private BooleanExpression eqPlace(String place){
        if (StringUtils.hasText(place)){
            return recruitment.place.eq("%" + place + "%");
        }
        return null;
    }

    private BooleanExpression loeBudge(Long budge){
        if (budge != null){
            return recruitment.budge.loe(budge);
        }
        return null;
    }

    private BooleanExpression eqUid(Long uid){
        if (uid != null){
            return recruitment.user.id.eq(uid);
        }
        return null;
    }

    private BooleanExpression eqDate(LocalDate startDate, LocalDate dueDate){
        if (startDate != null && dueDate != null){
            return recruitment.startDate.eq(startDate).and(recruitment.dueDate.eq(dueDate));
        }
        return null;
    }

}
