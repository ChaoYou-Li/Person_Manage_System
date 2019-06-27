package cn.zdxh.personnelmanage.po;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import java.io.Serializable;

/**
 * 免搭伙费表
 *
 * @author Justin
 * @since 2019-03-15
 */
public class FreeCharge implements Serializable {

    private static final long serialVersionUID = 2311373316577165068L;
    /**
     * 自增主键
     */
    @TableId(value = "free_id", type = IdType.AUTO)
    private Integer freeId;
    /**
     * 原持卡片类型 1临时卡 2钱包卡
     */
    private Integer freeType;
    /**
     * 卡号
     */
    private String freeNumber;
    /**
     * 0默认为新办 1为续办（修改过数据即为续办）
     */
    private Integer freeSign;
    /**
     * 员工外键
     */
    private Integer empId;


    public Integer getFreeId() {
        return freeId;
    }

    public void setFreeId(Integer freeId) {
        this.freeId = freeId;
    }

    public Integer getFreeType() {
        return freeType;
    }

    public void setFreeType(Integer freeType) {
        this.freeType = freeType;
    }

    public String getFreeNumber() {
        return freeNumber;
    }

    public void setFreeNumber(String freeNumber) {
        this.freeNumber = freeNumber;
    }

    public Integer getFreeSign() {
        return freeSign;
    }

    public void setFreeSign(Integer freeSign) {
        this.freeSign = freeSign;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "FreeCharge{" +
        ", freeId=" + freeId +
        ", freeType=" + freeType +
        ", freeNumber=" + freeNumber +
        ", freeSign=" + freeSign +
        ", empId=" + empId +
        "}";
    }
}
