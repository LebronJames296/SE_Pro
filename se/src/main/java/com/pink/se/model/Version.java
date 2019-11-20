package com.pink.se.model;

import java.util.Date;

public class Version {
    private Integer id;

    private Integer reportId;

    private Integer reportVersion;

    private Date createdAt;

    private String replyIds;

    private String message;

    private String reportContent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReportId() {
        return reportId;
    }

    public void setReportId(Integer reportId) {
        this.reportId = reportId;
    }

    public Integer getReportVersion() {
        return reportVersion;
    }

    public void setReportVersion(Integer reportVersion) {
        this.reportVersion = reportVersion;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getReplyIds() {
        return replyIds;
    }

    public void setReplyIds(String replyIds) {
        this.replyIds = replyIds == null ? null : replyIds.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getReportContent() {
        return reportContent;
    }

    public void setReportContent(String reportContent) {
        this.reportContent = reportContent == null ? null : reportContent.trim();
    }
}