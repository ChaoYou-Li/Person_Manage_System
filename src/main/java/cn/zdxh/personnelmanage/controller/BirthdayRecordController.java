package cn.zdxh.personnelmanage.controller;


import cn.zdxh.personnelmanage.enums.ResultEnum;
import cn.zdxh.personnelmanage.exception.MyException;
import cn.zdxh.personnelmanage.po.BirthdayRecord;
import cn.zdxh.personnelmanage.po.EmployeeInfo;
import cn.zdxh.personnelmanage.service.BirthdayRecordService;
import cn.zdxh.personnelmanage.service.EmployeeInfoService;
import cn.zdxh.personnelmanage.service.impl.BirthdayRecordServiceImpl;
import cn.zdxh.personnelmanage.utils.*;
import com.fasterxml.jackson.databind.util.JSONPObject;
import net.sf.json.JSONObject;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchUpdateUtils;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 生育纪录表 前端控制器
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
@Controller
@RequestMapping("/BirthdayRecord")
public class BirthdayRecordController {

    @Autowired
    private BirthdayRecordService birthdayRecordService;
    @Autowired
    private EmployeeInfoService employeeInfoService;

    /**
     * 功能需求：设计一个查询生育记录表的方法
     * @param currentPage 当前页
     * @param limit 每个页面显示多少条信息
     */
    @GetMapping("/list")
    public String findbirthdayRecords(@RequestParam(value = "currentPage", defaultValue = "0") Integer currentPage, @RequestParam(value = "limit", defaultValue = "3") Integer limit, Map<String, Object> map){
        //向数据库发起分页式的查询请求
        List<BirthdayRecord> list = birthdayRecordService.findBirthdayRecordAll(currentPage, limit);
        //向数据库发起查询总页数请求
        Integer allCount = birthdayRecordService.findBirthdayRecordAllCount();
        //设置响应参数集合
        map.put("list", list);
        map.put("totalPage",allCount);//总页数
        map.put("currentPage",currentPage);//当前页数-1
        map.put("operation", "birthday_record_model");
        return "employee/employee_list";
    }

    /**
     * 功能需求：设计一个为增添信息时页面转向的方法
     */
    @GetMapping("/create")
    public String toCreatePage(Map<String, Object> map, ChildTypeUtils childTypeUtils){
        List<EmployeeInfo> list = employeeInfoService.selectList(null);
        map.put("employees", list);
        map.put("child", childTypeUtils.childTypeMap());
        map.put("type", "create");
        map.put("operation", "birthday_record_model");
        map.put("req_url", "/BirthdayRecord/add");
        return "employee/employee_create";
    }

    /**
     * 功能需求：提供一个生育纪录添加信息的方法
     * @param birthdayRecord
     * @return
     */
    @GetMapping("/add")
    public String addBirth(BirthdayRecord birthdayRecord, Map<String, Object> map){
        birthdayRecordService.insertBirthdayRecord(birthdayRecord);
        map.put("operat", "success");
        return "result/success";
    }

    @GetMapping("/update/{id}")
    public String goBirthUpdate(@PathVariable("id") Integer id, Map<String, Object> map, ChildTypeUtils childTypeUtils){
        BirthdayRecord employeeInfo = birthdayRecordService.findBirthdayRecord(id);
        List<EmployeeInfo> list = employeeInfoService.selectList(null);
        map.put("employees", list);//所有员工的数据集合用来设置生育记录添加和更新操作的员工信息选择项
        map.put("child", childTypeUtils.childTypeMap());//生育记录添加和更新时供用户选择的胎儿数选择项
        map.put("birthdayRecord", employeeInfo);//要修改的生育记录对象信息
        map.put("type", "update");//一个判别标识（表示此为更新操作）
        map.put("operation", "birthday_record_model");//一个判别标识（表示当前选择为生育记录操作）
        map.put("req_url", "/BirthdayRecord/update");//前端更新操作的处理链接
        return "employee/employee_create";
    }

    /**
     *
     * @param birthdayRecord //要修改的生育记录JavaBean参数对象
     * @param map //响应前端的json数据
     * @return
     */
    @PostMapping("/update")
    public String updateBirth(BirthdayRecord birthdayRecord, Map<String, Object> map){
        birthdayRecordService.updateBirthdayRecord(birthdayRecord);
        map.put("operat", "success");
        return "result/success";
    }

    /**
     *
     * @param id //要删除的生育记录id
     * @param map //响应前端的json数据
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public String goBirthDelete(@PathVariable("id") Integer id, Map<String, Object> map){
        birthdayRecordService.deleteBirthdayRecord(id);
        map.put("operat", "success");
        return "result/success";
    }

    @DeleteMapping("/batchDelete")
    public String batchDeleteBirth(@RequestParam("data_id") String data_id, Map<String, Object> map){
        String[] id = data_id.split(",");
        for (int i = 0; i < id.length; i++){
            BirthdayRecord birthdayRecord = birthdayRecordService.findBirthdayRecord(Integer.parseInt(id[i]));
            if (birthdayRecord != null){
                birthdayRecordService.deleteBirthdayRecord(Integer.parseInt(id[i]));
            }
        }
        return "result/success";
    }

    @GetMapping("/search")
    public String searchBirthRecord(@RequestParam("data") String data, Map<String, Object> map){
        List<BirthdayRecord> list = birthdayRecordService.findAllBirthdayRecordBySearch(data);
        for (BirthdayRecord birthdayRecord:list){
            System.out.println(birthdayRecord);
        }
        map.put("list", list);
        map.put("operation", "birthday_record_model");
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
                BirthdayRecord birthdayRecord = new BirthdayRecord();
                //一个工具类，把字符串数组数据封装到实体类对象中，第一个参数为实体类对象，第二个参数为字符串数组
                ExcelValuesHelperUtils.setAttributeValue(birthdayRecord, str);

                /**
                 * 在完成Excel表中数据写入数据库操作之前先判断
                 * 该实体类对象的是否为数据库已有（进行更新操作）
                 * 该实体类对象的数据为数据库没有（进行插入操作）
                 */
                if (birthdayRecordService.findBirthdayRecord(Integer.parseInt(str[0])) != null){
                    birthdayRecordService.updateBirthdayRecord(birthdayRecord);
                } else {
                    birthdayRecordService.insertBirthdayRecord(birthdayRecord);
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
     * 需求功能：完成服务器端把数据库中的数据读出客户端Excel文件的功能
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
        List<BirthdayRecord> list1 = birthdayRecordService.selectList(null);
        //一个设置Excel表标题信息的工具类，获取Excel表标题的字符串数组
        String[] strings = ExcelTitlesHelperUtils.getBirthdayRecordTitles();
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

