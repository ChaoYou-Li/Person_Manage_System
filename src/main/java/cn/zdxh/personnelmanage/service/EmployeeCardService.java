package cn.zdxh.personnelmanage.service;

import cn.zdxh.personnelmanage.po.EmployeeCard;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 工作证办理情况表 服务类
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
public interface EmployeeCardService extends IService<EmployeeCard> {
    //分页查询所有员工
    public List<EmployeeCard> findEmployeeCardAll(int current, int size);
    //查询总共有多少条的数据
    public Integer findEmployeeCardAllCount();
    //增加员工信息
    public void insertEmployeeCard(EmployeeCard employeeInfo);
    //修改员工信息
    public void updateEmployeeCard(EmployeeCard employeeInfo);
    //查询某个员工信息
    public EmployeeCard findEmployeeCard(Integer id);
    //删除员工
    public void deleteEmployeeCard(Integer id);
    //模糊搜索
    public List<EmployeeCard> findAllEmployeeCardBySearch(String content);
}
