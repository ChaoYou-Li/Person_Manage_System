package cn.zdxh.personnelmanage.utils;

/**
 * excel表的行名
 */
public class ExcelTitlesHelperUtils {
    /**
     * Admin
     * @return
     */
    public static String[] getAdminTitles(){
        String[] titles = {"ID","用户名","密码","管理员"};
        return titles;
    }

    /**
     * EmployeeInfo
     * @return
     */
    public static String[] getEmployeeInfoTitles(){
        String[] titles = {"ID","员工名","性别","民族","工号","生日","身份证","是否结婚","部门",
                "个人图片","职位","毕业院校","电话号码","Email","地址"};
        return titles;
    }

    /**
     * 一个提供设置Excel表标题内容的字符串数组
     * @return
     */
    public static String[] getBirthdayRecordTitles(){
        String[] titles = {"ID","头胎/其他胎","产检医院","分娩医院","计生证号码","手术日期","员工外键"};
        return titles;
    }

    public static String[] getCertificatesInfoTitles(){
        String[] titles = {"ID","健康证办理时间","健康证到期时间","健康证机构","健康证是否持有原件 1只有 0没有","计生证编号","计生证户籍地", "计生证避孕措施", "计生证居住地", "计生部门电话", "计生证有效时间", "标记是健康证还是计生证 1健康 2计生", "员工外键"};
        return titles;
    }

    public static String[] getContractSignTitles(){
        String[] titles = {"ID","合同类型","合同到期时间","合同历史签订情况", "员工外键"};
        return titles;
    }

    public static String[] getEmployeeCardTitles(){
        String[] titles = {"ID","工作证办理日期","工作证过期时间", "员工外键"};
        return titles;
    }

    public static String[] getFamilyInfoTitles(){
        String[] titles = {"ID","姓名","关系", "性别 1为男  2为女", "工作单位", "联系电话", "标记是何种情况 1父母 2配偶 3子女 4紧急", "员工外键"};
        return titles;
    }

    public static String[] getFreeChargeTitles(){
        String[] titles = {"ID","原持卡片类型 1临时卡 2钱包卡","卡号", "0默认为新办 1为续办（修改过数据即为续办）", "员工外键"};
        return titles;
    }

    public static String[] getInductionInfoTitles(){
        String[] titles = {"ID","入职时间","离职时间", "历史就职纪录", "员工外键"};
        return titles;
    }

    public static String[] getProfessionalSkillsTitles(){
        String[] titles = {"ID","专业技能","技能级别", "证书发证日期", "证书号", "员工外键"};
        return titles;
    }

    public static String[] getProvidentFundPurchaseTitles(){
        String[] titles = {"ID","公积金购买时间","公积金停买时间", "员工外键"};
        return titles;
    }

    public static String[] getPurchaseInsuranceTitles(){
        String[] titles = {"ID","购保时间","停保时间","个人电脑号", "员工外键"};
        return titles;
    }

    public static String[] getReceiveTrainingTitles(){
        String[] titles = {"ID","领过的补助","获得过的奖励", "员工外键"};
        return titles;
    }

    public static String[] getRetireInfoTitles(){
        String[] titles = {"ID","姓名","性别 1为男 2为女", "民族", "生日", "身份证号码", "银行卡", "电话号码", "居住地", "紧急电话"};
        return titles;
    }



}
