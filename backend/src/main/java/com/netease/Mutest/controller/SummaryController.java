package com.netease.Mutest.controller;

import com.netease.Mutest.dto.SummaryResult;
import com.netease.Mutest.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: professor
 * Date: 2017/6/2
 * Time: 下午1:05
 */
@RestController
@RequestMapping("/api")
public class SummaryController {
    @Autowired
    private SummaryService summaryService;

    @RequestMapping(value = "/summary")
    public ResponseEntity<SummaryResult> getSummary(@RequestParam(value = "reportId") String reportId) {

        SummaryResult results = (summaryService.getSummaryResult(reportId));

        return new ResponseEntity<>(results, HttpStatus.OK);
    }
}
