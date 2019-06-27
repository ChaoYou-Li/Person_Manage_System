package cn.zdxh.personnelmanage.po;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 就职情况表
 *
 * @author Justin
 * @since 2019-03-15
 */
public class InductionInfo implements Serializable {

    private static final long serialVersionUID = 4624253712535120120L;
    /**
     * 自增主键
     */
    @TableId(value = "ind_id", type = IdType.AUTO)
    private Integer indId;
    /**
     * 入职时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date indEntryTime;
    /**
     * 离职时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date indQuitTime;
    /**
     * 历史就职纪录
     */
    private String indEntryHistory;
    /**
     * 员工外键
     */
    private Integer empId;


    public Integer getIndId() {
        return indId;
    }

    public void setIndId(Integer indId) {
        this.indId = indId;
    }

    public Date getIndEntryTime() {
        return indEntryTime;
    }

    public void setIndEntryTime(Date indEntryTime) {
        this.indEntryTime = indEntryTime;
    }

    public Date getIndQuitTime() {
        return indQuitTime;
    }

    public void setIndQuitTime(Date indQuitTime) {
        this.indQuitTime = indQuitTime;
    }

    public String getIndEntryHistory() {
        return indEntryHistory;
    }

    public void setIndEntryHistory(String indEntryHistory) {
        this.indEntryHistory = indEntryHistory;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "InductionInfo{" +
        ", indId=" + indId +
        ", indEntryTime=" + indEntryTime +
        ", indQuitTime=" + indQuitTime +
        ", indEntryHistory=" + indEntryHistory +
        ", empId=" + empId +
        "}";
    }
}
