package com.example.myapplication.main.shanghai.module;

import com.example.http.LfHttpTask;

import java.util.HashMap;
import java.util.Map;

public class ShanghaiDetailHttpTask extends LfHttpTask {
    public Object getXiaoHuaList(String sort, String page, String pagesize){
        Map<String, Object> params = new HashMap<>();
        params.put("sort", sort);
        params.put("page", page);
        params.put("pagesize", pagesize);
        return super.execute(ShanghaiDetailRequest.XiaoHuaRequest,params);
    }

}
