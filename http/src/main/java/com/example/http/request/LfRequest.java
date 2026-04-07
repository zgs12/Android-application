package com.example.http.request;

import com.example.http.request.host.IRequest;
import com.example.http.annotation.RequestMethod;
import com.example.http.request.host.IHost;

public class LfRequest implements IRequest {
    protected IHost host;

    @RequestMethod
    protected int requestMethod;
}
