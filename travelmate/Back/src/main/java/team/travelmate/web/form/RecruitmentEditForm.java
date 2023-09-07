package team.travelmate.web.form;

import lombok.Data;
import team.travelmate.file.UploadFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class RecruitmentEditForm {

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    private String body;

    @NotNull
    private LocalDateTime startDate;

    @NotNull
    private LocalDateTime dueDate;

    @NotNull
    private String place;

    @NotNull
    private Long budge;

    private List<UploadFile> uploadImgs;

}
