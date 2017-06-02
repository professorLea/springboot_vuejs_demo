package com.netease.Mutest.service.impl;

import com.netease.Mutest.dao.EntityMapper;
import com.netease.Mutest.dao.EntityTestMapper;
import com.netease.Mutest.dao.SummaryMapper;
import com.netease.Mutest.dto.EntityTestResult;
import com.netease.Mutest.model.Entity;
import com.netease.Mutest.model.EntityTest;
import com.netease.Mutest.model.Summary;
import com.netease.Mutest.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: professor
 * Date: 2017/6/2
 * Time: 下午2:40
 */
@Service
public class EntityServiceImpl implements EntityService {
    @Autowired
    private SummaryMapper summaryMapper;
    @Autowired
    private EntityTestMapper entityTestMapper;

    @Override
    public ArrayList<EntityTestResult> getEntityTestResultByReportId(String reportId) {
        ArrayList<EntityTestResult> rltLists = new ArrayList<>();
        List<Summary> summaryList = summaryMapper.selectByReportId(reportId);
        if (summaryList.isEmpty()) {
            return null;
        }
        for (Summary s : summaryList) {
            ArrayList<EntityTest> entityTestList = entityTestMapper.selectBySummaryId(s.getId());
            for (EntityTest e : entityTestList) {
                EntityTestResult result = new EntityTestResult();
                if (e.getType() == 1) {
                    result.setEntity_type("无实体");
                } else if (e.getType() == 2) {
                    result.setEntity_type("单实体");
                } else {
                    result.setEntity_type("多实体");
                }
                result.setCase_num(e.getCaseNum());
                result.setCase_passed(e.getCasePassed());
                result.setPass_radio((e.getCasePassed() * 100.0f) / e.getCaseNum());
                rltLists.add(result);
            }

        }
        return rltLists;
    }
}
