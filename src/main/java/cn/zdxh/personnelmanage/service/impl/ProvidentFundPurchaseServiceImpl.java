package cn.zdxh.personnelmanage.service.impl;

import cn.zdxh.personnelmanage.po.ProvidentFundPurchase;
import cn.zdxh.personnelmanage.mapper.ProvidentFundPurchaseMapper;
import cn.zdxh.personnelmanage.service.ProvidentFundPurchaseService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 公积金购买情况表 服务实现类
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
@Service
public class ProvidentFundPurchaseServiceImpl extends ServiceImpl<ProvidentFundPurchaseMapper, ProvidentFundPurchase> implements ProvidentFundPurchaseService {
    @Autowired
    ProvidentFundPurchaseMapper providentFundPurchaseMapper;

    @Override
    public List<ProvidentFundPurchase> findAllProvidentFundPurchase(int current, int size) {
        return providentFundPurchaseMapper.selectPage(new Page<>(current, size), null);
    }

    @Override
    public Integer findProvidentFundPurchaseAllCount() {
        return providentFundPurchaseMapper.selectCount(null);
    }

    @Override
    public void insertProvidentFundPurchase(ProvidentFundPurchase employeeInfo) {
        providentFundPurchaseMapper.insert(employeeInfo);
    }

    @Override
    public void updateProvidentFundPurchase(ProvidentFundPurchase employeeInfo) {
        providentFundPurchaseMapper.updateById(employeeInfo);
    }

    @Override
    public ProvidentFundPurchase findProvidentFundPurchase(Integer id) {
        return providentFundPurchaseMapper.selectById(id);
    }

    @Override
    public void deleteProvidentFundPurchase(Integer id) {
        providentFundPurchaseMapper.deleteById(id);
    }

    @Override
    public List<ProvidentFundPurchase> findAllProvidentFundPurchaseBySearch(String content) {
        return providentFundPurchaseMapper.findAllProvidentFundPurchaseBySearch(content);
    }
}
