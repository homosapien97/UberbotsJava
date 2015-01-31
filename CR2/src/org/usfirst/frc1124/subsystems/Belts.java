
package org.usfirst.frc1124.subsystems;

import org.usfirst.frc1124.RobotMap;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Belts extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private static final double IN_SPEED = -1.0;
	private static final double OUT_SPEED = 1.0;
	private static final Jaguar belt = new Jaguar(RobotMap.pwmPickupBelt);	
	
	public static void pull() {
		belt.set(IN_SPEED);
	}
	public static void push() {
		belt.set(OUT_SPEED);
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public Belts() {
    	super();
    }
}
