package cn.zdxh.personnelmanage.controller;


import cn.zdxh.personnelmanage.enums.ResultEnum;
import cn.zdxh.personnelmanage.exception.MyException;
import cn.zdxh.personnelmanage.form.EmployeeForm;
import cn.zdxh.personnelmanage.po.EmployeeCard;
import cn.zdxh.personnelmanage.po.EmployeeInfo;
import cn.zdxh.personnelmanage.service.EmployeeInfoService;
import cn.zdxh.personnelmanage.utils.ExcelTitlesHelperUtils;
import cn.zdxh.personnelmanage.utils.ExcelValuesHelperUtils;
import cn.zdxh.personnelmanage.utils.ExportExcelUtils;
import cn.zdxh.personnelmanage.utils.UploadUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 员工信息表 前端控制器
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */

@Controller
@RequestMapping("/employee")
public class EmployeeInfoController {

    @Autowired
    private EmployeeInfoService employeeInfoService;



    /**
     * 查询所有的员工（默认0到10个）
     * @GetMapping 表示的是get请求
     * @ResponseBody 返回的是json的格式（分页时的ajax数据请求）
     * @param currentPage 当前页
     * @param limit 每页显示多少个
     * @return
     */
    @GetMapping("/emps")
    public String employees(@RequestParam(value = "currentPage",defaultValue = "0") String currentPage, @RequestParam(value = "limit",defaultValue = "2") String limit,Map<String,Object> map){
        //向数据库查询值
        List<EmployeeInfo> allEmployees = employeeInfoService.findAllEmployees(Integer.parseInt(currentPage), Integer.parseInt(limit));
        Integer allCount = employeeInfoService.findAllCount();
        //存储值，可以在引擎模板中取值（页面中取值）
        map.put("employees",allEmployees);
        map.put("totalPage",allCount);//总页数
        map.put("currentPage",currentPage);//当前页数-1
        map.put("operation","employee_list_model");//判别标识
        //employee_list的意思就是employee_list.html页面，并在其中取值，相当于jsp页面
        return "employee/employee_list";
    }

    /**
     * 在修改之前需要进行一次数据回显，查询某个需要修改的员工
     * @GetMapping 表示的是get请求
     * @param id  员工id
     * @param map 存储值
     * @return
     */
    @GetMapping("/emp/{id}")
    public String employee(@PathVariable("id") Integer id,Map<String,Object> map){
        EmployeeInfo employee = employeeInfoService.findEmployee(id);
        map.put("employee",employee);
        map.put("type","update");
        return "employee/employee_update";
    }

