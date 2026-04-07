package com.example.myapplication.base;

import com.example.http.request.host.IRequest;
import com.example.http.annotation.RequestMethod;
import com.example.http.request.LfRequest;

public class JHRequest extends LfRequest {
    public  static IRequest sendHttpRequest(String path, @RequestMethod int requestMethod){
        JHRequest request = new JHRequest();
        request.host = HostManager.jhHost;
        request.requestMethod = requestMethod;
        return request;
    }
}
