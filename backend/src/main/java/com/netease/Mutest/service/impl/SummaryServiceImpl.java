package com.netease.Mutest.service.impl;

import com.netease.Mutest.dao.SummaryMapper;
import com.netease.Mutest.dto.SummaryResult;
import com.netease.Mutest.model.Summary;
import com.netease.Mutest.service.SummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: professor
 * Date: 2017/6/2
 * Time: 下午1:09
 */
@Service
public class SummaryServiceImpl implements SummaryService {

    @Autowired
    private SummaryMapper summaryMapper;

    @Override
    public SummaryResult getSummaryResult(String reportid) {
        DecimalFormat df = new DecimalFormat("#.##");
        Integer total_cases = 0;
        Integer case_passed = 0;
        SummaryResult result = new SummaryResult();

        List<Summary> summaryList = summaryMapper.selectByReportId(reportid);
        for (Summary s : summaryList) {
            total_cases += s.getCaseNum();
            case_passed += s.getCasePassed();
        }
        result.setTotal_cases(total_cases);
        result.setCase_passed(case_passed);
        Float radio = (case_passed * 100.0f) / total_cases;
        result.setPass_radio(df.format(radio));
        return result;
    }
}
