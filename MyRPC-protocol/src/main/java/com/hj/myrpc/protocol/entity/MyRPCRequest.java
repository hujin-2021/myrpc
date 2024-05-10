package com.hj.myrpc.protocol.entity;

import com.hj.myrpc.protocol.annotation.MyEntity;
import com.hj.myrpc.protocol.annotation.MyField;

import java.util.Arrays;
import java.util.List;

@MyEntity
public class MyRPCRequest {

    @MyField(1)
    private String traceId;

    @MyField(2)
    private String serviceName;

    @MyField(3)
    private String methodName;

    @MyField(4)
    private Class<?>[] paramTypes;

    @MyField(5)
    private Object[] params;
    public String getTraceId() {
        return traceId;
    }

    public void setTraceId(String traceId) {
        this.traceId = traceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParamTypes() {
        return paramTypes;
    }

    public void setParamTypes(Class<?>[] paramTypes) {
        this.paramTypes = paramTypes;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }



    @Override
    public String toString() {
        return "MyRPCRequest{" +
                "traceId='" + traceId + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", methodName='" + methodName + '\'' +
                ", paramTypes=" + Arrays.toString(paramTypes) +
                ", params=" + Arrays.toString(params) +
                '}';
    }

}
