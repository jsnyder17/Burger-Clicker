package com.jsnyder17.other;

public class Pair<LeftType, RightType> {
	private LeftType left;
	private RightType right;
	
	public Pair(LeftType left, RightType right) {
		this.left = left;
		this.right = right;
	}
	
	public LeftType getLeft() {
		return left;
	}
	public RightType getRight() {
		return right;
	}
	
	public void setLeft(LeftType left) {
		this.left = left;
	}
	public void setRight(RightType right) {
		this.right = right;
	}
	
	public String toString() {
		return (this.left + ", " + this.right);
	}
}
