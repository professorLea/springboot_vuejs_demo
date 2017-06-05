package com.netease.Mutest.dto;

/**
 * Created with IntelliJ IDEA.
 * User: professor
 * Date: 2017/6/2
 * Time: 下午2:33
 */
public class EntityTestResult {
    private String entity_type;
    private Integer case_num;
    private Integer case_passed;
    private String pass_radio;

    public String getEntity_type() {
        return entity_type;
    }

    public void setEntity_type(String entity_type) {
        this.entity_type = entity_type;
    }

    public Integer getCase_num() {
        return case_num;
    }

    public void setCase_num(Integer case_num) {
        this.case_num = case_num;
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
