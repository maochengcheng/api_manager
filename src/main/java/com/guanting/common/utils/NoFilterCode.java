package com.guanting.common.utils;

import com.guanting.common.constant.Constant;

import java.util.ArrayList;
import java.util.List;


/**
 * 不被过滤的状态码集合
 */
public class NoFilterCode {


    public static List<String> noFilterCodes;


    static {

        noFilterCodes = new ArrayList<>();


        noFilterCodes.add(Constant.NoFileCodes.rl);
        noFilterCodes.add(Constant.NoFileCodes.zc);

    }
}
