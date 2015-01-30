
package org.usfirst.frc1124.subsystems;

import org.usfirst.frc1124.RobotMap;
import org.usfirst.frc1124.ub.enums.DriveType;
import org.usfirst.frc1124.ub.support.UBMethods;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private static RobotDrive drive;
	private static DriveType type;
	
//	public void arcade(Joystick js, boolean squared) {
//		drive.arcadeDrive(js, squared);
//	}
	public static void drive(Joystick js, boolean squared) {
		//I can't use a switch here because cases have to be constant
		if(type.value == DriveType.ARCADE.value) {
			drive.arcadeDrive(js, squared);
		} else if(type.value == DriveType.HDRIVE.value) {
			UBMethods.hdrive(drive, RobotMap.pwmHDrive, js, squared);
		} else if(type.value == DriveType.SWERVE.value) {
			//the DriveSubsystem.meccanum methods need a gyro :(
		}
	}
	public static void drive(double lval, double rval) {
		drive.setLeftRightMotorOutputs((lval > 1) ? 1 : ((lval < -1) ? -1 : lval), 
				(rval > 1) ? 1 : ((rval < -1) ? -1 : rval));
	}
	public static void setDriveType(DriveType t) {
		type = t;
	}
	public static DriveType getDriveType() {
		return type;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public DriveSubsystem() {
    	super();
    }
    public DriveSubsystem(int pwmL, int pwmR) {
    	super();
    	drive = new RobotDrive(pwmL, pwmR);
    }
    
    public DriveSubsystem(int pwmTL, int pwmBL, int pwmTR, int pwmBR) {
    	super(); //adds the subsystem to a scheduler
    	drive = new RobotDrive(pwmTL, pwmBL, pwmTR, pwmBR);
    }
    
    public static void init(int pwmL, int pwmR) {
    	drive = new RobotDrive(pwmL, pwmR);
    }
    public static void init(int pwmTL, int pwmBL, int pwmTR, int pwmBR) {
    	drive = new RobotDrive(pwmTL, pwmBL, pwmTR, pwmBR);
    }
}

