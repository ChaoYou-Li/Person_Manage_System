package cn.zdxh.personnelmanage.mapper;

import cn.zdxh.personnelmanage.po.FreeCharge;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 免搭伙费表 Mapper 接口
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 *
 * 继承了BaseMapper就可以做最基本的增删改查
 */
public interface FreeChargeMapper extends BaseMapper<FreeCharge> {
    public List<FreeCharge> findAllFreeChargeBySearch(String param);
}
