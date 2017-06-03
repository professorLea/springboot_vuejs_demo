package com.netease.Mutest.service;

import com.netease.Mutest.dto.ErrorDetailResult;
import com.netease.Mutest.dto.ErrorSummaryResult;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: professor
 * Date: 2017/6/3
 * Time: 上午9:48
 */
public interface ErrorSummaryService {

    List<ErrorSummaryResult> getErrorSummaryByReportId(String reportId);

    List<ErrorDetailResult> getErrorDetailsById(String type, String errorId);
}
