package cn.zdxh.personnelmanage.service.impl;

import cn.zdxh.personnelmanage.po.RetireInfo;
import cn.zdxh.personnelmanage.mapper.RetireInfoMapper;
import cn.zdxh.personnelmanage.service.RetireInfoService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 退休人员信息表 服务实现类
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
@Service
public class RetireInfoServiceImpl extends ServiceImpl<RetireInfoMapper, RetireInfo> implements RetireInfoService {
    @Autowired
    RetireInfoMapper retireInfoMapper;

    @Override
    public List<RetireInfo> findAllRetireInfo(int current, int size) {
        return retireInfoMapper.selectPage(new Page<>(current, size), null);
    }

    @Override
    public Integer findRetireInfoAllCount() {
        return retireInfoMapper.selectCount(null);
    }

    @Override
    public void insertRetireInfo(RetireInfo employeeInfo) {
        retireInfoMapper.insert(employeeInfo);
    }

    @Override
    public void updateRetireInfo(RetireInfo employeeInfo) {
        retireInfoMapper.updateById(employeeInfo);
    }

    @Override
    public RetireInfo findRetireInfo(Integer id) {
        return retireInfoMapper.selectById(id);
    }

    @Override
    public void deleteRetireInfo(Integer id) {
        retireInfoMapper.deleteById(id);
    }

    @Override
    public List<RetireInfo> findAllRetireInfoBySearch(String content) {
        String param = "%"+content+"%";
        return retireInfoMapper.findAllRetireInfoBySearch(param);
    }
}
