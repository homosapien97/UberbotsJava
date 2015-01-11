package org.usfirst.frc0;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
	public static final int pwmLeftDrive = 2;
	public static final int pwmRightDrive = 1;
	public static final int pwmPickupArm = 3;
	public static final int pwmPickupBelt = 4;
	
	public static final int dioDriveEncoderRightChannelA = 1;
	public static final int dioDriveEncoderRightChannelB = 2;
	public static final int dioDriveEncoderLeftChannelA = 3;
	public static final int dioDriveEncoderLeftChannelB = 4;
	public static final int dioPickupArmEncoderChannelA = 5;
	public static final int dioPickupArmEncoderChannelB = 6;
	public static final int dioShooterMagSensorUp = 7;
	public static final int dioShooterMagSensorDown = 8;
	public static final int dio2ballAutoSwitch = 9; // on = 2 ball
	public static final int dioHotGoalSwitch = 10; //on = use
	public static final int dioShootAutoSwitch = 11; //on = shoot a ball
	public static final int dioHoldingLightSensor = 13;
	public static final int dioPneumaticPressureSwitch = 14;
	
	public static final int solLatchB = 1;
	public static final int solLatchA = 2;
	public static final int solShooterB = 3;
	public static final int solShooterA = 4;
	public static final int solShifterA = 5;
	public static final int solShifterB = 6;
	
	
	/*
	 * Mrs. Westin wants to make this the centralized place where we
	 * initialize all of our objects and stuff, and wants to make this have 
	 * exactly one instance. 
	 */
}
