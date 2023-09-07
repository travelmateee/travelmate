package team.travelmate.web.exception.advice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import team.travelmate.web.exception.RecruitmentErrorResult;

@Slf4j
@RestControllerAdvice
public class ExControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalStateException.class)
    public RecruitmentErrorResult illegalExHandle(IllegalStateException e){
        log.error("[exceptionHandle] ex",e);
        return new RecruitmentErrorResult("Bad",e.getMessage());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(IllegalArgumentException.class)
    public RecruitmentErrorResult illegalStatementExHandle(IllegalArgumentException e){
        log.error("[exceptopnHandle] ex",e);
        return new RecruitmentErrorResult("Bad",e.getMessage());
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler
    public RecruitmentErrorResult exHandle(Exception e){
        log.error("[exceptionHandle] ex",e);
        return new RecruitmentErrorResult("exception","server Error");
    }

}
