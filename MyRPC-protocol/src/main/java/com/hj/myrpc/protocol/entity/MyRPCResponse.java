package com.hj.myrpc.protocol.entity;

import com.hj.myrpc.protocol.annotation.MyEntity;
import com.hj.myrpc.protocol.annotation.MyField;

@MyEntity
public class MyRPCResponse {
    @MyField(1)
    private String traceId;

    @MyField(2)
    private int code;

    @MyField(3)
    private String errorMsg;

    @MyField(4)
    private Object result;


    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "MyRPCResponse{" +
                "traceId='" + traceId + '\'' +
                ", code=" + code +
                ", errorMsg='" + errorMsg + '\'' +
                ", result=" + result +
                '}';
    }
}


