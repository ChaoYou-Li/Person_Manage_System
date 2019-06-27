package cn.zdxh.personnelmanage.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UploadService {
    public String upload(MultipartFile multipartFile) throws IOException;
}
