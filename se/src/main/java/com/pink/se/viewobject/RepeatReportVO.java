package com.pink.se.viewobject;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * ClassName RepeatReportVO
 * Description TODO
 *
 * @Author 胡江喜
 * @Date 2019/11/21 11:39
 **/
public class RepeatReportVO {

    //报告属性
    private Integer id;//主键  ,首次提交自动生成

    //版本控制属性

    @NotNull
    private String reportContent;//报告版本内容


    @NotNull
    private String message;//提交说明


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
