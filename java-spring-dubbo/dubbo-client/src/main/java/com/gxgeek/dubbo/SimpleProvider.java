package com.gxgeek.dubbo;

public interface SimpleProvider {

    public Result getSimpleInfo();
    public String getSimpleInfoName(String name);
    public String getSimpleInfoName(Result result,String name);
    public String getSimpleInfo(String name,String method);
}
