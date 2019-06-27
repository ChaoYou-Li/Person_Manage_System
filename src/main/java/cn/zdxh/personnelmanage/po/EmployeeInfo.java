package cn.zdxh.personnelmanage.po;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import java.io.Serializable;

/**
 * 员工信息表
 *
 * @author Justin
 * @since 2019-03-15
 */
public class EmployeeInfo implements Serializable {

    private static final long serialVersionUID = 7135033407228030798L;
    /**
     * 自增主键
     */
    @TableId(value = "emp_id", type = IdType.AUTO)
    private Integer empId;
    /**
     * 姓名
     */
    private String empName;
    /**
     * 性别：1为男，2为女
     */
    private Integer empSex;
    /**
     * 民族
     */
    private String empNation;
    /**
     * 工号
     */
    private String empNumber;
    /**
     * 生日
     */
    private Date empBirthday;
    /**
     * 身份证
     */
    private String empCard;
    /**
     * 是否结婚 1为已婚 2为未婚
     */
    private Integer empMarry;
    /**
     * 部门
     */
    private String empDepart;
    /**
     * 个人照片
     */
    private String empPic;
    /**
     * 职位
     */
    private String empPosition;
    /**
     * 毕业院校
     */
    private String empSchool;
    /**
     * 联系电话
     */
    private String empPhone;
    /**
     * 邮箱
     */
    private String empEmail;
    /**
     * 居住地
     */
    private String empAddr;


    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getEmpSex() {
        return empSex;
    }

    public void setEmpSex(Integer empSex) {
        this.empSex = empSex;
    }

    public String getEmpNation() {
        return empNation;
    }

    public void setEmpNation(String empNation) {
        this.empNation = empNation;
    }

    public String getEmpNumber() {
        return empNumber;
    }

    public void setEmpNumber(String empNumber) {
        this.empNumber = empNumber;
    }

    public Date getEmpBirthday() {
        return empBirthday;
    }

    public void setEmpBirthday(Date empBirthday) {
        this.empBirthday = empBirthday;
    }

    public String getEmpCard() {
        return empCard;
    }

    public void setEmpCard(String empCard) {
        this.empCard = empCard;
    }

    public Integer getEmpMarry() {
        return empMarry;
    }

    public void setEmpMarry(Integer empMarry) {
        this.empMarry = empMarry;
    }

    public String getEmpDepart() {
        return empDepart;
    }

    public void setEmpDepart(String empDepart) {
        this.empDepart = empDepart;
    }

    public String getEmpPic() {
        return empPic;
    }

    public void setEmpPic(String empPic) {
        this.empPic = empPic;
    }

    public String getEmpPosition() {
        return empPosition;
    }

    public void setEmpPosition(String empPosition) {
        this.empPosition = empPosition;
    }

    public String getEmpSchool() {
        return empSchool;
    }

    public void setEmpSchool(String empSchool) {
        this.empSchool = empSchool;
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone;
    }

    public String getEmpEmail() {
        return empEmail;
    }

    public void setEmpEmail(String empEmail) {
        this.empEmail = empEmail;
    }

    public String getEmpAddr() {
        return empAddr;
    }

    public void setEmpAddr(String empAddr) {
        this.empAddr = empAddr;
    }

    @Override
    public String toString() {
        return "EmployeeInfo{" +
        ", empId=" + empId +
        ", empName=" + empName +
        ", empSex=" + empSex +
        ", empNation=" + empNation +
        ", empNumber=" + empNumber +
        ", empBirthday=" + empBirthday +
        ", empCard=" + empCard +
        ", empMarry=" + empMarry +
        ", empDepart=" + empDepart +
        ", empPic=" + empPic +
        ", empPosition=" + empPosition +
        ", empSchool=" + empSchool +
        ", empPhone=" + empPhone +
        ", empEmail=" + empEmail +
        ", empAddr=" + empAddr +
        "}";
    }
}
