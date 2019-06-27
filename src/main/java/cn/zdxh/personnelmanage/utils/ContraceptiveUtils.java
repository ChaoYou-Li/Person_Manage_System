package cn.zdxh.personnelmanage.utils;

import cn.zdxh.personnelmanage.po.Contraceptive;

import java.util.ArrayList;
import java.util.List;

public class ContraceptiveUtils {
    /**
     * 功能需求：提供一个避孕措施的数据集合
     * @return
     */
    public List<Contraceptive> contraceptives(){
        List<Contraceptive> list = new ArrayList<>();
        list.add(new Contraceptive(list.size() + 1, "避孕套"));
        list.add(new Contraceptive(list.size() + 1, "避孕药"));
        list.add(new Contraceptive(list.size() + 1,"避孕环"));
        list.add(new Contraceptive(list.size() + 1, "结扎"));
        list.add(new Contraceptive(list.size() + 1, "其他"));
        return list;
    }
}
