package com.netease.Mutest.dto;

/**
 * Created with IntelliJ IDEA.
 * User: professor
 * Date: 2017/6/2
 * Time: 上午9:59
 */
public enum IntentEnum {
    inquire_refund(1, "PAYMENT.inquire_refund"),
    inquire_express(2, "EXPRESS.inquire_express"),
    inquire_order(3, "SHOPPING.inquire_order"),
    chitchat(4, "CHAT.chitchat"),;
    private Integer num;

    public Integer getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    private String desc;

    IntentEnum(Integer num, String desc) {
        this.desc = desc;
        this.num = num;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
