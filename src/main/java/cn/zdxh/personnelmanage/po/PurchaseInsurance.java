package cn.zdxh.personnelmanage.po;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 购保情况表
 *
 * @author Justin
 * @since 2019-03-15
 */
public class PurchaseInsurance implements Serializable {

    private static final long serialVersionUID = 2107453698536023633L;
    /**
     * 自增主键
     */
    @TableId(value = "pur_id", type = IdType.AUTO)
    private Integer purId;
    /**
     * 购保时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date purStartTime;
    /**
     * 停保时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date purEndTime;
    /**
     * 个人电脑号
     */
    private String purComputer;
    /**
     * 员工外键
     */
    private Integer empId;


    public Integer getPurId() {
        return purId;
    }

    public void setPurId(Integer purId) {
        this.purId = purId;
    }

    public Date getPurStartTime() {
        return purStartTime;
    }

    public void setPurStartTime(Date purStartTime) {
        this.purStartTime = purStartTime;
    }

    public Date getPurEndTime() {
        return purEndTime;
    }

    public void setPurEndTime(Date purEndTime) {
        this.purEndTime = purEndTime;
    }

    public String getPurComputer() {
        return purComputer;
    }

    public void setPurComputer(String purComputer) {
        this.purComputer = purComputer;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "PurchaseInsurance{" +
        ", purId=" + purId +
        ", purStartTime=" + purStartTime +
        ", purEndTime=" + purEndTime +
        ", purComputer=" + purComputer +
        ", empId=" + empId +
        "}";
    }
}
