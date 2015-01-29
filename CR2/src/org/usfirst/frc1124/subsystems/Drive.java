
package org.usfirst.frc1124.subsystems;

import org.usfirst.frc1124.RobotMap;
import org.usfirst.frc1124.ub.enums.DriveType;
import org.usfirst.frc1124.ub.support.UBMethods;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private RobotDrive drive;
	private DriveType type;
	
	public void arcade(Joystick js, boolean squared) {
		drive.arcadeDrive(js, squared);
	}
	public void drive(Joystick js, boolean squared) {
		if(type.value == DriveType.ARCADE.value) {
			drive.arcadeDrive(js, squared);
		} else if(type.value == DriveType.HDRIVE.value) {
			UBMethods.hdrive(drive, RobotMap.pwmHDrive, js, squared);
		} else if(type.value == DriveType.SWERVE.value) {
			//the drive.meccanum methods need a gyro :(
		}
	}
	public void setMode(DriveType t) {
		type = t;
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public Drive(int pwmL, int pwmR) {
    	super();
    	drive = new RobotDrive(pwmL, pwmR);
    }
    
    public Drive(int pwmTL, int pwmBL, int pwmTR, int pwmBR) {
    	super();
    	drive = new RobotDrive(pwmTL, pwmBL, pwmTR, pwmBR);
    }
}

