
package org.usfirst.frc1124.subsystems;

import org.usfirst.frc1124.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Latch extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private static Solenoid latch = new Solenoid(RobotMap.solLatchA, RobotMap.solLatchB);
	
	public static void close() {
		latch.set(true);
	}
	public static void open() {
		latch.set(false);
	}
	public static boolean get() { //closed is true
		return latch.get();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public Latch() {
    	super();
    }
}

