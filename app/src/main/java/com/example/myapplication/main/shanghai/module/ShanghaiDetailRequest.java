package com.example.myapplication.main.shanghai.module;

import com.example.http.request.host.IRequest;
import com.example.http.annotation.RequestMethod;
import com.example.myapplication.base.JHRequest;

public interface ShanghaiDetailRequest {
    IRequest XiaoHuaRequest = JHRequest.sendHttpRequest("", RequestMethod.Get);
}
