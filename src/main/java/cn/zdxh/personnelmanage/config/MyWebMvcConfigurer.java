package cn.zdxh.personnelmanage.config;

import cn.zdxh.personnelmanage.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Spring MVC的相关配置
 */

@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer{

    /**
     * 配置登录拦截器,为开发简便，暂时注销
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginInterceptor loginInterceptor = new LoginInterceptor();
//            //注册拦截器，并添加拦截路径
            registry.addInterceptor(loginInterceptor).addPathPatterns("/admin/*","/employee/*","/excel/*","/BirthdayRecord/*","/CertificatesInfo/*","/ContractSign/*","/EmployeeCard/*","/InductionInfo/*","/FamilyInfo/*","/FreeCharge/*","/ProfessionalSkills/*","/ProvidentFundPurchase/*","/PurchaseInsurance/*","/ReceiveTraining/*","/RetireInfo/*");
//            //TODO
    }
}
