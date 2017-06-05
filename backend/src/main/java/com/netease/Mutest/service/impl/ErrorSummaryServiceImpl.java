package com.netease.Mutest.service.impl;

import com.netease.Mutest.dao.CasesMapper;
import com.netease.Mutest.dao.ErrorCasesMapper;
import com.netease.Mutest.dao.ErrorSummaryMapper;
import com.netease.Mutest.dao.SummaryMapper;
import com.netease.Mutest.dto.ErrorDetailResult;
import com.netease.Mutest.dto.ErrorEnum;
import com.netease.Mutest.dto.ErrorSummaryResult;
import com.netease.Mutest.model.Cases;
import com.netease.Mutest.model.ErrorCases;
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
    private SummaryMapper summaryMapper;

    @Autowired
    private ErrorSummaryMapper errorSummaryMapper;

    @Autowired
    private ErrorCasesMapper errorCasesMapper;

    @Autowired
    private CasesMapper casesMapper;

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
                if (e.getErrorDesc().equals(Integer.toString(ErrorEnum.INTENT_UNREC.getNum()))) {
                    rlt.setType_id(ErrorEnum.INTENT_UNREC.getNum());
                    rlt.setError_type(ErrorEnum.INTENT_UNREC.getErrorType());
                } else if (e.getErrorDesc().equals(Integer.toString(ErrorEnum.CHAT_REC_OTHER.getNum()))) {
                    rlt.setType_id(ErrorEnum.CHAT_REC_OTHER.getNum());
                    rlt.setError_type(ErrorEnum.CHAT_REC_OTHER.getErrorType());
                } else if (e.getErrorDesc().equals(Integer.toString(ErrorEnum.INTENT_MISS.getNum()))) {
                    rlt.setType_id(ErrorEnum.INTENT_MISS.getNum());
                    rlt.setError_type(ErrorEnum.INTENT_MISS.getErrorType());
                } else if (e.getErrorDesc().equals(Integer.toString(ErrorEnum.ENTITY_ERROR.getNum()))) {
                    rlt.setType_id(ErrorEnum.ENTITY_ERROR.getNum());
                    rlt.setError_type(ErrorEnum.ENTITY_ERROR.getErrorType());
                } else {
                    rlt.setType_id(6);
                    rlt.setError_type("其他错误");
                }
                rlt.setCase_num(e.getCaseNum());
                rlt.setId(e.getId());
                results.add(rlt);
            }
        }

        return results;
    }

    @Override
    public List<ErrorDetailResult> getErrorDetailsById(String reportId) {
        List<ErrorDetailResult> results = new ArrayList<>();

        // 根据reportId找到所有的Summary实例
        List<Summary> summaries = summaryMapper.selectByReportId(reportId);

        for (Summary s : summaries) {
            // 根据summaryId找到所有的errorSummary实例
            List<ErrorSummary> errorSummaries = errorSummaryMapper.selectBySummaryId(s.getId());

            // 根据errorId索引所有的errorInfo errorType
            for (ErrorSummary e : errorSummaries) {
                List<ErrorCases> errorCases = errorCasesMapper.selectByErrorId(e.getId());
                for (ErrorCases c : errorCases) {
                    ErrorDetailResult rlt = new ErrorDetailResult();
                    rlt.setError_info(c.getErrorInfo());
                    int type = c.getErrorType().intValue();
                    if (type == ErrorEnum.INTENT_UNREC.getNum()) {
                        rlt.setError_type(ErrorEnum.INTENT_UNREC.getErrorType());
                    } else if (type == ErrorEnum.CHAT_REC_OTHER.getNum()) {
                        rlt.setError_type(ErrorEnum.CHAT_REC_OTHER.getErrorType());
                    } else if (type == ErrorEnum.INTENT_MISS.getNum()) {
                        rlt.setError_type(ErrorEnum.INTENT_MISS.getErrorType());
                    } else if (type == ErrorEnum.ENTITY_ERROR.getNum()) {
                        rlt.setError_type(ErrorEnum.ENTITY_ERROR.getErrorType());
                    } else {
                        rlt.setError_type("其他错误");
                    }
                    Cases cases = casesMapper.selectByPrimaryKey(c.getCaseId());
                    rlt.setUtterance(cases.getUtterance());
                    results.add(rlt);
                }
            }
        }

        return results;
    }
}
