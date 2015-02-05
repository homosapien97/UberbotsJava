package org.usfirst.frc1124.ub.support;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.PIDController;

public class SafeJaguar extends Jaguar{
	public static final double DEFAULT_TOLERANCE = 0.1;
	public static final double DEFAULT_MAX_SPEED = 1.0;
	public static final double DEFAULT_ROTATION = 0.0;
	private Encoder encoder;
	private double maxSpeed;
	private double maxRotation; //if maxRotation == minRotation, the jag is unbounded
	private double minRotation;
	private double currentSetpoint; 
	private PIDController pid;
	
	public SafeJaguar(int channel, Encoder e, double p, double i, double d,
			double ms, double mn, double mx, double tolerance) { //tolerance between 0 and 1
		super(channel);
		encoder = e;
		maxSpeed = ms;
		minRotation = mn;
		maxRotation = mx;
		pid = new PIDController(p, i, d, encoder, this);
		pid.setInputRange(minRotation, maxRotation);
		pid.setOutputRange(-maxSpeed, maxSpeed);
		pid.setTolerance(tolerance * 100);
	}
	public SafeJaguar(int channel, Encoder e, double p, double i, double d) {
		super(channel);
		encoder = e;
		maxSpeed = DEFAULT_MAX_SPEED;
		minRotation = DEFAULT_ROTATION;
		maxRotation = DEFAULT_ROTATION;
		pid = new PIDController(p, i, d, encoder, this);
		pid.setContinuous(true);
		pid.setOutputRange(-maxSpeed, maxSpeed);
		pid.setTolerance(DEFAULT_TOLERANCE);
	}
	
	
	public void speedSet(double speed) { //for setting speed
		pid.disable();
		if(speed > 0 && encoder.get() < maxRotation) {
			super.set((speed > maxSpeed) ? maxSpeed : speed);
		} else if(speed < 0 && encoder.get() > minRotation){
			super.set((speed < -maxSpeed) ? -maxSpeed : speed);
		} else {
			super.set(0);
		}
	}
	
	public void goTo(double setpoint) {
		currentSetpoint = (maxRotation == minRotation) ? setpoint :
			((setpoint > maxRotation) ? maxRotation : ((setpoint < minRotation) ? minRotation : setpoint));
		pid.setSetpoint(currentSetpoint);
	}
	
	public void setTolerance(double tolerance) {
		pid.setTolerance(tolerance * 100);
	}
	
	public void holdPosition() {
		currentSetpoint = encoder.get();
		pid.enable();
	}
	
	public boolean atSetpoint() {
		return pid.onTarget();
	}
	
	public void resetEncoder() {
		encoder.reset();
	}
	public void enablePID() {
		pid.enable();
	}
	public void disablePID() {
		pid.disable();
	}
}
