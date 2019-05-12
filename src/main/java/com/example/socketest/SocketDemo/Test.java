/*
 * 版权所有 (C) 2019-2029 长沙新时科技发展有限公司。保留所有权利。
 * 版本：
 * 修改记录：
 *		1、2019年05月09日  ZhouJiDing创建。
 */
package com.example.socketest.SocketDemo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


public class Test
{
        @Value("${test.port}")
        private  int  port;





       @org.junit.Test
        public  void  init(){
           System.out.println("@@:"+port);
        }
}
