package cn.zdxh.personnelmanage.mapper;

import cn.zdxh.personnelmanage.po.Admin;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 管理员表 Mapper 接口
 * </p>
 *
 * @author Justin
 * @since 2019-03-23
 *
 * 继承了BaseMapper就可以做最基本的增删改查
 */
public interface AdminMapper extends BaseMapper<Admin> {
    /**
     * 此方法是手动增加的方法，具体的操作见AdminMapper.xml
     * 当然，也可以利用条件构造器EntityWrapper直接构造条件
     */

    public Admin findAdmin(Admin admin);

    public List<Admin> findAllAdmins();
}
