package com.codechobo.app2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringDI2 {
	public static void main(String[] args) {

//Q2. HashMap대신 ﻿ApplicationContext를 이용해서 SportsCar객체를 얻어오시오. 
		
//1. AC생성
		ApplicationContext ac = new GenericXmlApplicationContext("classpath:context2.xml");
		
//2. AC에서 빈을 가져온다. 기본적으로 scope이 singleton이라서 
		//매번 getBean()을 호출할 때마다 같은 객체를 반환
		SportsCar c = (SportsCar)ac.getBean("car");
		SportsCar c2 = (SportsCar)ac.getBean("car");
		SportsCar c3 = (SportsCar)ac.getBean("car");
		
		System.out.println(c);
		System.out.println(c2);
		System.out.println(c3);
		
//실행결과: com.codechobo.app2.SportsCar@159f197
//		com.codechobo.app2.SportsCar@159f197
//		com.codechobo.app2.SportsCar@159f197

	}
}

class Engine {}

class Door {}
	
class SportsCar {
	
	int oil;
	String color;
	Engine engine;
	Door[] doors;
}


