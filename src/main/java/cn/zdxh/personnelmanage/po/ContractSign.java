package cn.zdxh.personnelmanage.po;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 合同签订情况表
 *
 * @author Justin
 * @since 2019-03-15
 */
public class ContractSign implements Serializable {

    private static final long serialVersionUID = 5510201602859766086L;
    /**
     * 自增主键
     */
    @TableId(value = "con_id", type = IdType.AUTO)
    private Integer conId;
    /**
     * 合同类型
     */
    private String conType;
    /**
     * 合同到期时间 (需要合同过期提醒)
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date conEnpireTime;
    /**
     * 合同历史签订情况
     */
    private String conHistory;
    /**
     * 员工外键
     */
    private Integer empId;


    public Integer getConId() {
        return conId;
    }

    public void setConId(Integer conId) {
        this.conId = conId;
    }

    public String getConType() {
        return conType;
    }

    public void setConType(String conType) {
        this.conType = conType;
    }

    public Date getConEnpireTime() {
        return conEnpireTime;
    }

    public void setConEnpireTime(Date conEnpireTime) {
        this.conEnpireTime = conEnpireTime;
    }

    public String getConHistory() {
        return conHistory;
    }

    public void setConHistory(String conHistory) {
        this.conHistory = conHistory;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "ContractSign{" +
        ", conId=" + conId +
        ", conType=" + conType +
        ", conEnpireTime=" + conEnpireTime +
        ", conHistory=" + conHistory +
        ", empId=" + empId +
        "}";
    }
}
