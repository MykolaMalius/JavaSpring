package Main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Interfaces.robot;
import Interfaces.robotconveyer;

import t1000.T1000;

public class Main {

	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context_main.xml");

		T1000 t1 =(T1000) context.getBean("scan");
		T1000 t2 =(T1000) context.getBean("scan1");
		t1.action();
		System.out.println("  ");
		t2.action();
		
		
	}

}
