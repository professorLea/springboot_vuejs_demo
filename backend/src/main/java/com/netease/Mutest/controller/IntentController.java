package com.netease.Mutest.controller;

import com.netease.Mutest.model.Intent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class IntentController {

    @RequestMapping(value = "/intent")
    public ResponseEntity<List<Intent>> getIntent() {
        Intent intent1 = new Intent();
        Intent intent2 = new Intent();
        intent1.setName("PAYMENT.inquire_refund");
        intent1.setCase_num(244);
        intent1.setCase_passed(134);
        intent1.setCase_pass_radio((134 / 244) * 100);
        intent2.setName("EXPRESS.inquire_express");
        intent2.setCase_num(242);
        intent2.setCase_passed(132);
        intent2.setCase_pass_radio((132 / 242) * 100);

        ArrayList<Intent> intents = new ArrayList<Intent>();
        intents.add(intent1);
        intents.add(intent2);

        return new ResponseEntity<List<Intent>>(intents, HttpStatus.OK);
    }
}
