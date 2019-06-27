package cn.zdxh.personnelmanage.service.impl;

import cn.zdxh.personnelmanage.po.InductionInfo;
import cn.zdxh.personnelmanage.mapper.InductionInfoMapper;
import cn.zdxh.personnelmanage.service.InductionInfoService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 就职情况表 服务实现类
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
@Service
public class InductionInfoServiceImpl extends ServiceImpl<InductionInfoMapper, InductionInfo> implements InductionInfoService {
    @Autowired
    InductionInfoMapper inductionInfoMapper;

    @Override
    public List<InductionInfo> findInductionInfoAll(int current, int size) {
        return inductionInfoMapper.selectPage(new Page<>(current, size), null);
    }

    @Override
    public Integer findInductionInfoAllCount() {
        return inductionInfoMapper.selectCount(null);
    }

    @Override
    public void insertInductionInfo(InductionInfo employeeInfo) {
        inductionInfoMapper.insert(employeeInfo);
    }

    @Override
    public void updateInductionInfo(InductionInfo employeeInfo) {
        inductionInfoMapper.updateById(employeeInfo);
    }

    @Override
    public InductionInfo findInductionInfo(Integer id) {
        return inductionInfoMapper.selectById(id);
    }

    @Override
    public void deleteInductionInfo(Integer id) {
        inductionInfoMapper.deleteById(id);
    }

    @Override
    public List<InductionInfo> findAllInductionInfoBySearch(String content) {
        String param = "%"+content+"%";
        return inductionInfoMapper.findAllInductionInfoBySearch(param);
    }
}
