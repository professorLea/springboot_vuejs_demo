package com.netease.Mutest.service.impl;

import com.netease.Mutest.dao.ErrorSummaryMapper;
import com.netease.Mutest.dao.SummaryMapper;
import com.netease.Mutest.dto.ErrorEnum;
import com.netease.Mutest.dto.ErrorSummaryResult;
import com.netease.Mutest.model.ErrorSummary;
import com.netease.Mutest.model.Summary;
import com.netease.Mutest.service.ErrorSummaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: professor
 * Date: 2017/6/3
 * Time: 上午9:49
 */
@Service
public class ErrorSummaryServiceImpl implements ErrorSummaryService {

    @Autowired
    SummaryMapper summaryMapper;

    @Autowired
    ErrorSummaryMapper errorSummaryMapper;

    @Override
    public List<ErrorSummaryResult> getErrorSummaryByReportId(String reportId) {

        List<ErrorSummaryResult> results = new ArrayList<>();
        List<Summary> summaries = summaryMapper.selectByReportId(reportId);
        if (summaries.isEmpty()) {
            return null;
        }
        for (Summary s : summaries) {
            ArrayList<ErrorSummary> errorSummaries = errorSummaryMapper.selectBySummaryId(s.getId());
            for (ErrorSummary e : errorSummaries) {
                ErrorSummaryResult rlt = new ErrorSummaryResult();
                rlt.setCase_num(e.getCaseNum());
                if (e.getErrorDesc().equals(Integer.toString(ErrorEnum.INTENT_UNREC.getNum()))) {
                    rlt.setErrorType(ErrorEnum.INTENT_UNREC.getErrorType());
                } else if (e.getErrorDesc().equals(Integer.toString(ErrorEnum.CHAT_REC_OTHER.getNum()))) {
                    rlt.setErrorType(ErrorEnum.CHAT_REC_OTHER.getErrorType());
                } else if (e.getErrorDesc().equals(Integer.toString(ErrorEnum.INTENT_MISS.getNum()))) {
                    rlt.setErrorType(ErrorEnum.INTENT_MISS.getErrorType());
                } else if (e.getErrorDesc().equals(Integer.toString(ErrorEnum.ENTITY_ERROR.getNum()))) {
                    rlt.setErrorType(ErrorEnum.ENTITY_ERROR.getErrorType());
                } else {
                    rlt.setErrorType("其他错误");
                }
                results.add(rlt);
            }
        }

        return results;
    }
}
