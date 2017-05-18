package sony;

import org.springframework.stereotype.Component;

import Interfaces.leg;

@Component
public class sonyleg implements leg{

	public void run() {
		System.out.println("sony leg run");
		
	}
	

}
