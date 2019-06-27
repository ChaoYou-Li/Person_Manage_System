package cn.zdxh.personnelmanage.po;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 证件情况表
 *
 * @author Justin
 * @since 2019-03-15
 */
public class CertificatesInfo implements Serializable {

    private static final long serialVersionUID = 5034747281585900542L;
    /**
     * 自增主键
     */
    @TableId(value = "cer_id", type = IdType.AUTO)
    private Integer cerId;
    /**
     * 健康证办理时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date healStartTime;
    /**
     * 健康证到期时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date healEndTime;
    /**
     * 健康证机构
     */
    private String healOrganize;
    /**
     * 健康证是否持有原件 1只有 0没有
     */
    private Integer healHave;
    /**
     * 计生证编号
     */
    private Integer fpNumber;
    /**
     * 计生证户籍地
     */
    private String fpHousehold;
    /**
     * 计生证避孕措施
     */
    private String fpStep;
    /**
     * 计生证居住地
     */
    private String fpPlace;
    /**
     * 计生部门电话
     */
    private String fpPhone;
    /**
     * 计生证有效时间
     */
    private String fpValidTime;
    /**
     * 标记是健康证还是计生证 1健康 2计生
     */
    private Integer cerSign;
    /**
     * 员工外键
     */
    private Integer empId;


    public Integer getCerId() {
        return cerId;
    }

    public void setCerId(Integer cerId) {
        this.cerId = cerId;
    }

    public Date getHealStartTime() {
        return healStartTime;
    }

    public void setHealStartTime(Date healStartTime) {
        this.healStartTime = healStartTime;
    }

    public Date getHealEndTime() {
        return healEndTime;
    }

    public void setHealEndTime(Date healEndTime) {
        this.healEndTime = healEndTime;
    }

    public String getHealOrganize() {
        return healOrganize;
    }

    public void setHealOrganize(String healOrganize) {
        this.healOrganize = healOrganize;
    }

    public Integer getHealHave() {
        return healHave;
    }

    public void setHealHave(Integer healHave) {
        this.healHave = healHave;
    }

    public Integer getFpNumber() {
        return fpNumber;
    }

    public void setFpNumber(Integer fpNumber) {
        this.fpNumber = fpNumber;
    }

    public String getFpHousehold() {
        return fpHousehold;
    }

    public void setFpHousehold(String fpHousehold) {
        this.fpHousehold = fpHousehold;
    }

    public String getFpStep() {
        return fpStep;
    }

    public void setFpStep(String fpStep) {
        this.fpStep = fpStep;
    }

    public String getFpPlace() {
        return fpPlace;
    }

    public void setFpPlace(String fpPlace) {
        this.fpPlace = fpPlace;
    }

    public String getFpPhone() {
        return fpPhone;
    }

    public void setFpPhone(String fpPhone) {
        this.fpPhone = fpPhone;
    }

    public String getFpValidTime() {
        return fpValidTime;
    }

    public void setFpValidTime(String fpValidTime) {
        this.fpValidTime = fpValidTime;
    }

    public Integer getCerSign() {
        return cerSign;
    }

    public void setCerSign(Integer cerSign) {
        this.cerSign = cerSign;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "CertificatesInfo{" +
        ", cerId=" + cerId +
        ", healStartTime=" + healStartTime +
        ", healEndTime=" + healEndTime +
        ", healOrganize=" + healOrganize +
        ", healHave=" + healHave +
        ", fpNumber=" + fpNumber +
        ", fpHousehold=" + fpHousehold +
        ", fpStep=" + fpStep +
        ", fpPlace=" + fpPlace +
        ", fpPhone=" + fpPhone +
        ", fpValidTime=" + fpValidTime +
        ", cerSign=" + cerSign +
        ", empId=" + empId +
        "}";
    }
}
