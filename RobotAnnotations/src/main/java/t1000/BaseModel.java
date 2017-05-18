package t1000;

import org.springframework.beans.factory.annotation.Autowired;

import Interfaces.hand;
import Interfaces.head;
import Interfaces.leg;
import Interfaces.robot;

public abstract class BaseModel implements robot {

	
	@Autowired
	private hand Hand;
	
	@Autowired
	private leg Leg;
	
	@Autowired
	private head Head;

	public BaseModel() {
		System.out.println(this + " - BaseModel constructor()");
	}

//	public BaseModel(hand Hand, leg Leg, head Head) {
//		this();
//		this.Hand = Hand;
//		this.Leg = Leg;
//		this.Head = Head;
//	}

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

	
	
	
}	
