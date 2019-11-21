package com.pink.se.service.Impl;

import com.pink.se.mapper.ReportMapper;
import com.pink.se.mapper.VersionMapper;
import com.pink.se.model.Report;
import com.pink.se.model.Version;
import com.pink.se.viewobject.FirstReportVO;
import com.pink.se.service.ReportService;
import com.pink.se.viewobject.RepeatReportVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class ReportServiceImpl  implements ReportService {

    @Autowired
    ReportMapper reportMapper;

    @Autowired
    VersionMapper versionMapper;

    /**
     *@Author hjx
     *@Description
     * 首次提交报告
     * 将报告存入表中，并进行版本控制
     *@Date 2019/11/21 11:53
     *@Param [firstReportVo]
     *@return boolean
    **/
    @Transactional
    @Override
    public boolean commitReport(FirstReportVO firstReportVo) {
        //1 分离Version对象
        Version version = versionConvertFromFirstReportVO(firstReportVo);
        int temp1   =  versionMapper.insertSelective(version);

        //2 分离Report对象
        Report report =reportConvertFromFirstReportVO(firstReportVo,version);
        int temp2=0;
        if (report.getStatus()==1){
            //此时将report插入表中
            temp2=reportMapper.insertSelective(report);
            //将reportId插入到version中
            version.setReportId(report.getId());
            versionMapper.updateByPrimaryKeySelective(version);
        }
        return temp2>0&&temp1>0;
    }

    /**
     *@Author hjx
     *@Description
     * 重新提交报告
     * 记录新版本，更新现有报告
     *@Date 2019/11/21 11:51
     *@Param [repeatReportVO]
     *@return boolean
    **/
    @Override
    public boolean repeatCommitReport(RepeatReportVO repeatReportVO) {
        //1 分离Version对象,记录版本
        Version version = versionConvertFromRepeatReportVO(repeatReportVO);
        int temp1   =  versionMapper.insertSelective(version);
        //2 分离Report对象，更新Report对象
        Report report =reportConvertFromRepeatReportVO(repeatReportVO,version);
        int temp2=0;
        if (report.getStatus()>1){
            //此时只需要修改report对象
            temp2= reportMapper.updateByPrimaryKeySelective(report);
        }
        return temp2>0&&temp1>0;
    }


    /**
     *@Author hjx
     *@Description
     * 通过报告id获取当前报告的最大版本号
     *@Date 2019/11/21 12:20
     *@Param [reportId]
     *@return int
    **/
    @Override
    public int getCurrentReportMaxVersionByReportId(Integer reportId) {
        return versionMapper.getCurrentReportMaxVersionByReportId(reportId);
    }

    /**
     *@Author hjx
     *@Description
     *转换方法，将前端传来的首次报告对象从包装类分离出来
     *@Date 2019/11/21 12:21
     *@Param [firstReportVo]
     *@return com.pink.se.model.Version
    **/

    private Version versionConvertFromFirstReportVO(FirstReportVO firstReportVo) {
        Version version = new Version();
        BeanUtils.copyProperties(firstReportVo,version);
        //还需要处理的属性   reportId; reportVersion; createdAt; replyIds;
        //对reportId的处理，如果是首次提交是没有报告id的，得首先生成报告id。在commitReport中会有处理
        //首次提交reportVersion默认为1
        version.setReportVersion(1);
        //设置版本提交时间
        version.setCreatedAt(new Date());

        //返回插入版本对象的结果(int)
        return version;

    }
    /**
     *@Author hjx
     *@Description
     * 转换方法，将前端传来的非首次提交报告对象从包装类分离出来
     *@Date 2019/11/21 12:24
     *@Param [repeatReportVO]
     *@return com.pink.se.model.Version
    **/

    private Version versionConvertFromRepeatReportVO(RepeatReportVO repeatReportVO){
        //对非首次提交的记录进行处理
        Version version = new Version();
        BeanUtils.copyProperties(repeatReportVO,version);
        //将版本自己的id设为null，清空BeanUtils的赋值
        version.setId(null);
        //设置版本的报告id
        version.setReportId(repeatReportVO.getId());
        //对应版本的记录号+1
        version.setReportVersion(getCurrentReportMaxVersionByReportId(version.getReportId())+1);
        //设置当前版本的提交时间
        version.setCreatedAt(new Date());

        //返回插入版本对象的结果(int)
        return  version;
    }


    private Report reportConvertFromFirstReportVO(FirstReportVO firstReportVo, Version dbVersion) {
        Report report = new Report();
        BeanUtils.copyProperties(firstReportVo,report);
        // 需要处理的属性 versionId; commitTime;  status;  deleteStatus;
        //逻辑判断   根据reportVo.getId()判断是否第一次提交，
        if (report.getId()==null){
            //report.id为null则是首次提交
            System.out.println("report首次提交");
            report.setStatus(1);
            //首次提交时间
            report.setCommitTime(new Date());
            report.setVersionId(dbVersion.getId());
            report.setDeleteStatus((byte)0);
            return report;
        }
     return null;
    }

    private Report reportConvertFromRepeatReportVO(RepeatReportVO repeatReportVO, Version dbVersion){
        Report report = new Report();
        BeanUtils.copyProperties(repeatReportVO,report);

        if(repeatReportVO.getId()!=null){    //视为已经提交过
            //获取数据库中完整的报告对象
            Report dbReport = reportMapper.selectByPrimaryKey(repeatReportVO.getId());
            //设置报告对应的版本的id号
            report.setVersionId(dbVersion.getId());
            //将报告的status加1
            report.setStatus(dbReport.getStatus()+1);
            return report;
        }
        return null;
    }
}
