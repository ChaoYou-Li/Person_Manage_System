package cn.zdxh.personnelmanage.po;

import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import java.io.Serializable;

/**
 * 家庭情况表
 *
 * @author Justin
 * @since 2019-03-15
 */
public class FamilyInfo implements Serializable {

    private static final long serialVersionUID = 3895482569565483845L;
    /**
     * 自增主键
     */
    @TableId(value = "fam_id", type = IdType.AUTO)
    private Integer famId;
    /**
     * 姓名
     */
    private String famName;
    /**
     * 关系
     */
    private String famRelation;
    /**
     * 性别 1为男  2为女
     */
    private Integer famSex;
    /**
     * 工作单位
     */
    private String famWorkPalce;
    /**
     * 联系电话
     */
    private String famPhone;
    /**
     * 标记是何种情况 1父母 2配偶 3子女 4紧急
     */
    private Integer famSign;
    /**
     * 员工外键
     */
    private Integer empId;


    public Integer getFamId() {
        return famId;
    }

    public void setFamId(Integer famId) {
        this.famId = famId;
    }

    public String getFamName() {
        return famName;
    }

    public void setFamName(String famName) {
        this.famName = famName;
    }

    public String getFamRelation() {
        return famRelation;
    }

    public void setFamRelation(String famRelation) {
        this.famRelation = famRelation;
    }

    public Integer getFamSex() {
        return famSex;
    }

    public void setFamSex(Integer famSex) {
        this.famSex = famSex;
    }

    public String getFamWorkPalce() {
        return famWorkPalce;
    }

    public void setFamWorkPalce(String famWorkPalce) {
        this.famWorkPalce = famWorkPalce;
    }

    public String getFamPhone() {
        return famPhone;
    }

    public void setFamPhone(String famPhone) {
        this.famPhone = famPhone;
    }

    public Integer getFamSign() {
        return famSign;
    }

    public void setFamSign(Integer famSign) {
        this.famSign = famSign;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "FamilyInfo{" +
        ", famId=" + famId +
        ", famName=" + famName +
        ", famRelation=" + famRelation +
        ", famSex=" + famSex +
        ", famWorkPalce=" + famWorkPalce +
        ", famPhone=" + famPhone +
        ", famSign=" + famSign +
        ", empId=" + empId +
        "}";
    }
}
