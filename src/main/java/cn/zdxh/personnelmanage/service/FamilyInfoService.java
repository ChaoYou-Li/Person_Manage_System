package cn.zdxh.personnelmanage.service;

import cn.zdxh.personnelmanage.po.FamilyInfo;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 家庭情况表 服务类
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
public interface FamilyInfoService extends IService<FamilyInfo> {
    //分页查询所有员工
    public List<FamilyInfo> findFamilyInfoAll(int current, int size);
    //查询总共有多少条的数据
    public Integer findFamilyInfoAllCount();
    //增加员工信息
    public void insertFamilyInfo(FamilyInfo employeeInfo);
    //修改员工信息
    public void updateFamilyInfo(FamilyInfo employeeInfo);
    //查询某个员工信息
    public FamilyInfo findFamilyInfo(Integer id);
    //删除员工
    public void deleteFamilyInfo(Integer id);
    //模糊搜索
    public List<FamilyInfo> findAllFamilyInfoBySearch(String content);
}
