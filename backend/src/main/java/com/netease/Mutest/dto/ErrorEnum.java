package com.netease.Mutest.dto;

/**
 * Created with IntelliJ IDEA.
 * User: professor
 * Date: 2017/6/3
 * Time: 上午10:56
 */
public enum ErrorEnum {
    INTENT_TO_CHAT(0, "意图被识别为闲聊"),
    INTENT_UNREC(1, "意图识别错误"),
    CHAT_REC_OTHER(2, "闲聊意图被识别为其他意图"),
    ENTITY_COUNT_ERROR(10, "实体数量识别错误"),
    ENTITY_ERROR(12, "实体识别错误"),;

    private Integer num;
    private String errorType;

    ErrorEnum(int num, String errorType) {
        this.num = num;
        this.errorType = errorType;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }
}
