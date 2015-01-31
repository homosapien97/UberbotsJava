package org.usfirst.frc1124.ub.support;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.PIDController;

public class SafeJaguar extends Jaguar{
	private Encoder encoder;
	private double maxSpeed; //positive. only for speed control, does not affect PID
	private double maxRotation;
	private double minRotation;
	private boolean bounded;
	private double holdingPos;
	private PIDController pid;
	
	public SafeJaguar(int channel, Encoder e, double p, double i, double d,
			double ms, double mn, double mx) {
		super(channel);
		bounded = true;
		encoder = e;
		maxSpeed = ms;
		minRotation = mn;
		maxRotation = mx;
		pid = new PIDController(p, i, d, encoder, this);
	}
	public SafeJaguar(int channel, Encoder e, double p, double i, double d,
			double ms) {
		super(channel);
		bounded = false;
		encoder = e;
		maxSpeed = ms;
		minRotation = 0;
		maxRotation = 0;
		pid = new PIDController(p, i, d, encoder, this);
	}
	
	public void set(double speed) { //for setting speed
		if(speed > 0) {
			super.set((speed > maxSpeed) ? maxSpeed : speed);
		} else {
			super.set((speed < -maxSpeed) ? -maxSpeed : speed);
		}
	}
	public boolean goTo(double pos, double tolerance) { //for setting position
		if(bounded) {
			pid.setSetpoint((pos > maxRotation) ? maxRotation : ((pos < minRotation) ? minRotation : pos));
		} else {
			pid.setSetpoint(pos);
		}
		pid.enable();
		if(Math.abs(pos - encoder.get()) < tolerance) {
			pid.disable();
			return true;
		}
		return false;
	}
	public void hold() { //holds until PID is disabled.
		holdingPos = encoder.get();
		if(bounded) {
			pid.setSetpoint((holdingPos > maxRotation) ? maxRotation : 
				((holdingPos < minRotation) ? minRotation : holdingPos));
		} else {
			pid.setSetpoint(holdingPos);
		}
		pid.enable();
	}
	public boolean at(double pos, double tolerance) {
		return Math.abs(pos - encoder.get()) < tolerance;
	}
	
	public void disablePID() {
		pid.disable();
	}
}
