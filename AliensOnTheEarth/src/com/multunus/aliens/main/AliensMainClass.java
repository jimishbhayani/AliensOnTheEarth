package com.multunus.aliens.main;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.multunus.aliens.service.IUserInteraction;

public class AliensMainClass {

	public static void main(String[] args){
		FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext("D:/Documents/spring-config.xml");
		IUserInteraction userInteraction = context.getBean(IUserInteraction.class);
		userInteraction.driveUserAction();
		context.close();
	}
}
