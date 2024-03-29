package team.travelmate.web.service.recruitment;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import team.travelmate.common.SearchCondition;
import team.travelmate.domain.Entity.recruitment.Recruitment;
import team.travelmate.domain.Entity.user.User;
import team.travelmate.domain.repository.RecruitmentRepository;
import team.travelmate.domain.repository.UserRepository;
import team.travelmate.web.form.RecruitmentAddForm;
import team.travelmate.web.form.RecruitmentEditForm;
import team.travelmate.web.returnjson.DeleteResult;
import team.travelmate.web.service.RecruitmentService;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class RecruitmentsServiceImple implements RecruitmentService {

    private final RecruitmentRepository recruitmentRepository;
    private final UserRepository userRepository;

    @Override
    public Recruitment saveRecruitment(RecruitmentAddForm form, Long userId) {

        Recruitment recruitment = formToRecruitment(form, userId);

        return recruitmentRepository.save(recruitment);
    }


    @Override
    public Recruitment updateRecruitment(Long Rid, RecruitmentEditForm updateParam) {

        if (!targetCheck(Rid)){
            throw new IllegalStateException("해당 게시물이 존재하지 않습니다.");
        }

        Recruitment target = recruitmentRepository.findByRid(Rid).get();

        updateParamSetTarget(target,updateParam);

        recruitmentRepository.save(target);

        return target;
    }

    @Override
    public DeleteResult deleteRecruitment(Long Rid) {

        if (!targetCheck(Rid)){
            throw new IllegalStateException("해당 게시물이 존재하지 않습니다.");
        }

        recruitmentRepository.delete(Rid);
        DeleteResult deleteResult = new DeleteResult();
        if (!targetCheck(Rid)){
            deleteResult.setDeleted(true);
        }else {
            deleteResult.setDeleted(false);
        }

        return deleteResult;
    }

    @Override
    public Optional<Recruitment> findByRid(Long Rid) {
        return recruitmentRepository.findByRid(Rid);
    }

    /**
     *
     * @param con 검색 조건 객체
     * @param page page
     * @param size pageOfSize
     * @return Recruitment list
     */
    @Override
    public List<Recruitment> findRecruitments(SearchCondition con, Integer page, Integer size) {

        if (page > 0){
            page -= 1;
        }else if (page < 0) {
            throw new IllegalArgumentException("Page 크기가 음수일 수 없습니다.");
        }

        // default pageSize setting
        if (size == 0){
            size = 10;
        } else if (size < 1) {
            throw new IllegalArgumentException("size 크기가 1보다 작을 수 없습니다.");
        }

        PageRequest pageRequest = PageRequest.of(page,size);

        return recruitmentRepository.findAll(con,pageRequest);
    }

    public boolean targetCheck(Long Rid){
        if (findByRid(Rid).isEmpty()){
            return false;
        }
        return true;
    }

    private Recruitment formToRecruitment(RecruitmentAddForm form, Long userId) {

        Optional<User> user = userRepository.findById(userId);

        Recruitment recruitment = new Recruitment();
        recruitment.setTitle(form.getTitle());
        recruitment.setBody(form.getBody());
        recruitment.setBudge(form.getBudge());
        recruitment.setStartDate(form.getStartDate());
        recruitment.setDueDate(form.getDueDate());
        recruitment.setWriteDate(LocalDateTime.now());
        recruitment.setPlace(form.getPlace());
        recruitment.setUploadImgs(form.getUploadImgs());
        recruitment.setUser(user.get());
        return recruitment;
    }

    private void updateParamSetTarget(Recruitment target, RecruitmentEditForm updateParam) {
        target.setTitle(updateParam.getTitle());
        target.setBody(updateParam.getBody());
        target.setPlace(updateParam.getPlace());
        target.setWriteDate(LocalDateTime.now());
        target.setBudge(updateParam.getBudge());
        target.setStartDate(updateParam.getStartDate());
        target.setDueDate(updateParam.getDueDate());
        target.setUploadImgs(updateParam.getUploadImgs());
    }

}
