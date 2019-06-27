package cn.zdxh.personnelmanage.service.impl;

import cn.zdxh.personnelmanage.enums.ResultEnum;
import cn.zdxh.personnelmanage.exception.MyException;
import cn.zdxh.personnelmanage.po.EmployeeInfo;
import cn.zdxh.personnelmanage.mapper.EmployeeInfoMapper;
import cn.zdxh.personnelmanage.service.EmployeeInfoService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 员工信息表 服务实现类
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
@Service
public class EmployeeInfoServiceImpl extends ServiceImpl<EmployeeInfoMapper, EmployeeInfo> implements EmployeeInfoService {

    @Autowired
    private EmployeeInfoMapper employeeInfoMapper;

    /**
     * 分页查询所有员工
     * @return
     */
    @Override
    public List<EmployeeInfo> findAllEmployees(int current, int size) {
        //page对象时分页对象，current是本页，size是每页显示的数量
        Page page = new Page<>(current, size);
        List<EmployeeInfo> employeeInfos = employeeInfoMapper.selectPage(page, null);
        return employeeInfos;
    }

    /**
     * 查询所有的数据总数
     * @return
     */
    @Override
    public Integer findAllCount() {
        Integer count = employeeInfoMapper.selectCount(null);
        return count;
    }

    /**
     * 增加员工信息
     * @param employeeInfo
     */

    @Override
    public void insertEmployee(EmployeeInfo employeeInfo) {
        employeeInfoMapper.insert(employeeInfo);
    }

    /**
     * 修改员工信息
     * @param employeeInfo
     */

    @Override
    public void updateEmployee(EmployeeInfo employeeInfo) {
        //先查询一次数据库有没有此员工，若没有则放弃修改，然后抛出异常
        EmployeeInfo employeeInfoResult = employeeInfoMapper.selectById(employeeInfo.getEmpId());
        if (employeeInfoResult == null){
            throw new MyException(ResultEnum.EMP_NOT_EXIST.getCode(),ResultEnum.EMP_NOT_EXIST.getMsg());
        }
        employeeInfoMapper.updateById(employeeInfo);
    }

    /**
     * 查询某个员工信息
     * @param id
     */

    @Override
    public EmployeeInfo findEmployee(Integer id) {
        return employeeInfoMapper.selectById(id);
    }

    /**
     * 删除员工
     * @param id
     */
    @Override
    public void deleteEmployee(Integer id) {
        //先查询一次数据库有没有此员工，若没有则放弃删除，然后抛出异常
        EmployeeInfo employeeInfoResult = employeeInfoMapper.selectById(id);
        if (employeeInfoResult == null){
            throw new MyException(ResultEnum.EMP_NOT_EXIST.getCode(),ResultEnum.EMP_NOT_EXIST.getMsg());
        }
        employeeInfoMapper.deleteById(id);
    }

    @Override
    public List<EmployeeInfo> findAllEmployeeInfosBySearch(String content) {
        String param = "%"+content+"%";
        return employeeInfoMapper.findAllEmployeeInfosBySearch(param);
    }
}
