package org.usfirst.frc1124.subsystems;

public class AllSubsystems {
	public static ArmSubsystem		arm		= new ArmSubsystem();
	public static BeltSubsystem		belts	= new BeltSubsystem();
	public static DriveSubsystem	drive	= new DriveSubsystem();// = new DriveSubsystem(RobotMap.pwmLeftDrive, RobotMap.pwmRightDrive);
	public static LatchSubsystem	latch	= new LatchSubsystem();
	public static ShooterSubsystem	shooter	= new ShooterSubsystem();
	
	public static ExampleSubsystem exampleSubsystem = new ExampleSubsystem();
	
	static {
//		DriveSubsystem.init(RobotMap.pwmLeftDrive, RobotMap.pwmRightDrive);
	}
}
