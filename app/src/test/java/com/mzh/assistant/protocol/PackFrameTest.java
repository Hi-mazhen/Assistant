package com.mzh.assistant.protocol;

import com.mzh.assistant.entity.FrameA2F;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class PackFrameTest {
    private FrameA2F frameA2F = new FrameA2F();
    private PackFrame packFrame = new PackFrame();
    private byte[] expected;

    @Before
    public void setUp() {
        frameA2F.setHead(0xAA55AA55);
        frameA2F.setNum((short) 0x1);
        frameA2F.setA1((short) 0x2);
        frameA2F.setA2((short) 0x3);
        frameA2F.setA3((byte) 0x4);
        frameA2F.setAfn((byte) 0x5);
        List<Short> dataA = new ArrayList<Short>();
        dataA.add((short) 0x6);
        frameA2F.setDataA(dataA);
        List<Short> dataT = new ArrayList<Short>();
        dataT.add((short) 0x7);
        frameA2F.setDataT(dataT);
        frameA2F.setDc(0x8);
        frameA2F.setCc(0x9);
        frameA2F.setTp(0xA);
        frameA2F.setCrc((short) 0xB);

        expected = new byte[]{
                0x55, (byte) 0xAA, 0x55, (byte) 0xAA,
                (byte) 0x1, (byte) 0x0,
                0x2, 0x0,
                0x3, 0x0,
                0x4,
                0x5,
                (byte) 0x6, (byte) 0x0,
                (byte) 0x7, (byte) 0x0,
                0x8, 0x0, 0x0, 0x0,
                0x9, 0x0, 0x0, 0x0,
                0xA, 0x0, 0x0, 0x0,
                (byte) 0xB, (byte) 0x0
        };
    }

    @After
    public void tearDown() {

    }



    @Test
    public void testGetByteSquence() {
        packFrame.loadFrame(frameA2F);
        //
        byte[] actual = packFrame.getByteSquence();
        // for (int i = 0; i < actual.length; i++) {
        //     System.out.print(String.valueOf(actual[i]) + "; ");
        // }

        assertArrayEquals(expected, actual);
    }
}