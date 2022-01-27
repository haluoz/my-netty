//package com.lxj.mynetty.listener;
//
//import com.lxj.netty.client.Client;
//import org.springframework.boot.context.event.ApplicationReadyEvent;
//import org.springframework.context.ApplicationListener;
//
//public class ApplicationListenerReadyEvent implements ApplicationListener<ApplicationReadyEvent>{
//
//	@Override
//	public void onApplicationEvent(ApplicationReadyEvent event) {
//		System.err.println("@@@@@@@@----client服务已经启动成功----@@@@@@@@");
//		Client.getInstance().init();
//	}
//
//}
