
package org.usfirst.frc1124.subsystems;

import org.usfirst.frc1124.RobotMap;
import org.usfirst.frc1124.ub.support.SafeJaguar;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

public class ArmSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	public static final double FEED_SETPOINT = Math.PI - 0.1;	//placeholder value
	public static final double MAX_HEIGHT = Math.PI;			//placeholder value
	public static final double MIN_HEIGHT = -Math.PI;			//placeholder value
	public static final double MAX_SPEED = 0.9;					//placeholder value
	public static final double TOLERANCE = 0.05;				//placeholder value
	private static final Encoder encoder = new Encoder(RobotMap.dioPickupArmEncoderChannelA,
			RobotMap.dioPickupArmEncoderChannelB);
	private static final double Kp = .01;						//placeholder value
	private static final double Ki = .1;						//placeholder value
	private static final double Kd = .001;						//placeholder value
	private static final SafeJaguar arm = new SafeJaguar(RobotMap.pwmPickupBelt, encoder, 
			Kp, Ki, Kd, MAX_SPEED, MIN_HEIGHT, MAX_HEIGHT, TOLERANCE);	
	
	public static void goTo(double pos) {
		arm.goTo(pos);
	}
	public static void disablePID() {
		arm.disablePID();
	}
	public static void hold() {
		arm.holdPosition();
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
    
    
    public ArmSubsystem() {
    	super();
    }
    static {
    	encoder.setDistancePerPulse(RobotMap.armDistPerCount);
    }
}
