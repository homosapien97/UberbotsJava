
package org.usfirst.frc1124.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private RobotDrive drive;
	
	public void arcade(Joystick js, boolean squared) {
		drive.arcadeDrive(js, squared);
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

