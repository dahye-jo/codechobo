package com.codechobo.app3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringDI3 {
	public static void main(String[] args) {

//Q3. getBean()으로 호출할 때마다(객체를 얻어올때마다) 새로운 객체를 반환하도록 하시오. 

//1. AC생성
		ApplicationContext ac = new GenericXmlApplicationContext("classpath:context3.xml");
		
//2. AC에서 빈을 가져온다. 
		SportsCar c = (SportsCar)ac.getBean("car");
		SportsCar c2 = (SportsCar)ac.getBean("car");
		SportsCar c3 = (SportsCar)ac.getBean("car");
		
		System.out.println(c);
		System.out.println(c2);
		System.out.println(c3);
		
//실행결과: com.codechobo.app3.SportsCar@419c5f1a
//		com.codechobo.app3.SportsCar@12b0404f
//		com.codechobo.app3.SportsCar@769e7ee8
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


