package cn.zdxh.personnelmanage.service;

import cn.zdxh.personnelmanage.po.EmployeeInfo;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 员工信息表 服务类
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
public interface EmployeeInfoService extends IService<EmployeeInfo> {
    //分页查询所有员工
    public List<EmployeeInfo> findAllEmployees(int current, int size);
    //查询总共有多少条的数据
    public Integer findAllCount();
    //增加员工信息
    public void insertEmployee(EmployeeInfo employeeInfo);
    //修改员工信息
    public void updateEmployee(EmployeeInfo employeeInfo);
    //查询某个员工信息
    public EmployeeInfo findEmployee(Integer id);
    //删除员工
    public void deleteEmployee(Integer id);
    //模糊搜索
    public List<EmployeeInfo> findAllEmployeeInfosBySearch(String content);
}
