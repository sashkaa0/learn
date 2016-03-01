package main;

import impl.robot.ModelT1000;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"context.xml");
		ModelT1000 t1000 = (ModelT1000) context.getBean("t1000");
		t1000.fire();
		t1000.dance();
	}
}
