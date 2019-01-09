/**
 * Copyright (C), 2016-2019, 码农团
 * ClassName: PackFrame
 * Author:   hthn
 * Date:     2019-01-09 14:39
 * Description: 下行Frame打包
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.mzh.assistant.protocol;

import com.mzh.assistant.entity.FrameA2F;
import com.mzh.assistant.utils.NumberUtil;

import java.util.ArrayList;

/**
 * 〈一句话功能简述〉<br>
 * 〈下行Frame打包〉
 *
 * @author hthn
 * @create 2019-01-09
 * @since 1.0.0
 */
public class PackFrame {
    private ArrayList<Byte> mByteList = new ArrayList<Byte>();
    private FrameA2F mFrame = new FrameA2F();

    PackFrame () {
        mByteList.clear();
    }

    PackFrame (FrameA2F frameA2F) {
        mFrame = frameA2F;
        mByteList.clear();
        arrange();
    }

    public void loadFrame (FrameA2F frameA2F) {
        mFrame = frameA2F;
        arrange();
    }

    public byte[] getByteSquence () {
        int size = mByteList.size();
        byte[] bytes = new byte[size];
        for (int index = 0; index < size; index++) {
            bytes[index] = mByteList.get(index);
        }
        return bytes;
    }

    private void arrange() {
        try {
            if (mFrame != null) {
                mByteList.add(NumberUtil.getByteFromInt(mFrame.getHead(), 0, false));
                mByteList.add(NumberUtil.getByteFromInt(mFrame.getHead(), 1, false));
                mByteList.add(NumberUtil.getByteFromInt(mFrame.getHead(), 2, false));
                mByteList.add(NumberUtil.getByteFromInt(mFrame.getHead(), 3, false));

                mByteList.add(NumberUtil.getByteFromShort(mFrame.getNum(), 0, false));
                mByteList.add(NumberUtil.getByteFromShort(mFrame.getNum(), 1, false));

                mByteList.add(NumberUtil.getByteFromShort(mFrame.getA1(), 0, false));
                mByteList.add(NumberUtil.getByteFromShort(mFrame.getA1(), 1, false));

                mByteList.add(NumberUtil.getByteFromShort(mFrame.getA2(), 0, false));
                mByteList.add(NumberUtil.getByteFromShort(mFrame.getA2(), 1, false));

                mByteList.add(mFrame.getA3());

                mByteList.add(mFrame.getAfn());

                for (int i = 0; i < mFrame.getDataA().size(); i++) {
                    mByteList.add(NumberUtil.getByteFromShort(mFrame.getDataA().get(i).shortValue(), 0, false));
                    mByteList.add(NumberUtil.getByteFromShort(mFrame.getDataA().get(i).shortValue(), 1, false));

                    mByteList.add(NumberUtil.getByteFromShort(mFrame.getDataT().get(i).shortValue(), 0, false));
                    mByteList.add(NumberUtil.getByteFromShort(mFrame.getDataT().get(i).shortValue(), 1, false));
                }

                mByteList.add(NumberUtil.getByteFromInt(mFrame.getDc(), 0, false));
                mByteList.add(NumberUtil.getByteFromInt(mFrame.getDc(), 1, false));
                mByteList.add(NumberUtil.getByteFromInt(mFrame.getDc(), 2, false));
                mByteList.add(NumberUtil.getByteFromInt(mFrame.getDc(), 3, false));

                mByteList.add(NumberUtil.getByteFromInt(mFrame.getCc(), 0, false));
                mByteList.add(NumberUtil.getByteFromInt(mFrame.getCc(), 1, false));
                mByteList.add(NumberUtil.getByteFromInt(mFrame.getCc(), 2, false));
                mByteList.add(NumberUtil.getByteFromInt(mFrame.getCc(), 3, false));

                mByteList.add(NumberUtil.getByteFromInt(mFrame.getTp(), 0, false));
                mByteList.add(NumberUtil.getByteFromInt(mFrame.getTp(), 1, false));
                mByteList.add(NumberUtil.getByteFromInt(mFrame.getTp(), 2, false));
                mByteList.add(NumberUtil.getByteFromInt(mFrame.getTp(), 3, false));

                mByteList.add(NumberUtil.getByteFromShort(mFrame.getCrc().shortValue(), 0, false));
                mByteList.add(NumberUtil.getByteFromShort(mFrame.getCrc().shortValue(), 1, false));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



}
