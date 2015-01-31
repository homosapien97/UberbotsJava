package org.usfirst.frc1124.ub.enums;

public class Gear {
	private static final int LOW_VAL = 0;
	private static final int HIGH_VAL = 1;
	
	public final int value;
	
	public static final Gear LOW = new Gear(LOW_VAL);
	public static final Gear HIGH = new Gear(HIGH_VAL);
	
	private Gear(int val) {
		value = val;
	}
}
