package cn.zdxh.personnelmanage.service.impl;

import cn.zdxh.personnelmanage.po.EmployeeCard;
import cn.zdxh.personnelmanage.mapper.EmployeeCardMapper;
import cn.zdxh.personnelmanage.service.EmployeeCardService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 工作证办理情况表 服务实现类
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
@Service
public class EmployeeCardServiceImpl extends ServiceImpl<EmployeeCardMapper, EmployeeCard> implements EmployeeCardService {
    @Autowired
    EmployeeCardMapper employeeCardMapper;

    @Override
    public List<EmployeeCard> findEmployeeCardAll(int current, int size) {
        List<EmployeeCard> list = employeeCardMapper.selectPage(new Page<>(current, size), null);
        return list;
    }

    @Override
    public Integer findEmployeeCardAllCount() {
        return employeeCardMapper.selectCount(null);
    }

    @Override
    public void insertEmployeeCard(EmployeeCard employeeInfo) {
        employeeCardMapper.insert(employeeInfo);
    }

    @Override
    public void updateEmployeeCard(EmployeeCard employeeInfo) {
        employeeCardMapper.updateById(employeeInfo);
    }

    @Override
    public EmployeeCard findEmployeeCard(Integer id) {
        return employeeCardMapper.selectById(id);
    }

    @Override
    public void deleteEmployeeCard(Integer id) {
        employeeCardMapper.deleteById(id);
    }

    @Override
    public List<EmployeeCard> findAllEmployeeCardBySearch(String content) {
        return employeeCardMapper.findAllEmployeeCardBySearch(content);
    }
}
