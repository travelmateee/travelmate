package team.travelmate.common;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *  Recruitment Search Condition
 */
@Data
public class SearchCondition {

    /*
    RECRUITMENTS SEARCH CONDITION

    String : title

    String : Place

    LONG : Budge

    Date : Start Date

    Date : Due Date

    LONG : UID
     */
    private String title;

    private String place;

    private Long Budge;

    private LocalDateTime StartDate;

    private LocalDateTime DueDate;

    private Long UID;

    public SearchCondition() {
    }

    public SearchCondition(String title, String place, Long budge, LocalDateTime startDate, LocalDateTime dueDate, Long UID) {
        this.title = title;
        this.place = place;
        Budge = budge;
        StartDate = startDate;
        DueDate = dueDate;
        this.UID = UID;
    }
}
