package com.example.http.annotation;

import static com.example.http.annotation.RequestMethod.Get;
import static com.example.http.annotation.RequestMethod.Post;

import androidx.annotation.IntDef;

@IntDef({Get, Post})
public @interface RequestMethod {
    int Get = 1;
    int Post = 2;
}
