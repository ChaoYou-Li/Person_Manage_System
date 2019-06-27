package cn.zdxh.personnelmanage.enums;

/**
 * 统一错误管理
 * 给自定义异常使用
 * 需要根据业务场景来添加相应的枚举类型。。。。。。。可扩展
 */
public enum ResultEnum {

    CHECK_ERROR(10,"填写内容不正确"),
    EMP_NOT_EXIST(11,"此员工不存在"),
    INSERT_FAIL(12,"数据插入操作失败"),
    DELETE_ERROR(13, "数据删除操作失败"),
    UPDATE_ERROR(14, "数据更新操作失败"),
    SELECT_ERROR(15, "数据查询操作失败"),
    EXPORT_EXCEL_ERROR(16, "Excel表导出操作发送错误"),
    UPDATE_EXCEL_ERROR(17,"Excel表上传操作发生错误"),
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }


}
