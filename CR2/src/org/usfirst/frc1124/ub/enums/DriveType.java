package org.usfirst.frc1124.ub.enums;

public class DriveType {
	private static final int ARCADE_VAL = 0;
	private static final int HDRIVE_VAL = 1;
	private static final int SWERVE_VAL = 2;
	
	public final int value;
	
	public static final DriveType ARCADE = new DriveType(ARCADE_VAL);
	public static final DriveType HDRIVE = new DriveType(HDRIVE_VAL);
	public static final DriveType SWERVE = new DriveType(SWERVE_VAL);
	
	private DriveType(int val) {
		value = val;
	}
}
