package cn.zdxh.personnelmanage.service;

import cn.zdxh.personnelmanage.po.InductionInfo;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 就职情况表 服务类
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
public interface InductionInfoService extends IService<InductionInfo> {
    //分页查询所有员工
    public List<InductionInfo> findInductionInfoAll(int current, int size);
    //查询总共有多少条的数据
    public Integer findInductionInfoAllCount();
    //增加员工信息
    public void insertInductionInfo(InductionInfo employeeInfo);
    //修改员工信息
    public void updateInductionInfo(InductionInfo employeeInfo);
    //查询某个员工信息
    public InductionInfo findInductionInfo(Integer id);
    //删除员工
    public void deleteInductionInfo(Integer id);
    //模糊搜索
    public List<InductionInfo> findAllInductionInfoBySearch(String content);
}
