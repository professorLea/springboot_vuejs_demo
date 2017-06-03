package com.netease.Mutest.dto;

/**
 * Created with IntelliJ IDEA.
 * User: professor
 * Date: 2017/6/3
 * Time: 下午2:45
 */
public class ErrorDetailResult {
    private String utterance;
    private String error_info;

    public String getUtterance() {
        return utterance;
    }

    public void setUtterance(String utterance) {
        this.utterance = utterance;
    }

    public String getError_info() {
        return error_info;
    }

    public void setError_info(String error_info) {
        this.error_info = error_info;
    }
}
