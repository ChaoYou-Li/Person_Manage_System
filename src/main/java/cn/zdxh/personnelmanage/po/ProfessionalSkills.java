package cn.zdxh.personnelmanage.po;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 员工相关专业技能证书档案表
 *
 * @author Justin
 * @since 2019-03-15
 */
public class ProfessionalSkills implements Serializable {

    private static final long serialVersionUID = 220970762127227150L;
    /**
     * 自增主键
     */
    @TableId(value = "ps_id", type = IdType.AUTO)
    private Integer psId;
    /**
     * 专业技能
     */
    private String psInfo;
    /**
     * 技能级别
     */
    private String psLevel;
    /**
     * 证书发证日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date psIssueTime;
    /**
     * 证书号
     */
    private String psNumber;
    /**
     * 员工外键
     */
    private Integer empId;


    public Integer getPsId() {
        return psId;
    }

    public void setPsId(Integer psId) {
        this.psId = psId;
    }

    public String getPsInfo() {
        return psInfo;
    }

    public void setPsInfo(String psInfo) {
        this.psInfo = psInfo;
    }

    public String getPsLevel() {
        return psLevel;
    }

    public void setPsLevel(String psLevel) {
        this.psLevel = psLevel;
    }

    public Date getPsIssueTime() {
        return psIssueTime;
    }

    public void setPsIssueTime(Date psIssueTime) {
        this.psIssueTime = psIssueTime;
    }

    public String getPsNumber() {
        return psNumber;
    }

    public void setPsNumber(String psNumber) {
        this.psNumber = psNumber;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "ProfessionalSkills{" +
        ", psId=" + psId +
        ", psInfo=" + psInfo +
        ", psLevel=" + psLevel +
        ", psIssueTime=" + psIssueTime +
        ", psNumber=" + psNumber +
        ", empId=" + empId +
        "}";
    }
}
