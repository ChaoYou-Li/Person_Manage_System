package cn.zdxh.personnelmanage.exception;

/**
 * 自定义异常管理
 */
public class MyException extends RuntimeException {

    //增加一个错误码
    private Integer code;

    public MyException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
