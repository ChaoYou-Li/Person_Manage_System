package cn.zdxh.personnelmanage.service.impl;

import cn.zdxh.personnelmanage.enums.ResultEnum;
import cn.zdxh.personnelmanage.exception.MyException;
import cn.zdxh.personnelmanage.po.BirthdayRecord;
import cn.zdxh.personnelmanage.po.ContractSign;
import cn.zdxh.personnelmanage.mapper.ContractSignMapper;
import cn.zdxh.personnelmanage.service.ContractSignService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 合同签订情况表 服务实现类
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
@Service
public class ContractSignServiceImpl extends ServiceImpl<ContractSignMapper, ContractSign> implements ContractSignService {
    @Autowired
    ContractSignMapper contractSignMapper;

    @Override
    public List<ContractSign> findContractSignAll(int current, int size) {
        List<ContractSign> list = contractSignMapper.selectPage(new Page<>(current, size), null);
        return list;
    }

    @Override
    public Integer findContractSignAllCount() {
        return contractSignMapper.selectCount(null);
    }

    @Override
    public void insertContractSign(ContractSign employeeInfo) {
        contractSignMapper.insert(employeeInfo);
    }

    @Override
    public void updateContractSign(ContractSign employeeInfo) {
        ContractSign birthdayRecord1 = contractSignMapper.selectById(employeeInfo.getConId());
        if (birthdayRecord1 == null){
            throw new MyException(ResultEnum.EMP_NOT_EXIST.getCode(),ResultEnum.EMP_NOT_EXIST.getMsg());
        }
        contractSignMapper.updateById(employeeInfo);
    }

    @Override
    public ContractSign findContractSign(Integer id) {
        ContractSign contractSign = contractSignMapper.selectById(id);
        return contractSign;
    }

    @Override
    public void deleteContractSign(Integer id) {
        contractSignMapper.deleteById(id);
    }

    @Override
    public List<ContractSign> findAllContractSignBySearch(String content) {
        String param = "%"+content+"%";
        return contractSignMapper.findAllContractSignBySearch(param);
    }
}
