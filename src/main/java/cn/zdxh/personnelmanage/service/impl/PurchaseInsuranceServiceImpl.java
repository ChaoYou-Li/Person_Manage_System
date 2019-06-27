package cn.zdxh.personnelmanage.service.impl;

import cn.zdxh.personnelmanage.po.PurchaseInsurance;
import cn.zdxh.personnelmanage.mapper.PurchaseInsuranceMapper;
import cn.zdxh.personnelmanage.service.PurchaseInsuranceService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 购保情况表 服务实现类
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
@Service
public class PurchaseInsuranceServiceImpl extends ServiceImpl<PurchaseInsuranceMapper, PurchaseInsurance> implements PurchaseInsuranceService {
    @Autowired
    PurchaseInsuranceMapper purchaseInsuranceMapper;

    @Override
    public List<PurchaseInsurance> findAllPurchaseInsurance(int current, int size) {
        return purchaseInsuranceMapper.selectPage(new Page<>(current, size), null);
    }

    @Override
    public Integer findPurchaseInsuranceAllCount() {
        return purchaseInsuranceMapper.selectCount(null);
    }

    @Override
    public void insertPurchaseInsurance(PurchaseInsurance employeeInfo) {
        purchaseInsuranceMapper.insert(employeeInfo);
    }

    @Override
    public void updatePurchaseInsurance(PurchaseInsurance employeeInfo) {
        purchaseInsuranceMapper.updateById(employeeInfo);
    }

    @Override
    public PurchaseInsurance findPurchaseInsurance(Integer id) {
        return purchaseInsuranceMapper.selectById(id);
    }

    @Override
    public void deletePurchaseInsurance(Integer id) {
        purchaseInsuranceMapper.deleteById(id);
    }

    @Override
    public List<PurchaseInsurance> findAllPurchaseInsuranceBySearch(String content) {
        String param = "%"+content+"%";
        return purchaseInsuranceMapper.findAllPurchaseInsuranceBySearch(param);
    }
}
