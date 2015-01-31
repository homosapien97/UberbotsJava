
package org.usfirst.frc1124.commands;

import org.usfirst.frc1124.subsystems.All;
import org.usfirst.frc1124.subsystems.Shooter;
import org.usfirst.frc1124.subsystems.Latch;


public class FireCommand extends CommandBase {
	private static long fireStartTime;
	private static final long MOVE_DURATION = 2000; //2 seconds should be enough for the shooter to extend
	private static final long LATCH_DURATION = 500; //half second should be plenty long to latch
	private static char state = 0;
    public FireCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(All.shooter);
    	requires(All.latch);
    }

    // Called just before this Command runs the first time
    // just to be clear, I'm pretty sure initialize() runs once each time the command is started.
    protected void initialize() {
    	fireStartTime = System.currentTimeMillis();
//    	state = 1;
//    	if(!Latch.get()) { //false means open
//    		state = 2;
//    	} else if(Shooter.get() || Shooter.down()) {
//    		state = 0;
//    		Shooter.retract();
//    	}
    	
    	/*
    	 * if the latch is unlatched or if there is no ball, do nothing
    	 * if the shooter is down, retract it before anything else
    	 * when the shooter is up, unlatch the latch
    	 */
    	
    	if(!(Latch.get() && Shooter.holding())) {
    		state = 2;
    	} else if(Shooter.get() || Shooter.down()) {
    		Shooter.retract();
    		state = 0;
    	} else {
    		state = 1;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if(state == 0) { //when the shooter is up, unlatch and move on to next state
    		if(Shooter.up() && System.currentTimeMillis() > fireStartTime + MOVE_DURATION) {
    			Latch.open();
    			state++;
    		}
    	} else if(state == 1) { //when unlatched, finish
    		if(System.currentTimeMillis() > fireStartTime + MOVE_DURATION + LATCH_DURATION) {
    			state++;
    		}
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	if(state > 1) {
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
