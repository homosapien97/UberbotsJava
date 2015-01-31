
package org.usfirst.frc1124.commands;

import org.usfirst.frc1124.OI;
import org.usfirst.frc1124.RobotState;
import org.usfirst.frc1124.subsystems.All;
import org.usfirst.frc1124.subsystems.DriveSubsystem;
import org.usfirst.frc1124.ub.enums.Mode;

public class DriveControllerCommand extends CommandBase {

    public DriveControllerCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(All.drive);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	drive.setDriveType(DriveType.ARCADE);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	DriveSubsystem.drive(OI.joystick1, true);
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
