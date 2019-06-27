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
import java.util.Map;

/**
 * <p>
 * 管理员表 前端控制器
 * </p>
 *
 * @author Justin
 * @since 2019-03-23
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;


    /**
     * 人事管理员增加，此接口还没用到
     * @return
     */
    @PostMapping("/adm")
    public String register(@Valid AdminForm adminForm, BindingResult bindingResult, Map<String, Object> map){
        if (bindingResult.hasErrors()){
            //表单验证不通过，抛异常，信息是检查错误
            throw new MyException(ResultEnum.CHECK_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        Admin admin = new Admin();
        //属性包装转换
        BeanUtils.copyProperties(adminForm,admin);
        Integer result = adminService.insertAdmin(admin);
        if (result==0){
            //插入失败的情况
            throw new MyException(ResultEnum.INSERT_FAIL.getCode(),ResultEnum.INSERT_FAIL.getMsg());
        }
        //增加成功
        return "/common/superAdmin/index";
    }


}
