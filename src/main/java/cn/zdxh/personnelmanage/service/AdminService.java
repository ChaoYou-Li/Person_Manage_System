package cn.zdxh.personnelmanage.service;

import cn.zdxh.personnelmanage.po.Admin;

import java.util.List;

/**
 * <p>
 * 管理员表 服务接口
 * </p>
 *
 * @author Justin
 * @since 2019-03-23
 */
public interface AdminService {
    //登录，查询管理员
    public Admin findAdmin(Admin admin);
    //插入管理员
    public Integer insertAdmin(Admin admin);
    //查询所有的管理员，用于导出excel表
    public List<Admin> findAllAdmins();
}
