package t1000;

import java.io.ObjectInputStream.GetField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import Interfaces.ColorList;
import Interfaces.hand;
import Interfaces.head;
import Interfaces.leg;
import t1000.BaseModel;

@Component
public class T1000 extends BaseModel {

	
	
	private ColorList color;
	private int year;
	private boolean sound;
	
	public T1000(){
		
	}
	
	
	@Bean
    @Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public T1000 scan(){
		return new T1000(ColorList.PINK, 1963, true);
	}
	@Bean
	@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	public T1000 scan1(){
		return new T1000();
	}
	
	
	public T1000(hand Hand, leg Leg, head Head, ColorList color, int year, boolean sound) {
//		super();
//		this.Hand = Hand;
//		this.Leg = Leg;
//		this.Head = Head;
		this.color = color;
		this.year = year;
		this.sound = sound;
	}
//	
//	
//
//	public T1000(hand Hand, leg Leg, head Head) {
//		super();
//		this.Hand = Hand;
//		this.Leg = Leg;
//		this.Head = Head;
//		
//	}
	
	
	public T1000(ColorList color, int year, boolean sound) {
		super();
		this.color = color;
		this.year = year;
		this.sound = sound;
	}



//	public hand getHand() {
//		return Hand;
//	}
//
//	public void setHand(hand hand) {
//		Hand = hand;
//	}
//
//	public leg getLeg() {
//		return Leg;
//	}
//
//	public void setLeg(leg leg) {
//		Leg = leg;
//	}
//
//
//	public head getHead() {
//		return Head;
//	}
//
//
//	public void setHead(head head) {
//		Head = head;
//	}

	public ColorList getColor() {
		return color;
	}

	public void setColor(ColorList color) {
		this.color = color;
	}

	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}

	public boolean isSound() {
		return sound;
	}

	public void setSound(boolean sound) {
		this.sound = sound;
	}


	public void action() {
		System.out.println("Hello.I*m terminator");
		getHand().attack();
		getLeg().run();
		getHead().think();
		
		System.out.println("Robot color is:"+color);
		System.out.println("He was born on:" + year);
		System.out.println("Does he has a voice? " + " It*s - " + sound);
		
	}


public void sing() {
		System.out.println("Its the finalcountdown!");
	}


public void dance() {
	System.out.println("Im dancing");
	
}





	



 
		
	

}
