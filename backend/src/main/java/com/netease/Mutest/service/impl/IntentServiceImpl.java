package com.netease.Mutest.service.impl;

import com.netease.Mutest.dao.IntentMapper;
import com.netease.Mutest.dao.IntentTestMapper;
import com.netease.Mutest.dao.SummaryMapper;
import com.netease.Mutest.model.Intent;
import com.netease.Mutest.model.IntentTest;
import com.netease.Mutest.model.Summary;
import com.netease.Mutest.service.IntentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: professor
 * Date: 2017/6/1
 * Time: 下午6:17
 */
@Service
public class IntentServiceImpl implements IntentService {

    @Autowired
    private IntentTestMapper intentTestMapper;

    @Autowired
    private SummaryMapper summaryMapper;

    @Autowired
    private IntentMapper intentMapper;


    @Override
    public ArrayList<IntentTest> getIntentTestByReportId(String reportId) {
        ArrayList<IntentTest> intents = new ArrayList<>();

        //  根据reportid获取所有首问和反问的summaryid
        List<Summary> summarys = summaryMapper.selectByReportId(reportId);
        if (!summarys.isEmpty()) {
            // 根据summaryid获取所有的Intent_test中的意图测试结果
            // 并合并起来
            for (Summary s : summarys) {
                intents.addAll(intentTestMapper.selectBySummaryId(s.getId()));
            }
            return intents;
        }
        return null;
    }

    @Override
    public Byte getContextualBySummaryId(Integer summaryId) {
        return summaryMapper.selectByPrimaryKey(summaryId).getIsContextual();
    }

    @Override
    public String getIntentNameById(Integer id) {
        Intent intent = intentMapper.selectByPrimaryKey(id);
        return intent.getName();
    }


}
