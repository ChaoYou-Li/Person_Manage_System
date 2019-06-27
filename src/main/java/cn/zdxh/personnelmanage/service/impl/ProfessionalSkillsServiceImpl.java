package cn.zdxh.personnelmanage.service.impl;

import cn.zdxh.personnelmanage.po.ProfessionalSkills;
import cn.zdxh.personnelmanage.mapper.ProfessionalSkillsMapper;
import cn.zdxh.personnelmanage.service.ProfessionalSkillsService;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 员工相关专业技能证书档案表 服务实现类
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
@Service
public class ProfessionalSkillsServiceImpl extends ServiceImpl<ProfessionalSkillsMapper, ProfessionalSkills> implements ProfessionalSkillsService {
    @Autowired
    ProfessionalSkillsMapper professionalSkillsMapper;

    @Override
    public List<ProfessionalSkills> findProfessionalSkillsAll(int current, int size) {
        return professionalSkillsMapper.selectPage(new Page<>(current, size), null);
    }

    @Override
    public Integer findProfessionalSkillsAllCount() {
        return professionalSkillsMapper.selectCount(null);
    }

    @Override
    public void insertProfessionalSkills(ProfessionalSkills employeeInfo) {
        professionalSkillsMapper.insert(employeeInfo);
    }

    @Override
    public void updateProfessionalSkills(ProfessionalSkills employeeInfo) {
        professionalSkillsMapper.updateById(employeeInfo);
    }

    @Override
    public ProfessionalSkills findProfessionalSkills(Integer id) {
        return professionalSkillsMapper.selectById(id);
    }

    @Override
    public void deleteProfessionalSkills(Integer id) {
        professionalSkillsMapper.deleteById(id);
    }

    @Override
    public List<ProfessionalSkills> findAllProfessionalSkillsBySearch(String content) {
        String param = "%"+content+"%";
        return professionalSkillsMapper.findAllProfessionalSkillsBySearch(param);
    }
}
