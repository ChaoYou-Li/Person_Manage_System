package cn.zdxh.personnelmanage.utils;

import cn.zdxh.personnelmanage.po.Admin;
import cn.zdxh.personnelmanage.po.EmployeeInfo;
import org.apache.poi.ss.formula.functions.T;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * excel表的值
 */
public class ExcelValuesHelperUtils {
    /**
     * Admin表
     * @param lists 数据库查出的总值
     * @param titlesSize excel表的行数
     * @return
     */
    public static String[][] getAdminValues(List<Admin> lists, int titlesSize){
        String[][] values=new String[lists.size()][titlesSize];
        for (int i = 0 ;i < lists.size() ;i++){
            Admin adm = lists.get(i);
            values[i][0]=String.valueOf(adm.getId());
            values[i][1]=adm.getUsername();
            values[i][2]=adm.getPassword();
            if (adm.getSign()==1){
                values[i][3]="系统管理员";
            }else {
                values[i][3]="人事管理员";
            }
        }
        return values;
    }

    /**
     * EmployeeInfo
     * @param lists
     * @param titlesSize
     * @return
     */
    public static String[][] getEmployeeInfoValues(List<EmployeeInfo> lists, int titlesSize) {
        String[][] values = new String[lists.size()][titlesSize];
        for (int i = 0; i < lists.size(); i++) {
            EmployeeInfo emp = lists.get(i);
            values[i][0] = String.valueOf(emp.getEmpId());
            values[i][1] = emp.getEmpName();
            if (emp.getEmpSex()==1){
                values[i][2]="男";
            }else {
                values[i][2]="女";
            }
            values[i][3] =emp.getEmpNation();
            values[i][4] = emp.getEmpNumber();
            values[i][5] = emp.getEmpBirthday().toString();
            values[i][6] = emp.getEmpCard();
            if (emp.getEmpMarry()==1){
                values[i][7]="已婚";
            }else {
                values[i][7]="未婚";
            }
            values[i][8] = emp.getEmpDepart();
            values[i][9] = emp.getEmpPic();
            values[i][10] = emp.getEmpPosition();
            values[i][11] = emp.getEmpSchool();
            values[i][12] = emp.getEmpPhone();
            values[i][13] = emp.getEmpEmail();
            values[i][14] = emp.getEmpSchool();
        }
        return values;
    }

    /**
     * 其他的excel表可以在此进行拓展。。。。。。。。。。
     */







