package cn.zdxh.personnelmanage.service.impl;

import cn.zdxh.personnelmanage.po.FamilyInfo;
import cn.zdxh.personnelmanage.mapper.FamilyInfoMapper;
import cn.zdxh.personnelmanage.service.FamilyInfoService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 家庭情况表 服务实现类
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
@Service
public class FamilyInfoServiceImpl extends ServiceImpl<FamilyInfoMapper, FamilyInfo> implements FamilyInfoService {
    @Autowired
    FamilyInfoMapper familyInfoMapper;

    @Override
    public List<FamilyInfo> findFamilyInfoAll(int current, int size) {
        return familyInfoMapper.selectPage(new Page<>(current, size), null);
    }

    @Override
    public Integer findFamilyInfoAllCount() {
        return familyInfoMapper.selectCount(null);
    }

    @Override
    public void insertFamilyInfo(FamilyInfo employeeInfo) {
        familyInfoMapper.insert(employeeInfo);
    }

    @Override
    public void updateFamilyInfo(FamilyInfo employeeInfo) {
        familyInfoMapper.updateById(employeeInfo);
    }

    @Override
    public FamilyInfo findFamilyInfo(Integer id) {
        return familyInfoMapper.selectById(id);
    }

    @Override
    public void deleteFamilyInfo(Integer id) {
        familyInfoMapper.deleteById(id);
    }

    @Override
    public List<FamilyInfo> findAllFamilyInfoBySearch(String content) {
        String param = "%"+content+"%";
        return familyInfoMapper.findAllFamilyInfoBySearch(param);
    }
}
