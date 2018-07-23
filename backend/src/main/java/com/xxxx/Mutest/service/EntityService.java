package com.netease.Mutest.service;

import com.netease.Mutest.dto.EntityTestResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: professor
 * Date: 2017/6/2
 * Time: 下午2:33
 */
public interface EntityService {

    ArrayList<EntityTestResult> getEntityTestResultByReportId(String reportId);
}
