package cn.zdxh.personnelmanage.mapper;

import cn.zdxh.personnelmanage.po.ReceiveTraining;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 接受过培训表 Mapper 接口
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 *
 * 继承了BaseMapper就可以做最基本的增删改查
 */
public interface ReceiveTrainingMapper extends BaseMapper<ReceiveTraining> {
    public List<ReceiveTraining> findAllReceiveTrainingBySearch(String param);
}
