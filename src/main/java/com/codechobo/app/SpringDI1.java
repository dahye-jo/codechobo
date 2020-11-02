package com.codechobo.app;

import java.util.HashMap;

public class SpringDI1 {

	public static void main(String[] args) {
		
//Q1. SportsCar객체를 생성하고 HashMap에 저장 후, 다시 꺼내기.
		
		SportsCar car = new SportsCar();
		HashMap map = new HashMap();
		
		map.put("car", car);
		
		SportsCar c = (SportsCar)map.get("car");
		System.out.println(c);
//실행결과: com.codechobo.app.SportsCar@5305068a
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


