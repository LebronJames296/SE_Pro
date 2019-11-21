package com.pink.se.service;

import com.pink.se.viewobject.FirstReportVO;
import com.pink.se.viewobject.RepeatReportVO;

public interface ReportService {
    boolean commitReport(FirstReportVO firstReportVo);

    int getCurrentReportMaxVersionByReportId(Integer reportId);

    boolean repeatCommitReport(RepeatReportVO repeatReportVO);
}
