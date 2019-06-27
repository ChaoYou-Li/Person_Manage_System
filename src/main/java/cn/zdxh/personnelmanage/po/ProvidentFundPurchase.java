package cn.zdxh.personnelmanage.po;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 公积金购买情况表
 *
 * @author Justin
 * @since 2019-03-15
 */
public class ProvidentFundPurchase implements Serializable {

    private static final long serialVersionUID = -4874414370689981301L;
    /**
     * 自增主键
     */
    @TableId(value = "pfp_id", type = IdType.AUTO)
    private Integer pfpId;
    /**
     * 公积金购买时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pfpStartTime;
    /**
     * 公积金停买时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pfpEndTime;
    /**
     * 员工外键
     */
    private Integer empId;


    public Integer getPfpId() {
        return pfpId;
    }

    public void setPfpId(Integer pfpId) {
        this.pfpId = pfpId;
    }

    public Date getPfpStartTime() {
        return pfpStartTime;
    }

    public void setPfpStartTime(Date pfpStartTime) {
        this.pfpStartTime = pfpStartTime;
    }

    public Date getPfpEndTime() {
        return pfpEndTime;
    }

    public void setPfpEndTime(Date pfpEndTime) {
        this.pfpEndTime = pfpEndTime;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "ProvidentFundPurchase{" +
        ", pfpId=" + pfpId +
        ", pfpStartTime=" + pfpStartTime +
        ", pfpEndTime=" + pfpEndTime +
        ", empId=" + empId +
        "}";
    }
}