    /**
     * 更新员工信息
     * @PutMapping 表示的是put请求方式
     * @param employeeForm 表单传过来的对象
     * @param bindingResult 表单验证对象
     * @return
     */
    @PutMapping("/emp/{id}")
    public String updateEmployee(@Validated EmployeeForm employeeForm, BindingResult bindingResult,@PathVariable("id") Integer id){
        //数据校验出现错误的时候，需要抛个异常，并且异常捕获到异常页面
        if (bindingResult.hasErrors()){
            throw new MyException(ResultEnum.CHECK_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        //封装页面传过来的员工id
        employeeForm.setEmpId(id);
        EmployeeInfo employeeInfo = new EmployeeInfo();
        //对象属性转换
        BeanUtils.copyProperties(employeeForm,employeeInfo);
        employeeInfoService.updateEmployee(employeeInfo);
        return "result/success";
    }

    /**
     * 仅仅作页面跳转的作用（跳转到新增员工的页面）
     * @GetMapping get的请求方式
     * @return
     */
    @GetMapping("/emp")
    public String insertEmployeeBefore(Map<String, Object> map){
        map.put("type","create");
        map.put("operation","employee_create_model");
        return "employee/employee_create";
    }

    /**
     * 新增员工信息
     * @PostMapping post方式提交
     * @param employeeForm
     * @param bindingResult
     * @return
     */
    @PostMapping("/emp")
    public String insertEmployee(@Validated EmployeeForm employeeForm, BindingResult bindingResult){
        //数据校验出现错误的时候，需要抛个异常，并且异常捕获到异常页面
        if (bindingResult.hasErrors()){
            //错误码 ResultEnum.CHECK_ERROR.getCode()
            //数据校验的具体错误信息  bindingResult.getFieldError().getDefaultMessage()
            throw new MyException(ResultEnum.CHECK_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        EmployeeInfo employeeInfo = new EmployeeInfo();
        //对象属性转换
        BeanUtils.copyProperties(employeeForm,employeeInfo);
        employeeInfoService.insertEmployee(employeeInfo);
        return "result/success";
    }

    /**
     * 删除员工
     * @DeleteMapping delete请求
     * @param id 员工id
     * @return
     */
    @DeleteMapping("emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeInfoService.deleteEmployee(id);
        return "employee/employee_list";
    }

    @DeleteMapping("/batchDelete")
    public String batchDeleteBirth(@RequestParam("data_id") String data_id, Map<String, Object> map){
        String[] id = data_id.split(",");
        for (int i = 0; i < id.length; i++){
            EmployeeInfo employeeInfo = employeeInfoService.findEmployee(Integer.parseInt(id[i]));
            if (employeeInfo != null){
                employeeInfoService.deleteEmployee(Integer.parseInt(id[i]));
            }
        }
        return "result/success";
    }

    /**
     * 根据员工姓名模糊查询员工
     * @param content
     * @return
     */
    @PostMapping("/search")
    public String searchEmployees(String content,Map<String,Object> map){
        List<EmployeeInfo> employeeInfos = employeeInfoService.findAllEmployeeInfosBySearch(content);
        //存储值，可以在引擎模板中取值（页面中取值）
        map.put("employees",employeeInfos);
        map.put("operation", "employee_list_model");
        return "employee/employee_list";
    }


    /**
     * 功能需求：完成客户端的Excel表数据写入数据库功能
     *
     * @param file //用户上传的Excel文件
     * @param uploadUtils //上传文件的工具类 cn.zdxh.personnelmanage.utils.UploadUtils
     * @return
     * @throws Exception
     */
    @PostMapping("/updateExcel")
    @ResponseBody
    public JSONObject updateExcel(@RequestParam("file") MultipartFile file, UploadUtils uploadUtils) throws Exception {
        JSONObject json = new JSONObject();
        try {
            //第一个参数为Excel表，第二个参数为从第几行读取Excel的内容，返回值为一个字符串数组集合（每一个数组代表Excel表的一行数据）
            List<String[]> list =  uploadUtils.updateExcelUtils(file, 1);
            //遍历字符串数组集合中的数据
            for (String[] str:list){
                //获取实体类对象封装数据（每一个实体类对象封装Excel表中的一行数据）
                EmployeeInfo employeeCard = new EmployeeInfo();
                //一个工具类，把字符串数组数据封装到实体类对象中，第一个参数为实体类对象，第二个参数为字符串数组
                ExcelValuesHelperUtils.setAttributeValue(employeeCard, str);

                /**
                 * 在完成Excel表中数据写入数据库操作之前先判断
                 * 该实体类对象的是否为数据库已有（进行更新操作）
                 * 该实体类对象的数据为数据库没有（进行插入操作）
                 */
                if (employeeInfoService.findEmployee(Integer.parseInt(str[0])) != null){
                    employeeInfoService.updateEmployee(employeeCard);
                } else {
                    employeeInfoService.insertEmployee(employeeCard);
                }
            }
        } catch (Exception e){
            /**
             * 做一个报错检测
             */
            throw new MyException(ResultEnum.UPDATE_EXCEL_ERROR.getCode(), ResultEnum.UPDATE_EXCEL_ERROR.getMsg());
        }

        //返回客户端的数据
        json.put("code", 1);
        json.put("data", "Excel表上传成功！");
        json.put("ret", true);
        return json;
    }


    /**
     * 需求功能：完成服务器端把数据库中的数据读出客户端功能
     *
     * @param response //把生成的Excel表响应到客户端
     * @throws NoSuchMethodException //报错
     * @throws IllegalAccessException   //报错
     * @throws InvocationTargetException    //报错
     * @throws InstantiationException   //报错
     */
    @GetMapping("/exportExcel")
    public void exportExcel(HttpServletResponse response) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        //先把数据库中的数据查询出来
        List<EmployeeInfo> list1 = employeeInfoService.selectList(null);
        //一个设置Excel表标题信息的工具类，获取Excel表标题的字符串数组
        String[] strings = ExcelTitlesHelperUtils.getEmployeeInfoTitles();
        //一个能把对象集合转换成字符串数组集合的工具类，参数为对象集合，返回字符串数组集合
        List<Object[]> list = ExcelValuesHelperUtils.exportExcel(list1);
        try {
            //一个能创建Excel表并完成发送客户端的工具类，第一个参数为字符串数组集合（Excel表内容），第二个参数为字符串数组（Excel表标题），第三个参数为响应器
            ExportExcelUtils.createExcelUtils(list, strings, response);
        } catch (Exception e){
            //导表发生异常的时候
            throw new MyException(ResultEnum.EXPORT_EXCEL_ERROR.getCode(),ResultEnum.EXPORT_EXCEL_ERROR.getMsg());
        }

    }

}

