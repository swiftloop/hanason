package com.framework.hanason.common.exception;


import com.framework.hanason.common.domain.ResultData;

/**
 * @author sorata 2020-03-16 11:31
 */
public class RootRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -5487618678927241218L;
    /**
     * 描述信息
     */
    private String msg;
    /**
     * 状态码
     */
    private Integer code;

    public RootRuntimeException(Integer code,String message){
        super(message);
        this.code = code;
        this.msg = message;
    }

    public String getMsg() {
        return msg;
    }

    public Integer getCode() {
        return code;
    }

    public ResultData toResult(){
        return ResultData.err(this.code,this.msg);
    }

}
