
package org.usfirst.frc1124.subsystems;

import org.usfirst.frc1124.RobotMap;
import org.usfirst.frc1124.ub.support.SafeJaguar;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Arm extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static final double MAX_HEIGHT = 90.0;		//placeholder value
	public static final double MIN_HEIGHT = -90.0;		//placeholder value
	private static final double MAX_SPEED = 0.9;		//placeholder value
	private static final Encoder encoder = new Encoder(RobotMap.dioPickupArmEncoderChannelA,
			RobotMap.dioPickupArmEncoderChannelB);
	private static final double Kp = .01;				//placeholder value
	private static final double Ki = .1;				//placeholder value
	private static final double Kd = .001;				//placeholder value
	private static final SafeJaguar arm = new SafeJaguar(RobotMap.pwmPickupBelt, encoder, 
			Kp, Ki, Kd, MAX_SPEED, MIN_HEIGHT, MAX_HEIGHT);	
	
	public static boolean goTo(double pos, double tolerance) {
		return arm.goTo(pos, tolerance);
	}
	public static void disablePID() {
		arm.disablePID();
	}
	public static void hold() {
		arm.hold();
	}
	public static void cancelHold() { //does the exact same thing as disablePID()
		arm.disablePID();
	}
	public static double getPos() {
    	return encoder.get();
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    
    public Arm() {
    	super();
    }
    static {
    	encoder.setDistancePerPulse(RobotMap.armDistPerCount);
    }
}
