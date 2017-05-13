package t1000;

import Interfaces.hand;
import Interfaces.head;
import Interfaces.leg;
import Interfaces.robot;


public class T1000 implements robot {

	private hand Hand;
	private leg Leg;
	private head Head;
	
	private String color;
	private int year;
	private boolean sound;
	
	public T1000(){
		
	}
	
	
	
	
	
	public T1000(hand Hand, leg Leg, head Head, String color, int year, boolean sound) {
		super();
		this.Hand = Hand;
		this.Leg = Leg;
		this.Head = Head;
		this.color = color;
		this.year = year;
		this.sound = sound;
	}
	
	

	public T1000(hand Hand, leg Leg, head Head) {
		super();
		this.Hand = Hand;
		this.Leg = Leg;
		this.Head = Head;
		
	}
	
	
	public T1000(String color, int year, boolean sound) {
		super();
		this.color = color;
		this.year = year;
		this.sound = sound;
	}



	public hand getHand() {
		return Hand;
	}

	public void setHand(hand hand) {
		Hand = hand;
	}

	public leg getLeg() {
		return Leg;
	}

	public void setLeg(leg leg) {
		Leg = leg;
	}


	public head getHead() {
		return Head;
	}


	public void setHead(head head) {
		Head = head;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
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
		Hand.attack();
		Leg.run();
		Head.think();
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
