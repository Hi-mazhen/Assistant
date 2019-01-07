/**
 * Copyright (C), 2016-2019, 码农团
 * ClassName: FrameF2A
 * Author:   hthn
 * Date:     2019-01-07 16:15
 * Description: 上行数据，现场设备到小助手的数据帧格式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mzh.assistant.entity;

import org.joou.UInteger;

/**
 * 〈一句话功能简述〉<br> 
 * 〈上行数据，现场设备到小助手的数据帧格式〉
 *
 * @author hthn
 * @create 2019-01-07
 * @since 1.0.0
 */
public class FrameF2A {
    private UInteger mHead = UInteger.valueOf(0xAA55AA55);
    private short mNum = 0;
    private short mA1 = 0;
    private short mA2 = 0;
    private short mA3 = 0;
    private short mAFN = 0;




}
