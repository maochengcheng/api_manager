package com.guanting.common.utils;

import java.util.Random;


public class RandomNumberUtil {
    //生成1到total 无序 的 随机数组
    public static int[] getNumber(int total){
        //容器A
        int[] NumberBox = new int[total];
        //容器B
        int[] rtnNumber = new int[total];
        for (int i = 0; i < total; i++){
            //先把N个数放入容器A中
            NumberBox[i] = i+1;
        }
        int end = total - 1;
        for (int j = 0; j < total; j++){
            //取随机数
            int num = new Random().nextInt(end + 1);
            //把随机数放入容器B
            rtnNumber[j] = NumberBox[num];
            //把容器A中最后一个数覆盖所取的随机数
            NumberBox[num] = NumberBox[end];
            //缩小随机数所取范围
            end--;
        }
        //返回int型数组
        return rtnNumber;
    }


    //生成from到total+from-1 无序 的 随机数组
    public static int[] getNumber2(int from,int total){
        //容器A
        int[] NumberBox = new int[total];
        //容器B
        int[] rtnNumber = new int[total];
        for (int i = 0; i < total; i++){
            //先把N个数放入容器A中
            NumberBox[i] = i+from;
        }
        int end = total - 1;
        for (int j = 0; j < total; j++){
            //取随机数
            int num = new Random().nextInt(end + 1);
            //把随机数放入容器B
            rtnNumber[j] = NumberBox[num];
            //把容器A中最后一个数覆盖所取的随机数
            NumberBox[num] = NumberBox[end];
            //缩小随机数所取范围
            end--;
        }
        //返回int型数组
        return rtnNumber;
    }
}
