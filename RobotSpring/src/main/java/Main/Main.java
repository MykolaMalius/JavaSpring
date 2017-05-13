package Main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import t1000.T1000;

public class Main {

	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context_main.xml");
		T1000 t1000 = (T1000) context.getBean("t1000");
		t1000.action();
	    t1000.dance();
	    t1000.sing();
	}

}
