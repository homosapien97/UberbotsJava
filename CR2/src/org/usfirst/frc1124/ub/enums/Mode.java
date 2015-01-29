package org.usfirst.frc1124.ub.enums;

public class Mode {
	private static final int DISABLED_VAL = 0;
	private static final int AUTONOMOUS_VAL = 1;
	private static final int TELEOP_VAL = 2;
	
	public final int value;
	
	public static final Mode DISABLED = new Mode(DISABLED_VAL);
	public static final Mode AUTONOMOUS = new Mode(AUTONOMOUS_VAL);
	public static final Mode TELEOP = new Mode(TELEOP_VAL);
	
	private Mode(int val) {
		value = val;
	}
}
