package team.travelmate.web.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecruitmentErrorResult {

    private String code;
    private String message;

}
