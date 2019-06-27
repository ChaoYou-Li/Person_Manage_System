package cn.zdxh.personnelmanage.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 管理员表,接收表单的员工信息，并且带有数据校验的功能
 */
public class AdminForm {


    /**
     * 自增主键
     */
    private Integer id;

    /**
     * 用户名
     */
    @NotBlank(message = "登录名不能为空")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String password;

    /**
     * 标记是人事管理员2 还是系统管理员1
     */
    @NotNull(message = "请选择是系统管理员还是人事管理员")
    private Integer sign;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getSign() {
        return sign;
    }

    public void setSign(Integer sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sign=" + sign +
                '}';
    }
}
