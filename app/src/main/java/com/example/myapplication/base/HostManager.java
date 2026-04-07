package com.example.myapplication.base;

import com.example.http.request.host.IHost;

public interface HostManager {
    IHost jhHost = new IHost() {

        @Override
        public String getHost() {
            return "www.baidu.com";
        }

        @Override
        public String getDefaultPath() {
            return "/abc";
        }
    };
}
