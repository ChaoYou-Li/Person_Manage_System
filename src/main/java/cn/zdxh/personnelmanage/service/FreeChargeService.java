package cn.zdxh.personnelmanage.service;

import cn.zdxh.personnelmanage.po.FreeCharge;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 免搭伙费表 服务类
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
public interface FreeChargeService extends IService<FreeCharge> {
    //分页查询所有员工
    public List<FreeCharge> findFreeChargeAll(int current, int size);
    //查询总共有多少条的数据
    public Integer findFreeChargeAllCount();
    //增加员工信息
    public void insertFreeCharge(FreeCharge employeeInfo);
    //修改员工信息
    public void updateFreeCharge(FreeCharge employeeInfo);
    //查询某个员工信息
    public FreeCharge findFreeCharge(Integer id);
    //删除员工
    public void deleteFreeCharge(Integer id);
    //模糊搜索
    public List<FreeCharge> findAllFreeChargeBySearch(String content);
}
