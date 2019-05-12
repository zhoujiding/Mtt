/*
 * 版权所有 (C) 2019-2029 长沙新时科技发展有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 *		1、2019年05月09日  ZhouJiDing创建。
 */
package com.example.socketest.SocketDemo;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


/*
 * Server端
 * */

public class ServerDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8848);

        while (true) {
            Socket client = server.accept();
            System.out.println(client.getLocalAddress() + "已上线");
            invoke(client);
        }
    }

    private static void invoke( Socket client) throws IOException {
        new Thread(new Runnable() {
            public void run() {
                BufferedReader in = null;
                PrintWriter out = null;
                try {
                    in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    out = new PrintWriter(client.getOutputStream());

                    while (true) {
                        String msg = in.readLine();
                        System.out.println(client.getLocalAddress() + "说:" + msg);
                        out.println("Server received " + msg);
                        out.flush();
                        if (msg.equals("exit")) {
                            break;
                        }
                    }
                } catch(IOException ex) {
                    ex.printStackTrace();
                } finally {
                    try {
                        in.close();
                    } catch (Exception e) {}
                    try {
                        out.close();
                    } catch (Exception e) {}
                    try {
                        client.close();
                    } catch (Exception e) {}
                }
            }
        }).start();
    }
}