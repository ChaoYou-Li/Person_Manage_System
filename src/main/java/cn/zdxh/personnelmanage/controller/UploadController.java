package cn.zdxh.personnelmanage.controller;

import cn.zdxh.personnelmanage.service.UploadService;
import cn.zdxh.personnelmanage.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 图片上传控制器
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;


    @PostMapping("/pic")
    @ResponseBody
    public Map<String,Object> upload(@RequestParam("file") MultipartFile multipartFile) throws IOException {
        //返回图片的存储路径
        String filePath = uploadService.upload(multipartFile);
        Map<String ,Object> map= new HashMap<>();
        map.put("data",filePath);//这里的data名要对应layui框架的js取值
        return map;
    }

    @GetMapping("/show")
    public String show(){
        return "upload";
    }
}
