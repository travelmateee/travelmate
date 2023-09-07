package team.travelmate.domain.repository.recruitment;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.web.PageableDefault;
import team.travelmate.common.SearchCondition;
import team.travelmate.domain.Entity.recruitment.Recruitment;
import team.travelmate.domain.Entity.user.User;
import team.travelmate.domain.repository.RecruitmentRepository;
import team.travelmate.domain.repository.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@Slf4j
@SpringBootTest
class RecruitmentRepositoryImpleTest {

    @Autowired
    RecruitmentRepository repository;
    @Autowired
    UserRepository UserRepository;

    @Test
    @DisplayName("CRUD Test")
    void crud(){

        // User 객체 생성
        User user = new User();
        user.setName("tester");
        UserRepository.save(user);
        User userB = new User();
        userB.setName("testerB");
        UserRepository.save(userB);

        // Recruitment 객체 생성
        Recruitment recruitment = new Recruitment(user,"test","test body", LocalDate.of(2023,9,01), LocalDate.of(2023,9,03),LocalDate.of(2023,9,01),"japen",2000000L);
        // save test
        Recruitment savedRecruitment = repository.save(recruitment);
        assertThat(savedRecruitment.getRid()).isEqualTo(1);

        for(int i = 0 ; i <=20 ; i++){
            Recruitment recruitmentB = new Recruitment(userB,"test","test body", LocalDate.of(2023,9,01), LocalDate.of(2023,9,03),LocalDate.of(2023,9,01),"japen",2000000L);
            Recruitment savedRecruitmentB = repository.save(recruitmentB);
        }
        Recruitment recruitmentB = new Recruitment(userB,"test","test body", LocalDate.of(2023,9,01), LocalDate.of(2023,9,03),LocalDate.of(2023,9,01),"japen",2000000L);
        Recruitment savedRecruitmentB = repository.save(recruitmentB);
        //assertThat(savedRecruitmentB.getRid()).isEqualTo(2);

        Optional<Recruitment> byRid = repository.findByRid(recruitmentB.getRid());
        Recruitment recruitmentC = new Recruitment(byRid.get().getUser(), "test","test body", LocalDate.of(2023,9,01), LocalDate.of(2023,9,03),LocalDate.of(2023,9,01),"japen",2000000L);
        Recruitment savedRecruitmentC = repository.save(recruitmentC);
        //assertThat(savedRecruitmentC.getRid()).isEqualTo(3);

        log.info("rid ={} , title={}",savedRecruitment.getRid(),savedRecruitment.getTitle());

        Recruitment updateParam = new Recruitment(user,"test edit","test edit body", LocalDate.of(2023,9,01), LocalDate.of(2023,9,05),LocalDate.of(2023,9,01),"japen",2000000L);
        repository.update(savedRecruitment.getRid(), updateParam);


        log.info("rid ={} , title={}",savedRecruitmentB.getRid(),savedRecruitmentB.getTitle());
        log.info("rid ={} , title={}",savedRecruitmentC.getRid(),savedRecruitmentC.getTitle());
        Optional<Recruitment> findRecruitment = repository.findByRid(savedRecruitment.getRid());
        assertThat(findRecruitment.get().getTitle()).isEqualTo("test edit");
        log.info("update check rid ={} , title={}",findRecruitment.get().getRid(),findRecruitment.get().getTitle());

        SearchCondition searchCondition = new SearchCondition();
        searchCondition.setUID(2L);
        searchCondition.setTitle("test");
        searchCondition.setStartDate(LocalDate.of(2023,9,01));
        searchCondition.setDueDate(LocalDate.of(2023,9,03));
        List<Recruitment> result = repository.findAll(searchCondition, PageRequest.of(0,10));

        printResultList(result);

    }

    private static void printResultList(List<Recruitment> result) {
        for ( Recruitment r : result) {
            log.info("[print Result] uid = {} , title = {} , body = {}", r.getUser().getId(),r.getTitle(),r.getBody());
        }
    }

}