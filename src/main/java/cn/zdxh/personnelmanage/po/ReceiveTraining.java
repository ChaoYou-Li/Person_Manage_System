package cn.zdxh.personnelmanage.po;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import java.io.Serializable;

/**
 * 接受过培训表
 *
 * @author Justin
 * @since 2019-03-15
 */
public class ReceiveTraining implements Serializable {

    private static final long serialVersionUID = 6331790920047075043L;
    /**
     * 自增主键
     */
    @TableId(value = "tra_id", type = IdType.AUTO)
    private Integer traId;
    /**
     * 领过的补助
     */
    private String traSubsidy;
    /**
     * 获得过的奖励
     */
    private String traReward;
    /**
     * 员工外键
     */
    private Integer empId;


    public Integer getTraId() {
        return traId;
    }

    public void setTraId(Integer traId) {
        this.traId = traId;
    }

    public String getTraSubsidy() {
        return traSubsidy;
    }

    public void setTraSubsidy(String traSubsidy) {
        this.traSubsidy = traSubsidy;
    }

    public String getTraReward() {
        return traReward;
    }

    public void setTraReward(String traReward) {
        this.traReward = traReward;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "ReceiveTraining{" +
        ", traId=" + traId +
        ", traSubsidy=" + traSubsidy +
        ", traReward=" + traReward +
        ", empId=" + empId +
        "}";
    }
}
