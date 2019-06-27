package cn.zdxh.personnelmanage.service.impl;

import cn.zdxh.personnelmanage.mapper.AdminMapper;
import cn.zdxh.personnelmanage.po.Admin;
import cn.zdxh.personnelmanage.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 管理员表 服务实现类
 * </p>
 *
 * @author Justin
 * @since 2019-03-23
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin findAdmin(Admin admin) {
        Admin adminResult = adminMapper.findAdmin(admin);
        return adminResult;
    }

    @Override
    public Integer insertAdmin(Admin admin) {
        Integer result = adminMapper.insert(admin);
        return result;
    }

    @Override
    public List<Admin> findAllAdmins() {
        List<Admin> allAdmins = adminMapper.findAllAdmins();
        return allAdmins;
    }
}
