package cn.zdxh.personnelmanage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String index(){
        return "index";
    }


    @PostMapping("/DeleteUitls/delete")
    public void getData_id(HttpServletRequest request, @RequestParam("data_id") String data_id){
        request.getSession().setAttribute("data_id", data_id);
    }
}
