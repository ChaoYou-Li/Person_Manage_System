package cn.zdxh.personnelmanage.service.impl;

import cn.zdxh.personnelmanage.dto.PathInfo;
import cn.zdxh.personnelmanage.service.UploadService;
import cn.zdxh.personnelmanage.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class UploadServiceImpl implements UploadService {

    @Autowired
    private PathInfo pathInfo; //保存路径的对象


    @Override
    public String upload(MultipartFile multipartFile) throws IOException {
        String visitPath = pathInfo.getVisitPath();//访问路径
        String savePath = pathInfo.getSavePath();//存储路径
        //重命名文件名
        String fileName= UploadUtils.getFileName(multipartFile.getOriginalFilename());
        //存放图片的地方
        File file = new File(savePath+fileName);
        if (!file.getParentFile().exists()){
            file.getParentFile().mkdirs();
        }
        //上传图片的操作
        multipartFile.transferTo(file);
        return visitPath+fileName;
    }
}
