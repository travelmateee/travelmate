package team.travelmate.common;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

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

    private LocalDate StartDate;

    private LocalDate DueDate;

    private Long UID;

    public SearchCondition() {
    }

    public SearchCondition(String title, String place, Long budge, LocalDate startDate, LocalDate dueDate, Long UID) {
        this.title = title;
        this.place = place;
        Budge = budge;
        StartDate = startDate;
        DueDate = dueDate;
        this.UID = UID;
    }
}
