package com.pink.se.viewobject;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 *  前端包装类VO
 *  数据展示模型，也可以做数据转换
 */


/**
 * 报告包装类
 */
public class FirstReportVO {

    //报告属性

    private String title;//标题

    private Integer categoryId;//分类名称id


    private Integer commitStaffId;//提交者id

    private Integer receiveStaffId;//接收者id


    //版本控制属性

    @NotNull
    private String reportContent;//报告版本内容


    @NotNull
    private String message;//提交说明


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getCommitStaffId() {
        return commitStaffId;
    }

    public void setCommitStaffId(Integer commitStaffId) {
        this.commitStaffId = commitStaffId;
    }

    public Integer getReceiveStaffId() {
        return receiveStaffId;
    }

    public void setReceiveStaffId(Integer receiveStaffId) {
        this.receiveStaffId = receiveStaffId;
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
