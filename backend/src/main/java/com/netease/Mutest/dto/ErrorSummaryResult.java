package com.netease.Mutest.dto;

/**
 * Created with IntelliJ IDEA.
 * User: professor
 * Date: 2017/6/3
 * Time: 上午9:44
 */
public class ErrorSummaryResult {
    private String errorType;
    private Integer case_num;

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public Integer getCase_num() {
        return case_num;
    }

    public void setCase_num(Integer case_num) {
        this.case_num = case_num;
    }
}
