
package org.usfirst.frc1124;

import edu.wpi.first.wpilibj.Joystick;

public class OI {
    // Process operator interface input here.
	public static final Joystick joystick1 = new Joystick(RobotMap.usbJoystick1);
	public static final Joystick joystick2 = new Joystick(RobotMap.usbJoystick2);
	public static final boolean squaredInputs = true;
	
	//all buttonnums are placeholders
	public static final int js1_arcadeButton = 0; //this button is actually useless because this bot has 1 dmode
	public static final int js1_cockButton = 1;
	public static final int js1_fireButton = 2;
	public static final int js1_dryFireButton = 3;
	
	//no js2 buttons--only yaxis and hatswitch
}
/* Control Scheme:
 * 
 * Joystick General:
 * 	Axis 1: l/r 	(X)
 * 	Axis 2: u/d 	(Y)
 * 	Axis 3: Twist 	(Z)
 * 	Axis 4: fwd/back(W)
 * 
 * Joystick 1:
 * 	x/y axes given to arcade drive
 * 	easy button for cock
 * 	trigger for fire
 * 
 * Joystick 2:
 * 	y axis given to belt height (fwd = up, back = down)
 * 	hat switch given to belt speed (fwd = in, back = out)
 * 
 */