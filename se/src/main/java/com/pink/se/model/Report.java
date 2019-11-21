package com.pink.se.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Report {

    private Integer id;

    private String title;

    private Integer categoryId;

    private Integer versionId;


    private Integer commitStaffId;


    private Integer receiveStaffId;


    private Date commitTime;

    private Integer status;

    private Byte deleteStatus;

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
        this.title = title == null ? null : title.trim();
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
}