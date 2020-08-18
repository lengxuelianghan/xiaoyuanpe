package com.xiaoyuanpe.units;

import java.io.Serializable;

/**
 * @Author: wan
 * @Date: Created in 16:27 2019/9/17
 * @Description: 消息返回类，统一消息返回格式
 * @Modified By:
 */
public class ResultBean<T> implements Serializable {
    public static final long serialVersionUID = 1L;

    /**
     * 定义不同的状态码
     */
    public static final int SUCCESS = 0;
    public static final int FAILURE = -1;
    /**
     * 1***代表登录状态的问题
     * 1000 未登录
     * 1001 无访问权限
     */
    public static final int NO_LOGIN = 1000;
    public static final int UNAUTHORIZED = 1001;
    public static final int LOGIN_FAILED = 1002;
    public static final int NOT_EXIST_USER = 1003;
    public static final int EXIST_USER = 1004;
    public static final int UNKNOWN_EXCEPTION = -99;

    /**
     * 2*** 代表数据库错误
     */
    public static final int SQL_WRONG = 2001;
    public static final int SQL_EXIST = 2002;

    /**
     * 3*** 代表一些已知的错误
     */
    public static final int NULL_DATA_EXCEPTION = 3001;
    public static final int OVERTIME = 3002;

    private int code = SUCCESS;
    private String msg = "SUCCESS";
    private T data;
    private int total;

    public ResultBean() {
        super();
    }

    public ResultBean(T data) {
        super();
        this.data = data;
        this.code = SUCCESS;
        this.msg = "success";
    }

    public ResultBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultBean(T data, int code, String msg) {
        super();
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public ResultBean(T data, int code, String msg, int total) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.total = total;
    }

    public ResultBean(Throwable e) {
        super();
        this.msg = e.toString();
        this.code = UNKNOWN_EXCEPTION;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}