/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc1124;


//please let this work this time...

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;

import org.usfirst.frc1124.commands.*;
import org.usfirst.frc1124.subsystems.DriveSubsystem;
import org.usfirst.frc1124.ub.enums.DriveType;
import org.usfirst.frc1124.ub.enums.Mode;
import org.usfirst.frc1124.ub.support.UBMethods;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class CommandBasedRobot extends IterativeRobot {
	
	//create one of each command here
    Command autonomousCommand;
    DriveControllerCommand driveCommand;
    CockCommand cockCommand;
    FireCommand fireCommand;
    DryFireCommand dryFireCommand;
    PullCommand pullCommand;
    PushCommand pushCommand;
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        // instantiate the command used for the autonomous period
        autonomousCommand = new AutonomousCommand();
        
        // Initialize all subsystems
        CommandBase.init();
    }

    public void autonomousInit() {
        // schedule the autonomous command (example)
        autonomousCommand.start();
        RobotState.mode = Mode.AUTONOMOUS;
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to 
		// continue until interrupted by another command, remove
		// this line or comment it out.
		autonomousCommand.cancel();
		
		RobotState.mode = Mode.TELEOP;
		
		//instantiate all teleop commands
		driveCommand = new DriveControllerCommand();
		cockCommand = new CockCommand();
		fireCommand = new FireCommand();
		dryFireCommand = new DryFireCommand();
		
		driveCommand.start(); //having drive as a command may lower responsiveness, consider changing.
		
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        if(OI.joystick1.getRawButton(OI.js1_arcadeButton)) {
    		DriveSubsystem.setDriveType(DriveType.ARCADE);
    	}
    	if(OI.joystick1.getRawButton(OI.js1_cockButton)) {
    		cockCommand.start();
    	}
    	if(OI.joystick1.getTrigger() || OI.joystick1.getRawButton(OI.js1_fireButton)) {
    		fireCommand.start();
    	}
    	if(OI.joystick1.getRawButton(OI.js1_dryFireButton)) {
    		dryFireCommand.start();
    	}
    	switch(UBMethods.hatTransform(OI.joystick1.getRawAxis(4), OI.joystick1.getRawAxis(5))) {
    	case 5: pullCommand.start(); break;
    	case 3: pushCommand.start(); break;
    	default: pullCommand.cancel(); pushCommand.cancel(); //I hope cancel isn't too expensive...
    	}
    	Scheduler.getInstance().run();
    }
}
//TODO create Arm and Drive GOTO commands