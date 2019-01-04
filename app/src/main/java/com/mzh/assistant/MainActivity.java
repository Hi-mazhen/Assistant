package com.mzh.assistant;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.*;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MainActivity extends AppCompatActivity {
    public static final String HOST = "192.168.1.199";
    public static final int PORT = 8234;

    private WifiManager mWifiManager;
    private Socket mSocket = null;
    private String hostIp;

    private TextView mTextView;
    private Button mBConnect;
    private ConcurrentLinkedQueue<Byte> mConcurrentLinkedQueue = new ConcurrentLinkedQueue<Byte>();
    private InputStream mSocketInputStream;
    private OutputStream mSocketOutputStream;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v("1", "1");
        initView();
    }

    private void initView() {
        Log.v("2", "2");
        mBConnect = findViewById(R.id.B_CONNECT);

        mTextView = findViewById(R.id.TV_SHOW);
        mTextView.setText("等待连接");


    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.v("3", "3");
        //获取wifiManager对象, 获得目标设备的ip地址
        mWifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        DhcpInfo dhcpinfo = mWifiManager.getDhcpInfo();//dhcpinfo.serverAddress

        if (dhcpinfo != null){
            hostIp = getHostIp(dhcpinfo);
            Log.v("hostIp", hostIp);
        }
    }

    @Override
    protected void onDestroy() {
        try {
            Log.v("4", "4");
            /* 关闭mSocket */
            if(null != mSocket){
                mSocket.shutdownInput();
                mSocket.shutdownOutput();
                mSocket.getInputStream().close();
                mSocket.getOutputStream().close();
                mSocket.close();
            }
        } catch (IOException e) {
            Log.v("Main---onDestroy", e.getMessage());
        }
        super.onDestroy();
    }


    private String getHostIp(DhcpInfo dhcpinfo) {
        int serverAddress = dhcpinfo.serverAddress;
        return  (serverAddress & 0xFF ) + "." +
                ((serverAddress >> 8 ) & 0xFF) + "." +
                ((serverAddress >> 16 ) & 0xFF) + "." +
                ( serverAddress >> 24 & 0xFF) ;
    }


    public void toConnect(View view){
        //启动连接线程
        ConnectThread connectThread = new ConnectThread();
        connectThread.start();

    }



    //连接线程
    private class ConnectThread extends Thread {
        public void run()
        {
            try {
                if (mSocket == null) try {
                    mSocket = new Socket(HOST, PORT);
                    if (mSocket.isConnected()) {
                        mSocketOutputStream = mSocket.getOutputStream();

                        byte[] b = {0x55, 0x44};
                        mSocketOutputStream.write(b);
                        mSocketOutputStream.flush();
                        Log.v("5", "5");
                        ReceiveThread receiveThread = new ReceiveThread();
                        receiveThread.start();
                    } else {
                        // mTextView.setText("NO!");

                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //接收线程
    private class ReceiveThread extends Thread {
        public void run()
        {
            try {
                while (true) {
                    Log.v("6", "6");
                    final byte[] tempBuf = new byte[1024*100];
                    mSocketInputStream = mSocket.getInputStream();
                    final int len = mSocketInputStream.read(tempBuf);


                    // 取回来的数据存入队列
                    for (int i = 0; i < len; i++) {
                        mConcurrentLinkedQueue.add(tempBuf[i]);
                        Log.v(String.valueOf(i), String.valueOf(tempBuf[i]));
                    }
                    // myHandler.sendEmptyMessage(RECEIVE_ONCE);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


