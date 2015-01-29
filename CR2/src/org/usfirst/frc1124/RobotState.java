package org.usfirst.frc1124;

import org.usfirst.frc1124.ub.enums.DriveType;
import org.usfirst.frc1124.ub.enums.Mode;

public class RobotState {
	public static DriveType driveType;
	public static Mode mode;
	
	static {
		driveType = DriveType.ARCADE;
		mode = Mode.DISABLED;
	}
}
