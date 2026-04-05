package com.example.myapplication.main.tools;

import static com.example.myapplication.main.tools.MainConstantTool.BEIJING;
import static com.example.myapplication.main.tools.MainConstantTool.HANGZHOU;
import static com.example.myapplication.main.tools.MainConstantTool.SHANHAI;
import static com.example.myapplication.main.tools.MainConstantTool.SHENZHEN;

import androidx.annotation.IntDef;

@IntDef({SHANHAI, HANGZHOU, BEIJING, SHENZHEN})

public @interface MainConstantTool {
    int SHANHAI = 0;
    int HANGZHOU = 1;
    int BEIJING = 2;
    int SHENZHEN = 3;
}

