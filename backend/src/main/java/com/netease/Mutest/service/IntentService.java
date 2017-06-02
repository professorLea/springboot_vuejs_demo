package com.netease.Mutest.service;

import com.netease.Mutest.model.Intent;
import com.netease.Mutest.model.IntentTest;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: professor
 * Date: 2017/6/1
 * Time: 下午6:18
 */
public interface IntentService {

    ArrayList<IntentTest> getIntentTestByReportId(String reportId);

    Byte getContextualBySummaryId(Integer summaryId);
}
