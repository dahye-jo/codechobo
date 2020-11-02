package com.codechobo.app4;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringDI4 {
	public static void main(String[] args) {

//Q4. Engine, Door를 bean으로 등록하고 SportsCar객체에 주입하는 코드를 작성하시오. 
//		(context.xml에서 context라는 namespace를 추가해야한다.)

//1. AC생성
		ApplicationContext ac = new GenericXmlApplicationContext("classpath:context4.xml");
		
//2. AC에서 빈을 가져온다. 
		SportsCar c = (SportsCar)ac.getBean("car");
		SportsCar c2 = (SportsCar)ac.getBean("car");
		SportsCar c3 = (SportsCar)ac.getBean("car");
		
		System.out.println(c);
		System.out.println(c2);
		System.out.println(c3);
		
//실행결과: SportsCar [oil=0, color=null, engine=com.codechobo.app4.Engine@42a48628, doors=[com.codechobo.app4.Door@293a5bf6]]
//		SportsCar [oil=0, color=null, engine=com.codechobo.app4.Engine@42a48628, doors=[com.codechobo.app4.Door@293a5bf6]]
//		SportsCar [oil=0, color=null, engine=com.codechobo.app4.Engine@42a48628, doors=[com.codechobo.app4.Door@293a5bf6]]
	}
}

class Engine {}

class Door {}
	
class SportsCar {
	
	int oil;
	String color;
	//객체 주입 
	@Autowired Engine engine;
	@Autowired Door[] doors;
	
	@Override
	public String toString() {
		return "SportsCar [oil=" + oil + ", color=" + color + ", engine=" + engine + ", doors=" + Arrays.toString(doors)
				+ "]";
	}
}


