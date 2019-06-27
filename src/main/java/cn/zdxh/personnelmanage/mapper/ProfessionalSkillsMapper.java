package cn.zdxh.personnelmanage.mapper;

import cn.zdxh.personnelmanage.po.ProfessionalSkills;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 员工相关专业技能证书档案表 Mapper 接口
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 *
 * 继承了BaseMapper就可以做最基本的增删改查
 */
public interface ProfessionalSkillsMapper extends BaseMapper<ProfessionalSkills> {
    public List<ProfessionalSkills> findAllProfessionalSkillsBySearch(String param);
}
