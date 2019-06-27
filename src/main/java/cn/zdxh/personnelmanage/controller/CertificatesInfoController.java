package cn.zdxh.personnelmanage.controller;


import cn.zdxh.personnelmanage.enums.ResultEnum;
import cn.zdxh.personnelmanage.exception.MyException;
import cn.zdxh.personnelmanage.po.BirthdayRecord;
import cn.zdxh.personnelmanage.po.CertificatesInfo;
import cn.zdxh.personnelmanage.po.Contraceptive;
import cn.zdxh.personnelmanage.po.EmployeeInfo;
import cn.zdxh.personnelmanage.service.CertificatesInfoService;
import cn.zdxh.personnelmanage.service.EmployeeInfoService;
import cn.zdxh.personnelmanage.utils.*;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 证件情况表 前端控制器
 * </p>
 *
 * @author Justin
 * @since 2019-03-15
 */
@Controller
@RequestMapping("/CertificatesInfo")
public class CertificatesInfoController {

    @Autowired
    private CertificatesInfoService certificatesInfoService;
    @Autowired
    private EmployeeInfoService employeeInfoService;

    @GetMapping("/list")
    public String findCertificates(@RequestParam(value = "currentPage", defaultValue = "0") Integer currentPage, @RequestParam(value = "limit", defaultValue = "3") Integer limit, Map<String, Object> map){
        List<CertificatesInfo> list = certificatesInfoService.findCertificatesInfoAll(currentPage, limit);
        System.out.println(list);
        Integer addCount = certificatesInfoService.findCertificatesInfoAllCount();
        map.put("list", list);
        map.put("currentPage", currentPage);
        map.put("totalPage", limit);
        map.put("operation", "health_certificate_model");
        map.put("URL", "/CertificatesInfo");
        return "employee/employee_list";
    }

    @GetMapping("/create")
    public String goCertificationCreate(Map<String, Object> map, ContraceptiveUtils contraceptiveUtils){
        List<EmployeeInfo> list = employeeInfoService.selectList(null);
        List<Contraceptive> list1 = contraceptiveUtils.contraceptives();
        map.put("type", "create");
        map.put("employees", list);
        map.put("contraceptive", list1);
        map.put("operation", "health_certificate_model");
        map.put("req_url", "/CertificatesInfo/add");
        return "employee/employee_create";
    }

    @GetMapping("/add")
    public String addCertification(CertificatesInfo certificatesInfo, Map<String, Object> map){

        if (certificatesInfo != null){
            System.out.println("certificatesInfo："+certificatesInfo);
            certificatesInfoService.insertCertificatesInfo(certificatesInfo);
        }
        map.put("operat", "success");
        return "result/success";
    }

    @GetMapping("/update/{id}")
    public String goCertificationUpda(@PathVariable("id") Integer id, Map<String, Object> map, ContraceptiveUtils contraceptiveUtils){
        CertificatesInfo certificatesInfo = certificatesInfoService.findCertificatesInfo(id);
        List<EmployeeInfo> list = employeeInfoService.selectList(null);
        List<Contraceptive> list1 = contraceptiveUtils.contraceptives();
        map.put("type", "update");
        map.put("operation", "health_certificate_model");
        map.put("req_url", "/CertificatesInfo/update");
        map.put("employees", list);
        map.put("contraceptive", list1);
        map.put("certificatesInfo", certificatesInfo);
        return "employee/employee_create";
    }

    @PostMapping("/update")
    public String updateCertification(CertificatesInfo certificatesInfo, Map<String, Object> map){
        CertificatesInfo certificatesInfo1 = certificatesInfoService.findCertificatesInfo(certificatesInfo.getCerId());
        if (certificatesInfo1 != null){
            certificatesInfoService.updateCertificatesInfo(certificatesInfo);
        }
        map.put("operat", "success");
        return "result/success";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteCertification(@PathVariable("id") Integer id, Map<String, Object> map){
        CertificatesInfo certificatesInfo = certificatesInfoService.findCertificatesInfo(id);
        if (certificatesInfo != null){
            certificatesInfoService.deleteCertificatesInfo(id);
        }
        map.put("operat", "success");
        return "result/success";
    }

    @DeleteMapping("/batchDelete")
    public String batchDeleteBirth(@RequestParam("data_id") String data_id, Map<String, Object> map){
        String[] id = data_id.split(",");
        for (int i = 0; i < id.length; i++){
            CertificatesInfo certificatesInfo = certificatesInfoService.findCertificatesInfo(Integer.parseInt(id[i]));
            if (certificatesInfo != null){
                certificatesInfoService.deleteCertificatesInfo(Integer.parseInt(id[i]));
            }
        }
        return "result/success";
    }

    @PostMapping("/search")
    public String searchBirthRecord(@RequestParam("data") String data, Map<String, Object> map){
        List<CertificatesInfo> list = certificatesInfoService.findAllCertificatesInfoBySearch(data);
        map.put("list", list);
        map.put("operation", "health_certificate_model");
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
                CertificatesInfo certificatesInfo = new CertificatesInfo();
                //一个工具类，把字符串数组数据封装到实体类对象中，第一个参数为实体类对象，第二个参数为字符串数组
                ExcelValuesHelperUtils.setAttributeValue(certificatesInfo, str);

                /**
                 * 在完成Excel表中数据写入数据库操作之前先判断
                 * 该实体类对象的是否为数据库已有（进行更新操作）
                 * 该实体类对象的数据为数据库没有（进行插入操作）
                 */
                if (certificatesInfoService.findCertificatesInfo(Integer.parseInt(str[0])) != null){
                    certificatesInfoService.updateCertificatesInfo(certificatesInfo);
                } else {
                    certificatesInfoService.insertCertificatesInfo(certificatesInfo);
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
        List<CertificatesInfo> list1 = certificatesInfoService.selectList(null);
        //一个设置Excel表标题信息的工具类，获取Excel表标题的字符串数组
        String[] strings = ExcelTitlesHelperUtils.getCertificatesInfoTitles();
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

