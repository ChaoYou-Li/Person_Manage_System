package cn.zdxh.personnelmanage.mapper;

import cn.zdxh.personnelmanage.po.ContractSign;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 合同签订情况表 Mapper 接口
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 *
 * 继承了BaseMapper就可以做最基本的增删改查
 */
public interface ContractSignMapper extends BaseMapper<ContractSign> {
    public List<ContractSign> findAllContractSignBySearch(String param);
}
