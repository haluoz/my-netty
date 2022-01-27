package com.lxj.mynetty.server;

import com.lxj.mynetty.listener.ApplicationListenerReadyEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		
        SpringApplication application = new SpringApplication(Application.class);
        application.addListeners(new ApplicationListenerReadyEvent());
        application.run(args);
        
	}

}

