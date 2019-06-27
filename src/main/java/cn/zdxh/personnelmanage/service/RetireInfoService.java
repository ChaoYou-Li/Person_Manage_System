package cn.zdxh.personnelmanage.service;

import cn.zdxh.personnelmanage.po.RetireInfo;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 退休人员信息表 服务类
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
public interface RetireInfoService extends IService<RetireInfo> {
    //分页查询所有员工
    public List<RetireInfo> findAllRetireInfo(int current, int size);
    //查询总共有多少条的数据
    public Integer findRetireInfoAllCount();
    //增加员工信息
    public void insertRetireInfo(RetireInfo employeeInfo);
    //修改员工信息
    public void updateRetireInfo(RetireInfo employeeInfo);
    //查询某个员工信息
    public RetireInfo findRetireInfo(Integer id);
    //删除员工
    public void deleteRetireInfo(Integer id);
    //模糊搜索
    public List<RetireInfo> findAllRetireInfoBySearch(String content);
}
