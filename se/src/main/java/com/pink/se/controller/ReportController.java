package com.pink.se.controller;


import com.pink.se.response.RespBean;
import com.pink.se.service.ReportService;
import com.pink.se.viewobject.ReportVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    ReportService reportService;


    /**
     * 接受前端提交的报告包装对象
     * @param reportVo
     * @return
     */
    @PutMapping("/")
    public RespBean commitReport(@RequestBody ReportVO reportVo){
        //将报告包装对象分离出来，分表存储。
        if (reportVo!=null){
            if (reportService.commitReport(reportVo)) {
                return  RespBean.success("提交成功");
            }
        }
        return RespBean.fail("提交失败");
    }

}
