
package org.usfirst.frc1124.commands;

import org.usfirst.frc1124.OI;
import org.usfirst.frc1124.RobotState;
import org.usfirst.frc1124.ub.enums.DriveType;
import org.usfirst.frc1124.ub.enums.Mode;

public class Arcade extends CommandBase {

    public Arcade() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(CommandBase.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	drive.setMode(RobotState.driveType);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drive.drive(OI.joystick1, true);
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
}
