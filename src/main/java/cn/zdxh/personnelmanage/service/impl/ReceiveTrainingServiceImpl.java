package cn.zdxh.personnelmanage.service.impl;

import cn.zdxh.personnelmanage.po.ReceiveTraining;
import cn.zdxh.personnelmanage.mapper.ReceiveTrainingMapper;
import cn.zdxh.personnelmanage.service.ReceiveTrainingService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 接受过培训表 服务实现类
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
@Service
public class ReceiveTrainingServiceImpl extends ServiceImpl<ReceiveTrainingMapper, ReceiveTraining> implements ReceiveTrainingService {
    @Autowired
    ReceiveTrainingMapper receiveTrainingMapper;

    @Override
    public List<ReceiveTraining> findAllReceiveTraining(int current, int size) {
        return receiveTrainingMapper.selectPage(new Page<>(current, size), null);
    }

    @Override
    public Integer findReceiveTrainingAllCount() {
        return receiveTrainingMapper.selectCount(null);
    }

    @Override
    public void insertReceiveTraining(ReceiveTraining employeeInfo) {
        receiveTrainingMapper.insert(employeeInfo);
    }

    @Override
    public void updateReceiveTraining(ReceiveTraining employeeInfo) {
        receiveTrainingMapper.updateById(employeeInfo);
    }

    @Override
    public ReceiveTraining findReceiveTraining(Integer id) {
        return receiveTrainingMapper.selectById(id);
    }

    @Override
    public void deleteReceiveTraining(Integer id) {
        receiveTrainingMapper.deleteById(id);
    }

    @Override
    public List<ReceiveTraining> findAllReceiveTrainingBySearch(String content) {
        String param = "%"+content+"%";
        return receiveTrainingMapper.findAllReceiveTrainingBySearch(param);
    }
}
