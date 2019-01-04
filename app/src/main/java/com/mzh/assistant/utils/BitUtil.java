/**
 * Copyright (C), 2016-2019, 码农团
 * ClassName: BitOper
 * Author:   hthn
 * Date:     2019-01-04 11:29
 * Description: 位操作类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mzh.assistant.utils;

/**
 * 〈一句话功能简述〉<br> 
 * 〈位操作类〉
 *
 * @author hthn
 * @create 2019-01-04
 * @since 1.0.0
 */
public class BitUtil {
    /**
     * 获取from ~ to的to - from位
     *
     */
    public static int getBits(int data, int from, int to){
        int value = (int)Math.pow(2.0, (double) (to - from + 1)) - 1;
        int tmp = value << from;
        return ((data & tmp) >> from);
    }

    /**
     * 获取高4位
     *
     */
    public static int getHeight4(int data){
        int height;
        height = ((data & 0xF0) >> 4);
        return height;
    }

    /**
     * 获取低4位
     *
     */
    public static int getLow4(int data){
        int low;
        low = (data & 0x0F);
        return low;
    }

}
