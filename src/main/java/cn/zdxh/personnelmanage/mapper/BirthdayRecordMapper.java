package cn.zdxh.personnelmanage.mapper;

import cn.zdxh.personnelmanage.po.BirthdayRecord;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * 生育纪录表 Mapper 接口
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 *
 * 继承了BaseMapper就可以做最基本的增删改查
 */
public interface BirthdayRecordMapper extends BaseMapper<BirthdayRecord> {

    public List<BirthdayRecord> findAllBirthdayRecordBySearch(String parame);

    public List<BirthdayRecord> findAllBirthdayRecord(String parame);

}
