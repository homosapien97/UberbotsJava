
package org.usfirst.frc1124.commands;

import org.usfirst.frc1124.OI;
import org.usfirst.frc1124.RobotState;
import org.usfirst.frc1124.subsystems.AllSubsystems;
import org.usfirst.frc1124.subsystems.ArmSubsystem;
import org.usfirst.frc1124.ub.enums.Mode;

public class ArmControllerCommand extends CommandBase {
	private static final double MOVE_SCALE = 0.5; //placeholder
	private static double setpoint;
    public ArmControllerCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(AllSubsystems.arm);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	drive.setDriveType(DriveType.ARCADE);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	setpoint += OI.joystick2.getY() * MOVE_SCALE;
    	setpoint = (setpoint > ArmSubsystem.MAX_HEIGHT) ? ArmSubsystem.MAX_HEIGHT : 
    		((setpoint < ArmSubsystem.MIN_HEIGHT) ? ArmSubsystem.MIN_HEIGHT : setpoint);
    	ArmSubsystem.goTo(setpoint);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(RobotState.mode.value == Mode.DISABLED.value) {
    		return true;
    	}
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
    static {
    	setpoint = ArmSubsystem.getPos();
    }
}