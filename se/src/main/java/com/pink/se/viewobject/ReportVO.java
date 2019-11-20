package com.pink.se.viewobject;

import java.util.Date;

/**
 *  前端包装类VO
 *  数据展示模型，也可以做数据转换
 */


/**
 * 报告包装类
 */
public class ReportVO {

    //报告属性
    private Integer id;//主键  ,首次提交自动生成

    private String title;//标题

    private Integer categoryId;//分类名称id

    private Integer versionId;//版本id  ,首次提交变成1，加入草稿箱为0

    private Integer commitStaffId;//提交者id

    private Integer receiveStaffId;//接收者id

    private Date commitTime;//首次提交时间

    private Integer status;//报告状态：0为在草稿箱内未提交；-1为提交已采纳；n∈[1，99]为正在进行第n次提交

    private Byte deleteStatus;//删除状态：0为未删除；1为软删除；-1为彻底删除

    //版本控制属性

    private Integer versionIdKey;//版本控制表id

    private Integer reportVersion;//报告版本id

    private Date createAt;//提交时间

    private String reportContent;//报告版本内容

    private String replyIds;//评论id集合  实际存json

    private String message;//提交说明


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Integer getVersionId() {
        return versionId;
    }

    public void setVersionId(Integer versionId) {
        this.versionId = versionId;
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

    public Date getCommitTime() {
        return commitTime;
    }

    public void setCommitTime(Date commitTime) {
        this.commitTime = commitTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Byte getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Byte deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Integer getVersionIdKey() {
        return versionIdKey;
    }

    public void setVersionIdKey(Integer versionIdKey) {
        this.versionIdKey = versionIdKey;
    }

    public Integer getReportVersion() {
        return reportVersion;
    }

    public void setReportVersion(Integer reportVersion) {
        this.reportVersion = reportVersion;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    public String getReplyIds() {
        return replyIds;
    }

    public void setReplyIds(String replyIds) {
        this.replyIds = replyIds;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
