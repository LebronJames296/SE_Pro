package com.pink.se.service;

import com.pink.se.viewobject.ReportVO;

public interface ReportService {
    boolean commitReport(ReportVO reportVo);

    int getCurrentReportMaxVersionByReportId(Integer reportId);
}
