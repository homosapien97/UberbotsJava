
package org.usfirst.frc0.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drive extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private RobotDrive robotDrive;

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void init(int pwmFrontL, int pwmRearL, int pwmFrontR, int pwmRearR) {
    	robotDrive = new RobotDrive(pwmFrontL, pwmRearL, pwmFrontR, pwmRearR);
    }
    public void init(int pwmLeft, int pwmRight) {
    	robotDrive = new RobotDrive(pwmLeft, pwmRight);
    }
    public void arcade(Joystick js, boolean squaredInputs) {
    	robotDrive.arcadeDrive(js, squaredInputs);
    }
}

