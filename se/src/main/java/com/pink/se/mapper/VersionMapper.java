package com.pink.se.mapper;

import com.pink.se.model.Version;
import org.apache.ibatis.annotations.Param;

public interface VersionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Version record);

    int insertSelective(Version record);

    Version selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Version record);

    int updateByPrimaryKeyWithBLOBs(Version record);

    int updateByPrimaryKey(Version record);

    int getCurrentReportMaxVersionByReportId(@Param("reportId") Integer reportId);
}