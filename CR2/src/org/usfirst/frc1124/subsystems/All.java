package org.usfirst.frc1124.subsystems;

public class All {
	public static DriveSubsystem drive = new DriveSubsystem();// = new DriveSubsystem(RobotMap.pwmLeftDrive, RobotMap.pwmRightDrive);
	public static Shooter shooter = new Shooter();
	public static Latch latch = new Latch();
	public static Arm arm = new Arm();
	public static Belts belts = new Belts();
	
	public static ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	
	static {
//		DriveSubsystem.init(RobotMap.pwmLeftDrive, RobotMap.pwmRightDrive);
	}
}
