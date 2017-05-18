package toshiba;

import org.springframework.stereotype.Component;

import Interfaces.hand;
@Component
public class toshibahand implements hand{

	public void attack() {
		System.out.println("toshiba hand attack");
		
	}
	

}
