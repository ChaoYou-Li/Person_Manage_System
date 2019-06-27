package cn.zdxh.personnelmanage.mapper;

import cn.zdxh.personnelmanage.po.EmployeeInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 员工信息表 Mapper 接口
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 *
 * 继承了BaseMapper就可以做最基本的增删改查
 */
public interface EmployeeInfoMapper extends BaseMapper<EmployeeInfo> {

    /**
     * 新增一个模糊查询的方法
     */
    public List<EmployeeInfo> findAllEmployeeInfosBySearch(String content);

}
