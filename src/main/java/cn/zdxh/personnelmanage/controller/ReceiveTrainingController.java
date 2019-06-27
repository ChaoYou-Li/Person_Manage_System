package cn.zdxh.personnelmanage.controller;


import cn.zdxh.personnelmanage.enums.ResultEnum;
import cn.zdxh.personnelmanage.exception.MyException;
import cn.zdxh.personnelmanage.po.EmployeeInfo;
import cn.zdxh.personnelmanage.po.PurchaseInsurance;
import cn.zdxh.personnelmanage.po.ReceiveTraining;
import cn.zdxh.personnelmanage.service.EmployeeInfoService;
import cn.zdxh.personnelmanage.service.ReceiveTrainingService;
import cn.zdxh.personnelmanage.utils.ExcelTitlesHelperUtils;
import cn.zdxh.personnelmanage.utils.ExcelValuesHelperUtils;
import cn.zdxh.personnelmanage.utils.ExportExcelUtils;
import cn.zdxh.personnelmanage.utils.UploadUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 接受过培训表 前端控制器
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
@Controller
@RequestMapping("/ReceiveTraining")
public class ReceiveTrainingController {

    @Autowired
    private EmployeeInfoService employeeInfoService;
    @Autowired
    private ReceiveTrainingService receiveTrainingService;

    @GetMapping("/list")
    public String findReceiveTrain(@RequestParam(value = "currentPage", defaultValue = "0") Integer currentPage, @RequestParam(value = "limit", defaultValue = "3") Integer limit, Map<String, Object> map){
        List<ReceiveTraining> list = receiveTrainingService.findAllReceiveTraining(currentPage, limit);
        Integer addCount = receiveTrainingService.findReceiveTrainingAllCount();
        map.put("list", list);
        map.put("currentPage", currentPage);
        map.put("totalPage", addCount);
        map.put("operation", "receive_training_model");
        map.put("URL", "/ReceiveTraining");
        return "employee/employee_list";
    }

    @GetMapping("/create")
    public String goReceiveTrainCreate(Map<String, Object> map){
        List<EmployeeInfo> list = employeeInfoService.selectList(null);
        map.put("employees", list);
        map.put("type", "create");
        map.put("operation", "receive_training_model");
        map.put("req_url", "/ReceiveTraining/add");
        return "employee/employee_create";
    }

    @GetMapping("/add")
    public String addReceiveTrain(ReceiveTraining receiveTraining, Map<String, Object> map){
        if (receiveTraining != null){
            receiveTrainingService.insertReceiveTraining(receiveTraining);
        }
        map.put("operat", "success");
        return "result/success";
    }

    @GetMapping("/update/{id}")
    public String goReceiveTrainUpdate(@PathVariable("id") Integer id, Map<String, Object> map){
        ReceiveTraining receiveTraining = receiveTrainingService.findReceiveTraining(id);
        List<EmployeeInfo> list = employeeInfoService.selectList(null);
        map.put("type", "update");
        map.put("operation", "receive_training_model");
        map.put("req_url", "/ReceiveTraining/update");
        map.put("employees", list);
        map.put("receiveTraining", receiveTraining);
        return "employee/employee_create";
    }

    @PostMapping("/update")
    public String updateReceiveTrain(ReceiveTraining receiveTraining, Map<String, Object> map){
        ReceiveTraining receiveTraining1 = receiveTrainingService.findReceiveTraining(receiveTraining.getTraId());
        if (receiveTraining1 == null){
            map.put("operat", "error");
            return "result/exception_error";
        }
        receiveTrainingService.updateReceiveTraining(receiveTraining);
        map.put("operat", "success");
        return "result/success";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteReceiveTrain(@PathVariable("id") Integer id, Map<String, Object> map){
        ReceiveTraining receiveTraining = receiveTrainingService.findReceiveTraining(id);
        if (receiveTraining != null){
            receiveTrainingService.deleteReceiveTraining(id);
        }
        map.put("operat", "success");
        return "result/success";
    }

    @DeleteMapping("/batchDelete")
    public String batchDeleteBirth(@RequestParam("data_id") String data_id, Map<String, Object> map){
        String[] id = data_id.split(",");
        for (int i = 0; i < id.length; i++){
            ReceiveTraining receiveTraining = receiveTrainingService.findReceiveTraining(Integer.parseInt(id[i]));
            if (receiveTraining != null){
                receiveTrainingService.deleteReceiveTraining(Integer.parseInt(id[i]));
            }
        }
        return "result/success";
    }

    @PostMapping("/search")
    public String searchBirthRecord(@RequestParam("data") String data, Map<String, Object> map){
        List<ReceiveTraining> list = receiveTrainingService.findAllReceiveTrainingBySearch(data);
        map.put("list", list);
        map.put("operation", "receive_training_model");
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
                ReceiveTraining professionalSkills = new ReceiveTraining();
                //一个工具类，把字符串数组数据封装到实体类对象中，第一个参数为实体类对象，第二个参数为字符串数组
                ExcelValuesHelperUtils.setAttributeValue(professionalSkills, str);

                /**
                 * 在完成Excel表中数据写入数据库操作之前先判断
                 * 该实体类对象的是否为数据库已有（进行更新操作）
                 * 该实体类对象的数据为数据库没有（进行插入操作）
                 */
                if (receiveTrainingService.findReceiveTraining(Integer.parseInt(str[0])) != null){
                    receiveTrainingService.updateReceiveTraining(professionalSkills);
                } else {
                    receiveTrainingService.insertReceiveTraining(professionalSkills);
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
        List<ReceiveTraining> list1 = receiveTrainingService.selectList(null);
        //一个设置Excel表标题信息的工具类，获取Excel表标题的字符串数组
        String[] strings = ExcelTitlesHelperUtils.getReceiveTrainingTitles();
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

