package cn.zdxh.personnelmanage.po;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 退休人员信息表
 *
 * @author Justin
 * @since 2019-03-15
 */
public class RetireInfo implements Serializable {

    private static final long serialVersionUID = -3234942710671751147L;
    /**
     * 自增主键
     */
    @TableId(value = "ret_id", type = IdType.AUTO)
    private Integer retId;
    /**
     * 姓名
     */
    private String retName;
    /**
     * 性别 1为男 2为女
     */
    private Integer retSex;
    /**
     * 民族
     */
    private String retNation;
    /**
     * 生日
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date retBirthday;
    /**
     * 身份证号码
     */
    private String retIdCard;
    /**
     * 银行卡
     */
    private String retBankCard;
    /**
     * 电话号码
     */
    private String retPhone;
    /**
     * 居住地
     */
    private String retAddr;
    /**
     * 紧急电话
     */
    private String retEmerPhone;


    public Integer getRetId() {
        return retId;
    }

    public void setRetId(Integer retId) {
        this.retId = retId;
    }

    public String getRetName() {
        return retName;
    }

    public void setRetName(String retName) {
        this.retName = retName;
    }

    public Integer getRetSex() {
        return retSex;
    }

    public void setRetSex(Integer retSex) {
        this.retSex = retSex;
    }

    public String getRetNation() {
        return retNation;
    }

    public void setRetNation(String retNation) {
        this.retNation = retNation;
    }

    public Date getRetBirthday() {
        return retBirthday;
    }

    public void setRetBirthday(Date retBirthday) {
        this.retBirthday = retBirthday;
    }

    public String getRetIdCard() {
        return retIdCard;
    }

    public void setRetIdCard(String retIdCard) {
        this.retIdCard = retIdCard;
    }

    public String getRetBankCard() {
        return retBankCard;
    }

    public void setRetBankCard(String retBankCard) {
        this.retBankCard = retBankCard;
    }

    public String getRetPhone() {
        return retPhone;
    }

    public void setRetPhone(String retPhone) {
        this.retPhone = retPhone;
    }

    public String getRetAddr() {
        return retAddr;
    }

    public void setRetAddr(String retAddr) {
        this.retAddr = retAddr;
    }

    public String getRetEmerPhone() {
        return retEmerPhone;
    }

    public void setRetEmerPhone(String retEmerPhone) {
        this.retEmerPhone = retEmerPhone;
    }

    @Override
    public String toString() {
        return "RetireInfo{" +
        ", retId=" + retId +
        ", retName=" + retName +
        ", retSex=" + retSex +
        ", retNation=" + retNation +
        ", retBirthday=" + retBirthday +
        ", retIdCard=" + retIdCard +
        ", retBankCard=" + retBankCard +
        ", retPhone=" + retPhone +
        ", retAddr=" + retAddr +
        ", retEmerPhone=" + retEmerPhone +
        "}";
    }
}
