package team.travelmate.web.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import team.travelmate.common.SearchCondition;
import team.travelmate.domain.Entity.recruitment.Recruitment;
import team.travelmate.web.service.RecruitmentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/recruitments")
@RestController
@RequiredArgsConstructor
public class RecruitmentController {

    private final RecruitmentService recruitmentService;

    @GetMapping
    public Object getRecruitments(
            @Validated @RequestBody SearchCondition con,
            BindingResult bindingResult,
            @RequestParam("page") Integer page,
            @RequestParam("size") Integer size
            ){

        if (bindingResult.hasErrors()){
            log.info("검증 오류 발생 error = {}",bindingResult);
            return bindingResult.getAllErrors();
        }

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

        log.info("con check : [title] : {}", con.getTitle());

        Map<String,List<Recruitment>> result = new HashMap<>();
        PageRequest pageRequest = PageRequest.of(page,size);
        List<Recruitment> recruitments = recruitmentService.findRecruitments(con, pageRequest);

        for (Recruitment r: recruitments) {
            log.info("title : {}" , r.getTitle());
        }
        result.put("RECRUITMENT",recruitments);
        return result;
    }


}
