/**
 * Copyright (C), 2016-2019, 码农团
 * ClassName: FrameA2F
 * Author:   hthn
 * Date:     2019-01-07 16:14
 * Description: 下行数据，小助手到现场设备的数据帧格式
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mzh.assistant.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈下行数据，小助手到现场设备的数据帧格式〉
 *
 * @author hthn
 * @create 2019-01-07
 * @since 1.0.0
 */
public class FrameA2F {
    private int head = 0xAA55AA55;
    private short num = 0;
    private short a1 = 0;
    private short a2 = 0;
    private byte a3 = 0;
    private byte afn = 0;
    private List<Short> dataA = new ArrayList<>();
    private List<Short> dataT = new ArrayList<>();
    private int dc = 0;
    private int cc = 0;
    private int tp = 0;
    private Short crc = 0;

    public int getHead() {
        return head;
    }

    public void setHead(int head) {
        this.head = head;
    }

    public short getNum() {
        return num;
    }

    public void setNum(short num) {
        this.num = num;
    }

    public short getA1() {
        return a1;
    }

    public void setA1(short a1) {
        this.a1 = a1;
    }

    public short getA2() {
        return a2;
    }

    public void setA2(short a2) {
        this.a2 = a2;
    }

    public byte getA3() {
        return a3;
    }

    public void setA3(byte a3) {
        this.a3 = a3;
    }

    public byte getAfn() {
        return this.afn;
    }

    public void setAfn(byte afn) {
        this.afn = afn;
    }

    public List<Short> getDataA() {
        return dataA;
    }

    public void setDataA(List<Short> dataA) {
        this.dataA = dataA;
    }

    public List<Short> getDataT() {
        return dataT;
    }

    public void setDataT(List<Short> dataT) {
        this.dataT = dataT;
    }

    public int getDc() {
        return dc;
    }

    public void setDc(int dc) {
        this.dc = dc;
    }

    public int getCc() {
        return cc;
    }

    public void setCc(int cc) {
        this.cc = cc;
    }

    public int getTp() {
        return tp;
    }

    public void setTp(int tp) {
        this.tp = tp;
    }

    public Short getCrc() {
        return crc;
    }

    public void setCrc(Short crc) {
        this.crc = crc;
    }
}
