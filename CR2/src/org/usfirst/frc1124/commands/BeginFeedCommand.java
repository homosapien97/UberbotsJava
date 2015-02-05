
package org.usfirst.frc1124.commands;

import org.usfirst.frc1124.subsystems.AllSubsystems;
import org.usfirst.frc1124.subsystems.ArmSubsystem;
import org.usfirst.frc1124.subsystems.BeltSubsystem;
import org.usfirst.frc1124.subsystems.ShooterSubsystem;
import org.usfirst.frc1124.subsystems.LatchSubsystem;


public class BeginFeedCommand extends CommandBase {
	private static long cockStartTime;
	private static final long COCKER_DURATION = 2000; //2 seconds should be enough?
	private static final long LATCH_DURATION = 500; //half second should be plenty long to latch
	private static final double FEED_POS = 1.3; //random value placeholder
	private static char state = 0;
    public BeginFeedCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(AllSubsystems.shooter);
    	requires(AllSubsystems.latch);
    	requires(AllSubsystems.arm);
    	requires(AllSubsystems.belts);
    }

    // Called just before this Command runs the first time
    // just to be clear, I'm pretty sure initialize() runs once each time the command is started.
    protected void initialize() { 
    	state = 0;
    	cockStartTime = System.currentTimeMillis();
    	LatchSubsystem.open();
    	ShooterSubsystem.extend();
    	ArmSubsystem.goTo(FEED_POS);
    	BeltSubsystem.pull();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(state == 0) {
    		if(ShooterSubsystem.down() && System.currentTimeMillis() > cockStartTime + COCKER_DURATION) {
    			LatchSubsystem.close();
    			state++;
    		}
    	} else if(state == 1) {
    		if(System.currentTimeMillis() > cockStartTime + COCKER_DURATION + LATCH_DURATION) {
    			ShooterSubsystem.retract();
    			state++;
    		}
    	} else if(state == 2) {
    		if(ShooterSubsystem.up() && System.currentTimeMillis() > cockStartTime + 2 * COCKER_DURATION + LATCH_DURATION) {
    			state++;
    		}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(state > 2) {
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
    	BeltSubsystem.push();
    }
}

