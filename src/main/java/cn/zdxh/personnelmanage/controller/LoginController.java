package cn.zdxh.personnelmanage.controller;

import cn.zdxh.personnelmanage.enums.ResultEnum;
import cn.zdxh.personnelmanage.exception.MyException;
import cn.zdxh.personnelmanage.form.AdminForm;
import cn.zdxh.personnelmanage.po.Admin;
import cn.zdxh.personnelmanage.service.AdminService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * 登录前端控制器
 */

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private AdminService adminService;

    /**
     * 跳转到login页面
     * @return
     */
    @RequestMapping("/index")
    public String showLogin(){
        return "login";
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping("/login")
    public String login(@Valid AdminForm adminForm, BindingResult bindingResult, HttpSession session){
        if (bindingResult.hasErrors()){
            //表单验证不通过，抛异常，信息是检查错误
            throw new MyException(ResultEnum.CHECK_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        Admin admin = new Admin();
        //属性包装转换
        BeanUtils.copyProperties(adminForm,admin);
        Admin adminResult = adminService.findAdmin(admin);
        //登录成功
        if (adminResult != null){
            if (adminResult.getSign() == 1){
                //系统管理员
                session.setAttribute("admin",adminResult);
                return "common/superAdmin/index";
            }
            else if (adminResult.getSign() == 2){
                //人事管理员
                session.setAttribute("admin",adminResult);

                return "common/admin/index";
            }
        }
        //登录失败,重新跳回登录页面
        session.setAttribute("msg","用户名或密码错误");
        return "redirect:/login/index";
    }

    /**
     * 退出登录
     * @param session
     * @return
     */
    @RequestMapping("/out")
    public String loginOut(HttpSession session){
        //清除登录
        session.removeAttribute("admin");
        return "redirect:/login/index";
    }
}
