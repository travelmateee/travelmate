package team.travelmate.web.InitTestData;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import team.travelmate.domain.Entity.recruitment.Recruitment;
import team.travelmate.domain.Entity.user.User;
import team.travelmate.domain.repository.RecruitmentRepository;
import team.travelmate.domain.repository.UserRepository;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class RecruitmentTestData {

    private final UserRepository ur;
    private final RecruitmentRepository rr;

    @PostConstruct
    public void initTestData(){
        User user = new User();
        user.setName("test");
        ur.save(user);

        User userA = new User();
        userA.setName("testA");
        ur.save(userA);

        for (int i = 0 ; i < 20 ; i++){
            Recruitment recruitment = new Recruitment();
            recruitment.setTitle("test title");
            recruitment.setBody("test body");
            recruitment.setBudge(200000L);
            recruitment.setPlace("test place");
            recruitment.setStartDate(LocalDate.of(2023,9,01));
            recruitment.setDueDate(LocalDate.of(2023,9,03));
            recruitment.setWriteDate(LocalDate.now());
            recruitment.setUser(user);
            rr.save(recruitment);
        }

        for (int i = 0 ; i < 20 ; i++){
            Recruitment recruitment = new Recruitment();
            recruitment.setTitle("d title");
            recruitment.setBody("d body");
            recruitment.setBudge(100000L);
            recruitment.setPlace("d place");
            recruitment.setStartDate(LocalDate.of(2023,9,10));
            recruitment.setDueDate(LocalDate.of(2023,9,13));
            recruitment.setWriteDate(LocalDate.now());
            recruitment.setUser(user);
            rr.save(recruitment);
        }

        Recruitment recruitmentA = new Recruitment();
        recruitmentA.setTitle("d");
        recruitmentA.setBody("d");
        recruitmentA.setBudge(50000L);
        recruitmentA.setPlace("d");
        recruitmentA.setStartDate(LocalDate.of(2023,9,10));
        recruitmentA.setDueDate(LocalDate.of(2023,9,13));
        recruitmentA.setWriteDate(LocalDate.now());
        recruitmentA.setUser(userA);
        rr.save(recruitmentA);

    }

}
