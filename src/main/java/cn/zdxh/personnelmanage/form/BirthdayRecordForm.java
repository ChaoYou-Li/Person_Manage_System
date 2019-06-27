package cn.zdxh.personnelmanage.form;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import javax.validation.constraints.*;
import java.util.Date;

public class BirthdayRecordForm {
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
    private Date birOperationTime;
    /**
     * 员工外键
     */
    private Integer empId;

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
}
