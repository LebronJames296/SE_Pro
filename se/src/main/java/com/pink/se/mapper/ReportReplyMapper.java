package com.pink.se.mapper;

import com.pink.se.model.ReportReply;

public interface ReportReplyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ReportReply record);

    int insertSelective(ReportReply record);

    ReportReply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ReportReply record);

    int updateByPrimaryKey(ReportReply record);
}