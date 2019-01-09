/**
 * Copyright (C), 2016-2019, 码农团
 * ClassName: NumberUtil
 * Author:   hthn
 * Date:     2019-01-09 18:24
 * Description: 数字转换
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mzh.assistant.utils;

/**
 * 〈一句话功能简述〉<br>
 * 〈数字转换〉
 *
 * @author hthn
 * @create 2019-01-09
 * @since 1.0.0
 */
public class NumberUtil {

    public static byte getByteFromShort(short data, int index, boolean isBigend) {
        byte[] bytes = short2Bytes(data, isBigend);
        return bytes[index];
    }

    public static byte[] short2Bytes(short data, boolean isBigend) {
        byte[] bytes = new byte[2];
        if (isBigend) {
            bytes[1] = (byte) (data & 0xFF);
            bytes[0] = (byte) ((data >> 8) & 0xFF);

        } else {
            bytes[0] = (byte) (data & 0xFF);
            bytes[1] = (byte) ((data >> 8) & 0xFF);
        }
        return bytes;
    }

    public static byte getByteFromInt(int data, int index, boolean isBigend) {
        byte[] bytes = int2Bytes(data, isBigend);
        return bytes[index];
    }

    public static byte[] int2Bytes(int data, boolean isBigend) {
        byte[] bytes = new byte[4];
        if (isBigend) {
            bytes[3] = (byte) (data & 0xFF);
            bytes[2] = (byte) ((data >> 8) & 0xFF);
            bytes[1] = (byte) ((data >> 16) & 0xFF);
            bytes[0] = (byte) ((data >> 24) & 0xFF);

        } else {
            bytes[0] = (byte) (data & 0xFF);
            bytes[1] = (byte) ((data >> 8) & 0xFF);
            bytes[2] = (byte) ((data >> 16) & 0xFF);
            bytes[3] = (byte) ((data >> 24) & 0xFF);
        }
        return bytes;
    }
}
