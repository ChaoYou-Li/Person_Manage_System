package cn.zdxh.personnelmanage.service;

import cn.zdxh.personnelmanage.mapper.BirthdayRecordMapper;
import cn.zdxh.personnelmanage.po.BirthdayRecord;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * 生育纪录表 服务类
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
public interface BirthdayRecordService extends IService<BirthdayRecord> {
    //分页查询所有员工
    public List<BirthdayRecord> findBirthdayRecordAll(int current, int size);
    //查询总共有多少条的数据
    public Integer findBirthdayRecordAllCount();
    //增加员工信息
    public void insertBirthdayRecord(BirthdayRecord employeeInfo);
    //修改员工信息
    public void updateBirthdayRecord(BirthdayRecord employeeInfo);
    //查询某个员工信息
    public BirthdayRecord findBirthdayRecord(Integer id);
    //删除员工
    public void deleteBirthdayRecord(Integer id);
    //模糊搜索
    public List<BirthdayRecord> findAllBirthdayRecordBySearch(String content);
}
