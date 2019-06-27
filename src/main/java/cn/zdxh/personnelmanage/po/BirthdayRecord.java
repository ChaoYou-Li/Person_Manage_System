package cn.zdxh.personnelmanage.po;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 生育纪录表
 *
 * @author Justin
 * @since 2019-03-15
 */
public class BirthdayRecord implements Serializable {

    private static final long serialVersionUID = 4849616019539107195L;

    /**
     * 自增主键
     */
    @TableId(value = "bir_id", type = IdType.AUTO)
    private Integer birId;
    /**
     * 头胎还是其他胎
     */
    private String birType;
    /**
     * 产检医院
     */
    private String birProdInspHos;
    /**
     * 分娩医院
     */
    private String birMaterHos;
    /**
     * 计生证号码
     */
    private String birNumber;
    /**
     * 手术日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birOperationTime;
    /**
     * 员工外键
     */
    private Integer empId;

    public BirthdayRecord() {
    }

    public BirthdayRecord(Integer birId, String birType, String birProdInspHos, String birMaterHos, String birNumber, Date birOperationTime, Integer empId) {
        this.birId = birId;
        this.birType = birType;
        this.birProdInspHos = birProdInspHos;
        this.birMaterHos = birMaterHos;
        this.birNumber = birNumber;
        this.birOperationTime = birOperationTime;
        this.empId = empId;
    }

    public Integer getBirId() {
        return birId;
    }

    public void setBirId(Integer birId) {
        this.birId = birId;
    }

    public String getBirType() {
        return birType;
    }

    public void setBirType(String birType) {
        this.birType = birType;
    }

    public String getBirProdInspHos() {
        return birProdInspHos;
    }

    public void setBirProdInspHos(String birProdInspHos) {
        this.birProdInspHos = birProdInspHos;
    }

    public String getBirMaterHos() {
        return birMaterHos;
    }

    public void setBirMaterHos(String birMaterHos) {
        this.birMaterHos = birMaterHos;
    }

    public String getBirNumber() {
        return birNumber;
    }

    public void setBirNumber(String birNumber) {
        this.birNumber = birNumber;
    }

    public Date getBirOperationTime() {
        return birOperationTime;
    }

    public void setBirOperationTime(Date birOperationTime) {
        this.birOperationTime = birOperationTime;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    @Override
    public String toString() {
        return "BirthdayRecord{" +
        ", birId=" + birId +
        ", birType=" + birType +
        ", birProdInspHos=" + birProdInspHos +
        ", birMaterHos=" + birMaterHos +
        ", birNumber=" + birNumber +
        ", birOperationTime=" + birOperationTime +
        ", empId=" + empId +
        "}";
    }
}
