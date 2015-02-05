package org.usfirst.frc1124.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc1124.OI;
import org.usfirst.frc1124.subsystems.AllSubsystems;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    // Create a single static instance of all of your subsystems
    
//    public static ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
//    public static DriveSubsystem drive = new DriveSubsystem(RobotMap.pwmLeftDrive, RobotMap.pwmRightDrive);
//    
    /*
     * So, it seems like I will never have more than one instance of a subsystem, so I'm just going to make
     * everything in each susbsystem static and create an instance of them here just for requires()
     * statements. Actually, I think I won't declare them here, I'll do it in a separate file. Meh.
     * 
     * Also it turns out that the subsystems need to be initialized at some point including the 
     * super() initializer, since this adds the subsystem to a registry that is used elsewhere behind the
     * scenes.
     */
    
    {AllSubsystems all = new AllSubsystems();} //this is just to get the static bits of All to go

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(AllSubsystems.exampleSubsystem);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
