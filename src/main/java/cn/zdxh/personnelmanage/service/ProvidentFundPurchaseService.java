package cn.zdxh.personnelmanage.service;

import cn.zdxh.personnelmanage.po.ProvidentFundPurchase;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 公积金购买情况表 服务类
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
public interface ProvidentFundPurchaseService extends IService<ProvidentFundPurchase> {
    //分页查询所有员工
    public List<ProvidentFundPurchase> findAllProvidentFundPurchase(int current, int size);
    //查询总共有多少条的数据
    public Integer findProvidentFundPurchaseAllCount();
    //增加员工信息
    public void insertProvidentFundPurchase(ProvidentFundPurchase employeeInfo);
    //修改员工信息
    public void updateProvidentFundPurchase(ProvidentFundPurchase employeeInfo);
    //查询某个员工信息
    public ProvidentFundPurchase findProvidentFundPurchase(Integer id);
    //删除员工
    public void deleteProvidentFundPurchase(Integer id);
    //模糊搜索
    public List<ProvidentFundPurchase> findAllProvidentFundPurchaseBySearch(String content);
}
