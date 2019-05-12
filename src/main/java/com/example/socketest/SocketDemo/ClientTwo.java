/*
 * 版权所有 (C) 2019-2029 长沙新时科技发展有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 *		1、2019年05月09日  ZhouJiDing创建。
 */
package com.example.socketest.SocketDemo;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ClientTwo
{
    public static void main(String[] args) throws Exception {
        Socket client = new Socket("127.0.0.2", 8848);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("已连接，可以发送信息啦！");
        while (true) {
            String msg = reader.readLine();
            out.println(msg);
            out.flush();
            if (msg.equals("exit")) {
                break;
            }
            System.out.println(in.readLine());
        }
        client.close();
    }
}
