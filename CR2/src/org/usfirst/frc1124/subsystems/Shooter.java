
package org.usfirst.frc1124.subsystems;

import org.usfirst.frc1124.RobotMap;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Shooter extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private static Solenoid cocker = new Solenoid(RobotMap.solShooterA, RobotMap.solShooterB);
	private static DigitalInput up = new DigitalInput(RobotMap.dioShooterMagSensorUp);
	private static DigitalInput down = new DigitalInput(RobotMap.dioShooterMagSensorDown);
	private static DigitalInput holding = new DigitalInput(RobotMap.dioHoldingLightSensor);
	
	public static boolean extend() {
		cocker.set(true);
		return down.get();
	}
	public static boolean retract() {
		cocker.set(false);
		return up.get();
	}
	public static boolean get() { //extended is true
		return cocker.get();
	}
	public static boolean up() {
		return up.get();
	}
	public static boolean down() {
		return down.get();
	}
	public static boolean holding() {
		return holding.get();
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public Shooter() {
    	super();
    }
}

