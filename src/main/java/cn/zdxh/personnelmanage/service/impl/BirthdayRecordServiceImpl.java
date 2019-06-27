package cn.zdxh.personnelmanage.service.impl;

import cn.zdxh.personnelmanage.enums.ResultEnum;
import cn.zdxh.personnelmanage.exception.MyException;
import cn.zdxh.personnelmanage.po.BirthdayRecord;
import cn.zdxh.personnelmanage.mapper.BirthdayRecordMapper;
import cn.zdxh.personnelmanage.service.BirthdayRecordService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 生育纪录表 服务实现类
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
@Service
public class BirthdayRecordServiceImpl extends ServiceImpl<BirthdayRecordMapper, BirthdayRecord> implements BirthdayRecordService {
    /**
     * 注入BirthdayRecordMapper 这个CRUD操作接口
     */
    @Autowired
    BirthdayRecordMapper birthdayRecordMapper;

    @Override
    public List<BirthdayRecord> findBirthdayRecordAll(int current, int size) {
        Page page = new Page(current, size);
        List<BirthdayRecord> list = birthdayRecordMapper.selectPage(page, null);
        return list;
    }

    @Override
    public Integer findBirthdayRecordAllCount() {
        int num = birthdayRecordMapper.selectCount(null);
        return num;
    }

    /**
     * 功能分析：对数据表进行插入操作
     *
     * @param birthdayRecord
     */
    @Override
    public void insertBirthdayRecord(BirthdayRecord birthdayRecord) {
        try {
            birthdayRecordMapper.insert(birthdayRecord);
        } catch (Exception e){
            throw new MyException(ResultEnum.INSERT_FAIL.getCode(),ResultEnum.INSERT_FAIL.getMsg());
        }

    }

    /**
     * 功能分析：先进行id查询数据表是否含有此记录，有则进行更新操作
     *
     * @param birthdayRecord
     */
    @Override
    public void updateBirthdayRecord(BirthdayRecord birthdayRecord) {
        BirthdayRecord birthdayRecord1 = birthdayRecordMapper.selectById(birthdayRecord.getBirId());
        if (birthdayRecord1 == null){
            throw new MyException(ResultEnum.UPDATE_ERROR.getCode(),ResultEnum.UPDATE_ERROR.getMsg());
        }
        birthdayRecordMapper.updateById(birthdayRecord);
    }

    /**
     * 功能分析：根据id查询数据表操作
     * @param id
     * @return
     */
    @Override
    public BirthdayRecord findBirthdayRecord(Integer id) {
        BirthdayRecord birthdayRecord = birthdayRecordMapper.selectById(id);
        if (birthdayRecord == null){
            throw new MyException(ResultEnum.SELECT_ERROR.getCode(), ResultEnum.SELECT_ERROR.getMsg());
        }
        return birthdayRecord;
    }

    @Override
    public void deleteBirthdayRecord(Integer id) {
        try {
            birthdayRecordMapper.deleteById(id);
        } catch (Exception e){
            throw new MyException(ResultEnum.DELETE_ERROR.getCode(), ResultEnum.DELETE_ERROR.getMsg());
        }

    }

    @Override
    public List<BirthdayRecord> findAllBirthdayRecordBySearch(String content) {
        List<BirthdayRecord> list = null;
        String param = "%"+content+"%";
        if (content.matches("[0-9]{1,}")){
            System.out.println("全数字时");
            list = birthdayRecordMapper.findAllBirthdayRecord(param);//查询的条件为全数字时
        } else {
            System.out.println("非全数字时");
            list = birthdayRecordMapper.findAllBirthdayRecordBySearch(param);//查询条件含有文字或其他字符时
        }
        return list;
    }
}
