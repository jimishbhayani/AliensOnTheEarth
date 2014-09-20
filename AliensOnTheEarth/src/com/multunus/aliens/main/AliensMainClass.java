package com.multunus.aliens.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.multunus.aliens.service.IUserInteraction;

public class AliensMainClass {

	
	public static void main(String[] args){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		IUserInteraction userInteraction = context.getBean(IUserInteraction.class);
		userInteraction.driveUserAction();
		context.close();
	}
}
