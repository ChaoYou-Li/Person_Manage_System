package cn.zdxh.personnelmanage.service;

import cn.zdxh.personnelmanage.po.ReceiveTraining;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 接受过培训表 服务类
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
public interface ReceiveTrainingService extends IService<ReceiveTraining> {
    //分页查询所有员工
    public List<ReceiveTraining> findAllReceiveTraining(int current, int size);
    //查询总共有多少条的数据
    public Integer findReceiveTrainingAllCount();
    //增加员工信息
    public void insertReceiveTraining(ReceiveTraining employeeInfo);
    //修改员工信息
    public void updateReceiveTraining(ReceiveTraining employeeInfo);
    //查询某个员工信息
    public ReceiveTraining findReceiveTraining(Integer id);
    //删除员工
    public void deleteReceiveTraining(Integer id);
    //模糊搜索
    public List<ReceiveTraining> findAllReceiveTrainingBySearch(String content);
}
