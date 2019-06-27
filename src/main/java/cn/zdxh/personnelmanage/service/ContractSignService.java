package cn.zdxh.personnelmanage.service;

import cn.zdxh.personnelmanage.po.ContractSign;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 合同签订情况表 服务类
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
public interface ContractSignService extends IService<ContractSign> {
    //分页查询所有员工
    public List<ContractSign> findContractSignAll(int current, int size);
    //查询总共有多少条的数据
    public Integer findContractSignAllCount();
    //增加员工信息
    public void insertContractSign(ContractSign employeeInfo);
    //修改员工信息
    public void updateContractSign(ContractSign employeeInfo);
    //查询某个员工信息
    public ContractSign findContractSign(Integer id);
    //删除员工
    public void deleteContractSign(Integer id);
    //模糊搜索
    public List<ContractSign> findAllContractSignBySearch(String content);
}
