package org.usfirst.frc1124.ub.support;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;

public class UBMethods {
	private static double hdrive_X;
	private static double hdrive_Y;
	private static double hdrive_Z;
	private static SpeedController hdrive_hmotor;
	public static void hdrive(RobotDrive drive, int pwm_hmotor, Joystick js, boolean squared) {
//		hdrive_L = js.getY() * (js.getY()) + js.getZ();
//		hdrive_R = js.getY() - js.getZ();
//		hdrive_H = js.getX();
//		hdrive_hmotor = new Jaguar(pwm_hmotor);
//		drive.setLeftRightMotorOutputs((hdrive_L > 1) ? 1 : ((hdrive_L < -1) ? -1 : hdrive_L),
//				(hdrive_R > 1) ? 1 : ((hdrive_R < -1) ? -1 : hdrive_R));
//		hdrive_hmotor.set((hdrive_H > 1) ? 1 : ((hdrive_H < -1) ? -1 : hdrive_H));
		hdrive_X = js.getX();
		hdrive_X *= (squared ? hdrive_X : 1);
		hdrive_Y = js.getX();
		hdrive_Y *= (squared ? hdrive_Y : 1);
		hdrive_Z = js.getX();
		hdrive_Z *= (squared ? hdrive_Z : 1);
		hdrive_hmotor = new Jaguar(pwm_hmotor);
		drive.setLeftRightMotorOutputs(
				(hdrive_Y + hdrive_Z > 1) ? 1 : ((hdrive_Y + hdrive_Z < -1) ? -1 : hdrive_Y + hdrive_Z),
				(hdrive_Y - hdrive_Z > 1) ? 1 : ((hdrive_Y - hdrive_Z < -1) ? -1 : hdrive_Y - hdrive_Z));
		hdrive_hmotor.set((hdrive_X > 1) ? 1 : ((hdrive_X < -1) ? -1 : hdrive_X));
		
	}
	
	private static int hatTransform_x;
	private static int hatTransform_y;
	public static int hatTransform(double xin, double yin) {
		hatTransform_x = (int) (xin + 1);
		hatTransform_y = (int) (yin + 1);
		return hatTransform_x * 3 + hatTransform_y;
		/* 
		 * 0:SW
		 * 1:W
		 * 2:NW
		 * 3:S
		 * 4:rest
		 * 5:N
		 * 6:SE
		 * 7:E
		 * 8:NE
		 */
	}
}
