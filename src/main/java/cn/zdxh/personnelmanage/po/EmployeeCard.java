package cn.zdxh.personnelmanage.po;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 工作证办理情况表
 *
 * @author Justin
 * @since 2019-03-15
 */
public class EmployeeCard implements Serializable {

    private static final long serialVersionUID = -8724364787742512341L;
    /**
     * 自增主键
     */
    @TableId(value = "es_id", type = IdType.AUTO)
    private Integer esId;
    /**
     * 工作证办理日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date esStartTime;
    /**
     * 工作证过期时间（需要设置提醒）
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date esEndTime;
    /**
     * 员工外键
     */
    private Integer empId;


    public Integer getEsId() {
        return esId;
    }

    public void setEsId(Integer esId) {
        this.esId = esId;
    }

    public Date getEsStartTime() {
        return esStartTime;
    }

    public void setEsStartTime(Date esStartTime) {
        this.esStartTime = esStartTime;
    }

    public Date getEsEndTime() {
        return esEndTime;
    }

    public void setEsEndTime(Date esEndTime) {
        this.esEndTime = esEndTime;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "EmployeeCard{" +
        ", esId=" + esId +
        ", esStartTime=" + esStartTime +
        ", esEndTime=" + esEndTime +
        ", empId=" + empId +
        "}";
    }
}
