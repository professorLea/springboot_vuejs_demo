package com.netease.Mutest.controller;

import com.netease.Mutest.dto.EntityTestResult;
import com.netease.Mutest.dto.IntentTestResult;
import com.netease.Mutest.service.EntityService;
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
 * Time: 下午3:03
 */
@RestController
@RequestMapping("/api")
public class EntityController {

    @Autowired
    private EntityService entityService;

    @RequestMapping(value = "/entity")
    public ResponseEntity<ArrayList<EntityTestResult>> getEntity(@RequestParam(value = "reportId") String reportId) {

        ArrayList<EntityTestResult> results = entityService.getEntityTestResultByReportId(reportId);
        return new ResponseEntity<>(results, HttpStatus.OK);
    }
}
