package cn.zdxh.personnelmanage.service;

import cn.zdxh.personnelmanage.po.ProfessionalSkills;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 员工相关专业技能证书档案表 服务类
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
public interface ProfessionalSkillsService extends IService<ProfessionalSkills> {
    //分页查询所有员工
    public List<ProfessionalSkills> findProfessionalSkillsAll(int current, int size);
    //查询总共有多少条的数据
    public Integer findProfessionalSkillsAllCount();
    //增加员工信息
    public void insertProfessionalSkills(ProfessionalSkills employeeInfo);
    //修改员工信息
    public void updateProfessionalSkills(ProfessionalSkills employeeInfo);
    //查询某个员工信息
    public ProfessionalSkills findProfessionalSkills(Integer id);
    //删除员工
    public void deleteProfessionalSkills(Integer id);
    //模糊搜索
    public List<ProfessionalSkills> findAllProfessionalSkillsBySearch(String content);
}
