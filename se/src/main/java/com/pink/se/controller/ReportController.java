package com.pink.se.controller;


import com.pink.se.response.RespBean;
import com.pink.se.service.ReportService;
import com.pink.se.viewobject.FirstReportVO;
import com.pink.se.viewobject.RepeatReportVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/report")
public class ReportController {
    @Autowired
    ReportService reportService;

   /**
    *@Author hjx
    *@Description 首次提交报告
    *@Date 2019/11/21 11:35
    *@Param  * @param firstReportVo
    *@return com.pink.se.response.RespBean
   **/
    @PutMapping("/first")
    public RespBean firstCommitReport(@RequestBody  @Valid FirstReportVO firstReportVo){
        //将报告包装对象分离出来，分表存储。
        if (firstReportVo !=null){
            if (reportService.commitReport(firstReportVo)) {
                return  RespBean.success("提交成功");
            }
        }
        return RespBean.fail("提交失败");
    }


    @PutMapping("/repeat")
    public RespBean repeatCommitReport(@RequestBody  @Valid RepeatReportVO repeatReportVO){
        //将报告包装对象分离出来，分表存储。
        if (repeatReportVO !=null){
            if (reportService.repeatCommitReport(repeatReportVO)) {
                return  RespBean.success("repeat提交成功");
            }
        }
        return RespBean.fail("repeat提交失败");
    }





}