    /**
     * 功能分析：把对象集合转换成数组集合
     *
     * @param list：需要操作的实体类集合
     * @return
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static List<Object[]> exportExcel(List list) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        //设置用到的变量参数
        String name = null, type = null, m_name = null;
        Object value = null;
        //创建一个二维字符串数组存放数据
        List<Object[]> list1 = new ArrayList<>();
        //获取实体类方法操作对象
        Method m = null;
        //判断要提取实体类属性数据的集合是否为空
        if (list != null){
            //遍历集合中的实体类
            for (int y=0; y<list.size(); y++){
                //获取每一个实体类
                Object object = list.get(y);
                //获取实体类的所有属性，返回Field数组
                Field[] fields = object.getClass().getDeclaredFields();
                //创建一个数组存放实体类属性数据
                Object[] str = new Object[fields.length];
                //遍历实体类的所有属性
                for (int i=0; i<fields.length; i++){
                    name = fields[i].getName();//获取属性的名字
                    m_name = name.substring(0,1).toUpperCase()+name.substring(1); //将属性的首字符大写，方便构造get，set方法
                    type = fields[i].getGenericType().toString();    //获取属性的类型
                    //判断属性的类型修改数据结构
                    switch (type){
                        case "class java.lang.String":
                            m = object.getClass().getMethod("get"+m_name);  //组装getter方法
                            value = (String) m.invoke(object);    //调用getter方法获取属性值
                            if (value != null){
                                /**
                                 * 你可以进行附加操作
                                 */
                            }
                            break;
                        case "class java.lang.Double":
                            m = object.getClass().getMethod("get"+m_name);
                            value =  m.invoke(object);    //调用getter方法获取属性值
                            if (value != null){
                            }
                            break;
                        case "class java.lang.Boolean":
                            m = object.getClass().getMethod("get"+m_name);  //组装getter方法
                            value = m.invoke(object);    //调用getter方法获取属性值
                            if (value != null){
                            }
                            break;
                        case "class java.lang.Integer":
                            m = object.getClass().getMethod("get"+m_name);
                            value = m.invoke(object); //调用getter方法获取属性值
                            if (value != null){

                            }
                            break;
                        case "class java.util.Date":
                            m = object.getClass().getMethod("get"+m_name);
                            value = m.invoke(object);    //调用getter方法获取属性值
                            if (value != null){
                                value = new SimpleDateFormat("yyyy-MM-dd").format(value);//改变时间的格式
                            }
                            break;
                        case "class java.lang.Float":
                            m = object.getClass().getMethod("get"+m_name);
                            value = m.invoke(object);    //调用getter方法获取属性值
                            if (value != null){
                            }
                            break;
                        case "class java.lang.Long":
                            m = object.getClass().getMethod("get"+m_name);
                            value = m.invoke(object);    //调用getter方法获取属性值
                            if (value != null){
                            }
                            break;
                        case "class java.lang.Byte":
                            m = object.getClass().getMethod("get"+m_name);
                            value = m.invoke(object);    //调用getter方法获取属性值
                            if (value != null){

                            }
                            break;
                    }
                    //把实体类中的属性存放到一个字符串数组中
                    str[i] = value;
                }
                //把字符串数组存放到集合中
                list1.add(str);
            }
        }
        return list1;
    }


    /**
     * 功能分析：第一个参数为对象根据该对象中的属性设置一个对象数组，把第二个数组中的数据赋值给对象属性数组中的元素（为对象属性赋值）
     *
     * @param object
     * @param str
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws ParseException
     */
    public static void setAttributeValue(Object object, Object [] str) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ParseException {
        //设置用到的变量参数
        String name = null, type = null, m_name = null;
        //获取实体类方法操作对象
        Method m = null;
        Object value = null;
        Field[] field = object.getClass().getDeclaredFields();
        for (int i=1; i<field.length; i++){
            name = field[i].getName();//获取属性的名字
            name = name.substring(0,1).toUpperCase()+name.substring(1); //将属性的首字符大写，方便构造get，set方法
            type = field[i].getGenericType().toString();    //获取属性的类型
            //判断属性的类型修改数据结构
            switch (type){
                case "class java.lang.String":
                    m = object.getClass().getMethod("get"+name);
                    value = (String) m.invoke(object);    //调用getter方法获取属性值
                    if (value == null){
                        m = object.getClass().getMethod("set"+name,String.class);  //组装setter方法
                        m.invoke(object, str[i-1].toString());      //为属性数组元素赋值
                    }
                    break;
                case "class java.lang.Double":
                    m = object.getClass().getMethod("get"+name);
                    value =  m.invoke(object);    //调用getter方法获取属性值
                    if (value == null){
                        m = object.getClass().getMethod("set"+name,Double.class);
                        m.invoke(object, Double.parseDouble(str[i-1].toString()));
                    }
                    break;
                case "class java.lang.Boolean":
                    m = object.getClass().getMethod("get"+name);
                    value = m.invoke(object);    //调用getter方法获取属性值
                    if (value == null){
                        m = object.getClass().getMethod("set"+name,Boolean.class);
                        m.invoke(object, Boolean.parseBoolean(str[i-1].toString()));
                    }
                    break;
                case "class java.lang.Integer":
                    m = object.getClass().getMethod("get"+name);
                    value = m.invoke(object); //调用getter方法获取属性值
                    if (value == null){
                        m = object.getClass().getMethod("set"+name,Integer.class);
                        m.invoke(object, Integer.parseInt(str[i-1].toString()));
                    }
                    break;
                case "class java.util.Date":
                    m = object.getClass().getMethod("get"+name);
                    value = m.invoke(object);    //调用getter方法获取属性值
                    if (value == null){
                        m = object.getClass().getMethod("set"+name,Date.class);
                        m.invoke(object, new SimpleDateFormat("yyyy-MM-dd").parse(str[i-1].toString()));
                    }
                    break;
                case "class java.lang.Float":
                    m = object.getClass().getMethod("get"+name);
                    value = m.invoke(object);    //调用getter方法获取属性值
                    if (value == null){
                        m = object.getClass().getMethod("set"+name,Float.class);
                        m.invoke(object, Float.parseFloat(str[i-1].toString()));
                    }
                    break;
                case "class java.lang.Long":
                    m = object.getClass().getMethod("get"+name);
                    value = m.invoke(object);    //调用getter方法获取属性值
                    if (value == null){
                        m = object.getClass().getMethod("set"+name,Long.class);
                        m.invoke(object, Long.parseLong(str[i-1].toString()));
                    }
                    break;
                case "class java.lang.Byte":
                    m = object.getClass().getMethod("get"+name);
                    value = m.invoke(object);    //调用getter方法获取属性值
                    if (value == null){
                        m = object.getClass().getMethod("set"+name,Byte.class);
                        m.invoke(object, Byte.parseByte(str[i-1].toString()));
                    }
                    break;
            }
        }
    }



}
