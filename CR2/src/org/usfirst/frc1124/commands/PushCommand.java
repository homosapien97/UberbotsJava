
package org.usfirst.frc1124.commands;

import org.usfirst.frc1124.subsystems.All;
import org.usfirst.frc1124.subsystems.Belts;

public class PushCommand extends CommandBase {

    public PushCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(All.belts);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Belts.push();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
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
