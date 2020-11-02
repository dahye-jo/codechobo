package com.codechobo.app5;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringDI5 {
	public static void main(String[] args) {

//Q5. Engine, Door를 bean으로 등록하고 SportsCar객체에 주입하는 코드를 작성하시오. 
//		(단, @Autowired를 사용하지 않고 하시오.)

//1. AC생성
		ApplicationContext ac = new GenericXmlApplicationContext("classpath:context5.xml");
		
//2. AC에서 빈을 가져온다. 
		SportsCar c = (SportsCar)ac.getBean("car");
		
//3. setter에 @Autowired를 붙이고 아래 코드를 주석처리한다. 
//	 setDoor(Door[] d)는 배열이라서 @Autowired로는 어렵다. 
//		c.setEngine((Engine)ac.getBean("engine"));
//		
//		c.setDoors(new Door[] {
//				ac.getBean("door", Door.class),
//				ac.getBean("door", Door.class),
//				ac.getBean("door", Door.class),
//				ac.getBean("door", Door.class),
//				});
		
		System.out.println(c);
		
//실행결과: SportsCar [oil=0, color=null, engine=com.codechobo.app5.Engine@34a3d150, doors=[com.codechobo.app5.Door@2a4fb17b]]
	}
}

class Engine {}

class Door {}
	
class SportsCar {
	
	int oil;
	String color;
	Engine engine;
	Door[] doors;
	
	public int getOil() {
		return oil;
	}

	public void setOil(int oil) {
		this.oil = oil;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public Engine getEngine() {
		return engine;
	}
	
	@Autowired
	public void setEngine(Engine engine) {
		this.engine = engine;
	}

	public Door[] getDoors() {
		return doors;
	}
	
	@Autowired //배열을 넣어야 하므로 이런식으로는 곤란하다. 
	public void setDoors(Door[] doors) {
		this.doors = doors;
	}

	@Override
	public String toString() {
		return "SportsCar [oil=" + oil + ", color=" + color + ", engine=" + engine + ", doors=" + Arrays.toString(doors)
				+ "]";
	}
}


