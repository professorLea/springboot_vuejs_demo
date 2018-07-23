package com.netease.Mutest.dto;


/**
 * Created with IntelliJ IDEA.
 * User: professor
 * Date: 2017/6/2
 * Time: 上午9:47
 */
public class IntentTestResult {
    private String contextual;

    private String intent;

    public String getContextual() {
        return contextual;
    }

    public void setContextual(String contextual) {
        this.contextual = contextual;
    }

    public String getIntent() {
        return intent;
    }

    public void setIntent(String intent) {
        this.intent = intent;
    }

    public String getCaseNum() {
        return caseNum;
    }

    public void setCaseNum(String caseNum) {
        this.caseNum = caseNum;
    }

    public String getCasePassed() {
        return casePassed;
    }

    public void setCasePassed(String casePassed) {
        this.casePassed = casePassed;
    }

    public String getCasePassRadio() {
        return casePassRadio;
    }

    public void setCasePassRadio(String casePassRadio) {
        this.casePassRadio = casePassRadio;
    }

    private String caseNum;
    private String casePassed;
    private String casePassRadio;


}
