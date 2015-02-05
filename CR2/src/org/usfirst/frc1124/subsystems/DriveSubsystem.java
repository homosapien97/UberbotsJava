
package org.usfirst.frc1124.subsystems;

import org.usfirst.frc1124.OI;
import org.usfirst.frc1124.RobotMap;
import org.usfirst.frc1124.ub.enums.DriveType;
import org.usfirst.frc1124.ub.enums.Gear;
import org.usfirst.frc1124.ub.support.SafeJaguar;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class DriveSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private static DriveType type = DriveType.ARCADE;
	
	
	private static final double Kp = 0.01;		//placeholder value
	private static final double Ki = 0.001;		//placeholder value
	private static final double Kd = 0.1;		//placeholder value
	private static final double MAX_SPEED = 1.0;
	private static final double TOLERANCE = 0.05;
	private static final Encoder leftEncoder = new Encoder(RobotMap.dioDriveEncoderLeftChannelA,
			RobotMap.dioDriveEncoderLeftChannelB);
	private static final Encoder rightEncoder = new Encoder(RobotMap.dioDriveEncoderRightChannelA,
			RobotMap.dioDriveEncoderRightChannelB);
	private static final SafeJaguar left = new SafeJaguar(RobotMap.pwmLeftDrive, leftEncoder, 
			Kp, Ki, Kd, SafeJaguar.DEFAULT_ROTATION, SafeJaguar.DEFAULT_ROTATION, MAX_SPEED, TOLERANCE);
	private static final SafeJaguar right = new SafeJaguar(RobotMap.pwmRightDrive, rightEncoder,
			Kp, Ki, Kd, SafeJaguar.DEFAULT_ROTATION, SafeJaguar.DEFAULT_ROTATION, MAX_SPEED, TOLERANCE);
	private static final RobotDrive drive = new RobotDrive(RobotMap.pwmLeftDrive, RobotMap.pwmRightDrive);
	private static final Solenoid shifter = new Solenoid(RobotMap.solShifterA, RobotMap.solShifterB);
	
	public static boolean goTo(double pos, boolean resetEncoder) {
		if(resetEncoder) {
			left.resetEncoder();
			right.resetEncoder();
		}
		left.goTo(pos);
		right.goTo(pos);
		return left.atSetpoint() && right.atSetpoint();
	}
	public static boolean turn(double l, double r, boolean resetEncoder) {
		if(resetEncoder) {
			left.resetEncoder();
			right.resetEncoder();
		}
		left.goTo(l);
		right.goTo(r);
		return left.atSetpoint() && right.atSetpoint();
	}
	public static boolean turn(double radians, boolean resetEncoder) {
		if(resetEncoder) {
			left.resetEncoder();
			right.resetEncoder();
		}
		left.goTo(RobotMap.widthBetweenWheelsIN / -2 * radians);
		right.goTo(RobotMap.widthBetweenWheelsIN / 2 * radians);
		return left.atSetpoint() && right.atSetpoint();
	}
	public static boolean at(double pos, double tolerance) {
		return left.atSetpoint() && right.atSetpoint();
	}
	public static void resetDriveDist() {
		left.resetEncoder();
		right.resetEncoder();
	}
	public static void disablePID() {
		left.disablePID();
		right.disablePID();
	}
	public static void hold() {
		left.holdPosition();
		right.holdPosition();
	}
	public static void cancelHold() { //does the exact same thing as disablePID()
		disablePID();
	}
	
	public static void drive() {
		if(type.value == DriveType.ARCADE.value) {
			drive.arcadeDrive(OI.joystick1, OI.squaredInputs);
		} else {
			//implement other driving schemes if necessary
		}
	}
	public static void drive(Joystick js, boolean sq) { //really shouldn't be used
		if(type.value == DriveType.ARCADE.value) {
			drive.arcadeDrive(js, sq);
		} else {
			//implement other driving schemes if necessary.
		}
	}
	public static void shift() {
		shifter.set(!shifter.get());
	}
	public static void shift(Gear gear) {
		if(gear.value == Gear.LOW.value) {
			shifter.set(true);
		} else {
			shifter.set(false);
		}
	}
	
	public static void setDriveType(DriveType dt) {
		type = dt;
	}
	public static DriveType getDriveType() {
		return type;
	}
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public DriveSubsystem() {
    	super();
    }
    static  {
    	leftEncoder.setDistancePerPulse(RobotMap.driveDistPerCount);
    	rightEncoder.setDistancePerPulse(RobotMap.driveDistPerCount);
    }
}