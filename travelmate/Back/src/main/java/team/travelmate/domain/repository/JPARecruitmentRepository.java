package team.travelmate.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import team.travelmate.domain.Entity.recruitment.Recruitment;

@Component
public interface JPARecruitmentRepository extends JpaRepository<Recruitment, Long> {

}
