package com.example.http;

import com.example.http.request.host.IRequest;

import java.util.Map;

public class LfHttpTask {
    public Object execute(IRequest request, Map<String, Object> params) {
        return HttpHelper.execute(request, params);
    }

}
