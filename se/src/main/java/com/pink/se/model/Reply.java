package com.pink.se.model;

import java.util.Date;

public class Reply {
    private Integer id;

    private Integer replyStaffId;

    private String content;

    private Date replyTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getReplyStaffId() {
        return replyStaffId;
    }

    public void setReplyStaffId(Integer replyStaffId) {
        this.replyStaffId = replyStaffId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getReplyTime() {
        return replyTime;
    }

    public void setReplyTime(Date replyTime) {
        this.replyTime = replyTime;
    }
}