package cn.zdxh.personnelmanage.service;

import cn.zdxh.personnelmanage.po.CertificatesInfo;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 证件情况表 服务类
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
public interface CertificatesInfoService extends IService<CertificatesInfo> {
    //分页查询所有员工
    public List<CertificatesInfo> findCertificatesInfoAll(int current, int size);
    //查询总共有多少条的数据
    public Integer findCertificatesInfoAllCount();
    //增加员工信息
    public void insertCertificatesInfo(CertificatesInfo employeeInfo);
    //修改员工信息
    public void updateCertificatesInfo(CertificatesInfo employeeInfo);
    //查询某个员工信息
    public CertificatesInfo findCertificatesInfo(Integer id);
    //删除员工
    public void deleteCertificatesInfo(Integer id);
    //模糊搜索
    public List<CertificatesInfo> findAllCertificatesInfoBySearch(String content);

}
