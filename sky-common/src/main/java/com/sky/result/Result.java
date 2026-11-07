package com.sky.result;

public class Result<T> {
    private Integer code;//编码
    private String msg;//错误信息
    private T data;//数据

    public static <T> Result<T> success(T data) {
        Result<T> result=new Result<T>();//局部变量只在{}里面有效
        result.code=1;
        result.data=data;
        return result;
    }
    public static <T> Result<T> success(){
        Result<T> result=new Result<T>();
        result.code=1;
        return result;
    }

    public static <T> Result<T> error(String msg){
        Result<T> result=new Result<T>();
        result.msg=msg;
        result.code=0;
        return result;
    }


}
