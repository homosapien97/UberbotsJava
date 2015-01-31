package org.usfirst.frc1124;

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
	
	public static final int pwmHDrive = 5; //for use in robots with a fifth wheel in an hdrive config
	
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
	
	public static final int usbJoystick1 = 0;
	public static final int usbJoystick2 = 1;
	public static final int usbJoystick3 = 2;
	
	private static final double wheelDiameterIN = 6;
	private static final double radiansPerRevolution = Math.PI * 2;
	private static final double encoderPulsesPerRevolution = 250; //should be 256, but it always skips some
	public static final double driveDistPerCount = Math.PI * wheelDiameterIN / encoderPulsesPerRevolution;
	public static final double armDistPerCount = radiansPerRevolution / encoderPulsesPerRevolution;
}
