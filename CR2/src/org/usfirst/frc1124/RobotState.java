package org.usfirst.frc1124;

import org.usfirst.frc1124.ub.enums.Mode;

import edu.wpi.first.wpilibj.DigitalInput;

//import edu.wpi.first.wpilibj.Timer;

public class RobotState {
//	public static DriveType driveType;
	public static Mode mode;
	public static long startTime;
	public static boolean twoBallAuto;
	public static boolean hotGoalAuto;
	public static boolean shootAuto;
	
	static {
//		driveType = DriveType.ARCADE;
		mode = Mode.DISABLED;
		startTime = System.currentTimeMillis();
		twoBallAuto = (new DigitalInput(RobotMap.dio2ballAutoSwitch)).get();
		hotGoalAuto = (new DigitalInput(RobotMap.dioHotGoalSwitch)).get();
		shootAuto = (new DigitalInput(RobotMap.dioShootAutoSwitch)).get();
	}
}
