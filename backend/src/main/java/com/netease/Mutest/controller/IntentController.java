package com.netease.Mutest.controller;

import com.netease.Mutest.dao.SummaryMapper;
import com.netease.Mutest.dto.IntentEnum;
import com.netease.Mutest.dto.IntentTestResult;
import com.netease.Mutest.model.IntentTest;
import com.netease.Mutest.model.Summary;
import com.netease.Mutest.service.IntentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class IntentController {

    @Autowired
    private IntentService intentService;

    @RequestMapping(value = "/intent")
    public ResponseEntity<List<IntentTestResult>> getIntent(@RequestParam(value = "reportId") String reportId) {
        DecimalFormat df = new DecimalFormat("#.##");
        List<IntentTestResult> results = new ArrayList<>();
        //根据reportid 获取当前意图测试结果

        ArrayList<IntentTest> intentTests = intentService.getIntentTestByReportId(reportId);

        for (IntentTest test : intentTests) {
            IntentTestResult rlt = new IntentTestResult();
//            System.out.print(IntentEnum.values());
            switch (test.getIntentId()) {
                case 1:
                    rlt.setIntent(IntentEnum.inquire_refund.getDesc());
                    break;
                case 2:
                    rlt.setIntent(IntentEnum.inquire_express.getDesc());
                    break;
                case 3:
                    rlt.setIntent(IntentEnum.inquire_order.getDesc());
                    break;
                case 4:
                    rlt.setIntent(IntentEnum.chitchat.getDesc());
                    break;
                default:
                    break;
            }
            rlt.setCaseNum(Integer.toString(test.getCaseNum()));
            rlt.setCasePassed(Integer.toString(test.getCasePassed()));
            float radio = (test.getCasePassed() * 100.0f) / test.getCaseNum();
//            System.out.print(Float.toString(radio));
//            System.out.print(radio);
            rlt.setCasePassRadio(df.format(radio));
            Byte contextual = intentService.getContextualBySummaryId(test.getSummaryId());
//            System.out.print(contextual.intValue());
            if (contextual.intValue() == 0) {
                rlt.setContextual("首问");
            } else {
                rlt.setContextual("反问");
            }
            results.add(rlt);
        }

        return new ResponseEntity<>(results, HttpStatus.OK);
    }
}
