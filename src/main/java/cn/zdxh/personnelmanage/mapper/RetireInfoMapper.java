package cn.zdxh.personnelmanage.mapper;

import cn.zdxh.personnelmanage.po.RetireInfo;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 退休人员信息表 Mapper 接口
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
public interface RetireInfoMapper extends BaseMapper<RetireInfo> {
    public List<RetireInfo> findAllRetireInfoBySearch(String param);
}
