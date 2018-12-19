package org.usfirst.frc1073.robot19_preseason.commands;

import org.usfirst.frc1073.robot19_preseason.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class NewCommand extends Command{
	
	private final double deadZoneDiameter=0.05;
	
	public NewCommand() {
		requires(Robot.drivetrain);
	}
	
	protected void initialize() {
		Robot.drivetrain.difDrive.tankDrive(0,0);
	}
	
	protected void execute() {
		/**RAWAXIS LIST
		 * 1 - Left X
		 * 2 - Left Y
		 * 3 - Triggers
		 * 4 - Right X
		 * 5 - Right Y
		 * 6 - DPad left/right
		 **/
		
		//Continuous Gearshift
		double multiplier=Robot.oi.driverControl.getRawAxis(5)*0.5+0.5;
		double fwd=convertDeadzone(Robot.oi.driverControl.getRawAxis(2),deadZoneDiameter);
		double rot=convertDeadzone(Robot.oi.driverControl.getRawAxis(1),deadZoneDiameter);
		Robot.drivetrain.difDrive.arcadeDrive(fwd*multiplier,rot);
	}
	
	public double convertDeadzone(double in,double zoneWidth) {
		return (Math.abs(in)<=zoneWidth?0:in);
	}
	
	protected boolean isFinished() {
		return Robot.oi.driverCancel.get()||Robot.oi.operatorCancel.get();
	}
}
