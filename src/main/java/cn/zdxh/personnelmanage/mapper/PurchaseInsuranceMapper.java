package cn.zdxh.personnelmanage.mapper;

import cn.zdxh.personnelmanage.po.PurchaseInsurance;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 购保情况表 Mapper 接口
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 *
 * 继承了BaseMapper就可以做最基本的增删改查
 */
public interface PurchaseInsuranceMapper extends BaseMapper<PurchaseInsurance> {
    public List<PurchaseInsurance> findAllPurchaseInsuranceBySearch(String param);
}
