package com.pink.se.service.Impl;

import com.pink.se.mapper.ReportMapper;
import com.pink.se.mapper.VersionMapper;
import com.pink.se.model.Report;
import com.pink.se.model.Version;
import com.pink.se.viewobject.ReportVO;
import com.pink.se.service.ReportService;
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
     * 返回是否提交成功
     * 真正的业务逻辑是将前端传来的包装报告对象分离
     * @param reportVo
     * @return
     */
    @Transactional
    public boolean commitReport(ReportVO reportVo) {
        //1 分离Version对象
        Version version = versionConvertFromReportVO(reportVo);
        int temp1   =  versionMapper.insertSelective(version);

        //2 分离Report对象
        Report report =reportConvertFromReportVO(reportVo,version);
        int temp2=0;
        if (report.getStatus()>1){
            //此时只需要修改report对象
            temp2= reportMapper.updateByPrimaryKeySelective(report);
        }else{
            //此时将report插入表中
            temp2=reportMapper.insertSelective(report);
            //将reportId插入到version中
            version.setReportId(report.getId());
            versionMapper.updateByPrimaryKeySelective(version);
        }
        return temp2>0&&temp1>0;
    }




    @Override
    public int getCurrentReportMaxVersionByReportId(Integer reportId) {
        return versionMapper.getCurrentReportMaxVersionByReportId(reportId);
    }


    private Version versionConvertFromReportVO(ReportVO reportVo) {
        Version version = new Version();
        BeanUtils.copyProperties(reportVo,version);

        //还需要处理的属性   reportId; reportVersion; createdAt; replyIds;
       //对reportId的处理，如果是首次提交是没有报告id的，得首先生成报告id
        if (reportVo.getId()==null){
            //通过当前包装对象中是否有报告id确定是否是首次提交

            //首次提交reportVersion默认为1
            version.setReportVersion(1);
            //设置版本提交时间
            version.setCreatedAt(new Date());

            //返回插入版本对象的结果(int)
            return version;
        }


        //对非首次提交的记录进行处理
        if (reportVo.getId()!=null){
            //将版本自己的id设为null，清空BeanUtils的赋值
            version.setId(null);
            //设置版本的报告id
            version.setReportId(reportVo.getId());
            //对应版本的记录号+1
            version.setReportVersion(getCurrentReportMaxVersionByReportId(version.getReportId())+1);
            //设置当前版本的提交时间
            version.setCreatedAt(new Date());

            //返回插入版本对象的结果(int)
            return  version;
        }
        return null;
    }

    private Report reportConvertFromReportVO(ReportVO reportVo,Version dbVersion) {
        Report report = new Report();
        BeanUtils.copyProperties(reportVo,report);

        // 需要处理的属性 versionId; commitTime;   status;   deleteStatus;
        //逻辑判断   根据reportVo.getId()判断是否第一次提交，
        if (reportVo.getId() == null) {
            //为null则是首次提交
            System.out.println("report首次提交");
            report.setStatus(1);
            //首次提交时间
            report.setCommitTime(new Date());
            report.setVersionId(dbVersion.getId());
            report.setDeleteStatus((byte)0);
            return report;
        }
        if(reportVo.getId()!=null){    //否则视为已经提交过
            //获取数据库中完整的报告对象
            Report dbReport = reportMapper.selectByPrimaryKey(reportVo.getId());
           //设置报告对应的版本的id号
           report.setVersionId(dbVersion.getId());
           //将报告的status加1
           report.setStatus(dbReport.getStatus()+1);
           return report;
        }

        return null;

    }
}
