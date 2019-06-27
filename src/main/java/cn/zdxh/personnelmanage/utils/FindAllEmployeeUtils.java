package cn.zdxh.personnelmanage.utils;

import cn.zdxh.personnelmanage.po.EmployeeInfo;
import cn.zdxh.personnelmanage.service.EmployeeInfoService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FindAllEmployeeUtils {

    @Autowired
    private EmployeeInfoService employeeInfoService;

    /**
     * 提供一个查询所有员工信息的方法
     */
    public List<EmployeeInfo> findAllEmployees(){
        List<EmployeeInfo> allEmployees = employeeInfoService.selectList(null);
        return allEmployees;
    }


    /**
     * 提供一个通过Id 查询员工的方法
     */
    public EmployeeInfo findEmployeeById(Integer id){
        return employeeInfoService.findEmployee(id);
    }



}
