package cn.zdxh.personnelmanage.form;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * 接收表单的员工信息，并且带有数据校验的功能
 *
 * @author Justin
 * @since 2019-03-15
 */
public class EmployeeForm {

    /**
     * 自增主键
     */
    private Integer empId;
    /**
     * 姓名
     */
    @NotBlank(message = "姓名不能为空")
    private String empName;
    /**
     * 性别：1为男，2为女
     */
    @NotNull(message = "性别不能为空")
    private Integer empSex;
    /**
     * 民族
     */
    @NotBlank(message = "民族不能为空")
    private String empNation;
    /**
     * 工号
     */
    @NotBlank(message = "工号不能为空")
    private String empNumber;
    /**
     * 生日，格式化接收参数
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "生日不能为空")
    private Date empBirthday;
    /**
     * 身份证
     */
    @NotBlank(message = "生日不能为空")
    private String empCard;
    /**
     * 是否结婚 1为已婚 2为未婚
     */
    @NotNull(message = "是否结婚不能为空")
    private Integer empMarry;
    /**
     * 部门
     */
    @NotBlank(message = "部门不能为空")
    private String empDepart;
    /**
     * 个人照片
     */
    private String empPic;
    /**
     * 职位
     */
    @NotBlank(message = "职位不能为空")
    private String empPosition;
    /**
     * 毕业院校
     */
    @NotBlank(message = "毕业院校不能为空")
    private String empSchool;
    /**
     * 联系电话
     */
    @Pattern(regexp="^1[34578]\\d{9}$",message="手机号码格式不正确")
    @NotBlank(message = "联系电话不能为空")
    private String empPhone;
    /**
     * 邮箱
     */
    @Email(message = "邮箱格式不正确")
    @NotBlank(message = "邮箱不能为空")
    private String empEmail;
    /**
     * 居住地
     */
    @NotBlank(message = "居住地不能为空")
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
        return "EmployeeForm{" +
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
