package cn.zdxh.personnelmanage.service;

import cn.zdxh.personnelmanage.po.PurchaseInsurance;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 购保情况表 服务类
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
public interface PurchaseInsuranceService extends IService<PurchaseInsurance> {
    //分页查询所有员工
    public List<PurchaseInsurance> findAllPurchaseInsurance(int current, int size);
    //查询总共有多少条的数据
    public Integer findPurchaseInsuranceAllCount();
    //增加员工信息
    public void insertPurchaseInsurance(PurchaseInsurance employeeInfo);
    //修改员工信息
    public void updatePurchaseInsurance(PurchaseInsurance employeeInfo);
    //查询某个员工信息
    public PurchaseInsurance findPurchaseInsurance(Integer id);
    //删除员工
    public void deletePurchaseInsurance(Integer id);
    //模糊搜索
    public List<PurchaseInsurance> findAllPurchaseInsuranceBySearch(String content);
}
