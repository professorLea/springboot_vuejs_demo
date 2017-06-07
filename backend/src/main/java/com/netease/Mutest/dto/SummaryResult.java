package com.netease.Mutest.dto;

/**
 * Created with IntelliJ IDEA.
 * User: professor
 * Date: 2017/6/2
 * Time: 下午1:06
 */
public class SummaryResult {
    private Integer total_cases;
    private Integer case_passed;
    private String pass_radio;

    public Integer getTotal_cases() {
        return total_cases;
    }

    public void setTotal_cases(Integer total_cases) {
        this.total_cases = total_cases;
    }

    public Integer getCase_passed() {
        return case_passed;
    }

    public void setCase_passed(Integer case_passed) {
        this.case_passed = case_passed;
    }

    public String getPass_radio() {
        return pass_radio;
    }

    public void setPass_radio(String pass_radio) {
        this.pass_radio = pass_radio;
    }
}
