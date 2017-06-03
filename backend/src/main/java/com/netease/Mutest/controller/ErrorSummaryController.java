package com.netease.Mutest.controller;

import com.netease.Mutest.dto.ErrorSummaryResult;
import com.netease.Mutest.dto.IntentTestResult;
import com.netease.Mutest.service.ErrorSummaryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: professor
 * Date: 2017/6/3
 * Time: 上午9:43
 */
@RestController
@RequestMapping("/api")
public class ErrorSummaryController {

    @Resource
    private ErrorSummaryService errorSummaryService;

    @RequestMapping(value = "/errorcases")
    public ResponseEntity<List<ErrorSummaryResult>> getErrorSummary(@RequestParam(value = "reportId") String reportId) {

        List<ErrorSummaryResult> results = errorSummaryService.getErrorSummaryByReportId(reportId);

        return new ResponseEntity<>(results, HttpStatus.OK);

    }
}
