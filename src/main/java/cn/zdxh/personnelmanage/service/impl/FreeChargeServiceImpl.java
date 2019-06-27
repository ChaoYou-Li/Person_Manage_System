package cn.zdxh.personnelmanage.service.impl;

import cn.zdxh.personnelmanage.po.FreeCharge;
import cn.zdxh.personnelmanage.mapper.FreeChargeMapper;
import cn.zdxh.personnelmanage.service.FreeChargeService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 免搭伙费表 服务实现类
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
@Service
public class FreeChargeServiceImpl extends ServiceImpl<FreeChargeMapper, FreeCharge> implements FreeChargeService {
    @Autowired
    FreeChargeMapper freeChargeMapper;

    @Override
    public List<FreeCharge> findFreeChargeAll(int current, int size) {
        return freeChargeMapper.selectPage(new Page<>(current, size), null);
    }

    @Override
    public Integer findFreeChargeAllCount() {
        return freeChargeMapper.selectCount(null);
    }

    @Override
    public void insertFreeCharge(FreeCharge employeeInfo) {
        freeChargeMapper.insert(employeeInfo);
    }

    @Override
    public void updateFreeCharge(FreeCharge employeeInfo) {
        freeChargeMapper.updateById(employeeInfo);
    }

    @Override
    public FreeCharge findFreeCharge(Integer id) {
        return freeChargeMapper.selectById(id);
    }

    @Override
    public void deleteFreeCharge(Integer id) {
        freeChargeMapper.deleteById(id);
    }

    @Override
    public List<FreeCharge> findAllFreeChargeBySearch(String content) {
        String param = "%"+content+"%";
        return freeChargeMapper.findAllFreeChargeBySearch(param);
    }
}
