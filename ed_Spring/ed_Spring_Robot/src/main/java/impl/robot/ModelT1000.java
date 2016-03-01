package impl.robot;

import interfaces.robot;

public class ModelT1000 implements robot {

	private interfaces.hand hand;
	private String color;

	public ModelT1000(String color, interfaces.hand hand, interfaces.head head,
			interfaces.leg leg) {
		super();
		this.hand = hand;
		this.color = color;
		this.head = head;
		this.leg = leg;
	}

	public interfaces.hand getHand() {
		return hand;
	}

	public void setHand(interfaces.hand hand) {
		this.hand = hand;
	}

	public interfaces.head getHead() {
		return head;
	}

	public void setHead(interfaces.head head) {
		this.head = head;
	}

	public interfaces.leg getLeg() {
		return leg;
	}

	public void setLeg(interfaces.leg leg) {
		this.leg = leg;
	}

	private interfaces.head head;
	private interfaces.leg leg;

	public ModelT1000() {
	}

	public ModelT1000(interfaces.head head, interfaces.hand hand,
			interfaces.leg leg) {
		super();
		this.hand = hand;
		this.leg = leg;
		this.head = head;
	}

	@Override
	public void fire() {
		head.calc();
		hand.catchSomething();
		leg.go();
		System.out.println("I have killed this sheat");
	}

	@Override
	public void dance() {
		System.out.println("who like to dance with me?");
		System.out.println("maybe you babe?");
		System.out.println(color);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
