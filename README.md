# **项目练习：TDD方式开发一款现场助手**

## 项目需求
1. 小助手是一款专用行业现场设备检测APP；
2. 小助手与现场其他设备通过WiFi采用TCP/IP通信；
3. 小助手需要配置若干参数，这些参数组成通信帧下发给现场设备，同时小助手需要获得现场设备的返回数据并解析显示；
4. 通信帧组包解包协议需要与现场设备约定；
5. 收到的数据具体接续需要根据行业手册解析；

## 完成过程
### 任务分解形成任务清单
1. 小助手与现场设备相连通
2. 小助手与现场设备完成简单收发
3. 小助手向现场设备发送具有实际意义的指令
4. 小助手接收现场设备上报具有现实意义的数据
5. 上报的数据需要可视化展示


### 实施过程
1. 先建立一个最小系统，与指定IP地址的调试器联通，能进行简单字符的收发