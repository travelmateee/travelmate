package team.travelmate.web.form;

import lombok.Data;
import team.travelmate.file.UploadFile;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
public class RecruitmentAddForm {

    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    private String body;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate dueDate;

    @NotNull
    private String place;

    @NotNull
    private Long budge;

    private List<UploadFile> uploadImgs;

}
