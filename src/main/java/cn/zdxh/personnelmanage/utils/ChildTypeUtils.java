package cn.zdxh.personnelmanage.utils;

import cn.zdxh.personnelmanage.po.ChildNumer;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChildTypeUtils {

    /**
     * 提供一个可供选择生育孩子数量的方法
     */
    public List<Object> childTypeMap(){
        List<Object> list = new ArrayList<>();
        list.add(new ChildNumer(list.size() + 1, "未生育"));
        list.add(new ChildNumer(list.size() + 1, "首胎"));
        list.add(new ChildNumer(list.size() + 1, "二胎"));
        list.add(new ChildNumer(list.size() + 1, "三胎"));
        list.add(new ChildNumer(list.size() + 1, "三胎以上"));
        return list;
    }

}
