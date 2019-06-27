package cn.zdxh.personnelmanage.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 图片路径读取类
 */
@Component
@ConfigurationProperties(prefix = "pic")
public class PathInfo {
    /**
     * 图片访问路径
     */
    private String visitPath;

    /**
     * 图片存储路径
     */
    private String savePath;

    public String getVisitPath() {
        return visitPath;
    }

    public void setVisitPath(String visitPath) {
        this.visitPath = visitPath;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }
}
