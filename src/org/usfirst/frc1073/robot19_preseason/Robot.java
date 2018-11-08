package org.usfirst.frc1073.robot19_preseason;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.*;
import edu.wpi.first.wpilibj.smartdashboard.*;

import org.usfirst.frc1073.robot19_preseason.*;
import org.usfirst.frc1073.robot19_preseason.subsystems.*;

import com.ctre.phoenix.*;
import edu.wpi.cscore.*;
import org.opencv.*;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	Command autonomousCommand;
	public static Preferences robotPreferences;
	public static OI oi;
	public static robotDrivetrain drivetrain;
	public static String FMS;
	public static SendableChooser<AutoObject> autonomousPosition, autonomousMatchType;
	public AutoObject left, center, right, other, quals, elims, experimental;
	public static boolean clawBool, EncoderBool, EncoderBoolSet, notClear, turn;
	public static CameraServer cameraSwitcher;
	public static boolean selectedCamera;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		//turn is false
		turn = false;
		
		RobotMap.init();
		
		System.out.println("Robot Initializing");
		
		FMS = DriverStation.getInstance().getGameSpecificMessage();

		RobotMap.headingGyro.reset();
				
		robotPreferences = Preferences.getInstance();
		
		drivetrain = new robotDrivetrain();
		oi = new OI();

		FMS = "";
		EncoderBoolSet = false;
		EncoderBool = false;
		notClear = false;

		/* Position Objects 
		left = new AutoObject(1);
		center = new AutoObject(2);
		right = new AutoObject(3);
		other = new AutoObject(4);
		quals = new AutoObject(5);
		elims = new AutoObject(6);
		experimental = new AutoObject(7);*/
		
		/* The Position Chooser 
		autonomousPosition = new SendableChooser<AutoObject>();
		autonomousPosition.addDefault("None", other);
		autonomousPosition.addObject("Left", left);
		autonomousPosition.addObject("Center", center);
		autonomousPosition.addObject("Right", right);
		SmartDashboard.putData("Position", autonomousPosition);*/

		/* The MatchType Chooser 
		autonomousMatchType = new SendableChooser<AutoObject>();
		autonomousMatchType.addDefault("None", other);
		autonomousMatchType.addObject("Qualifications", quals);
		autonomousMatchType.addObject("Eliminations", elims);
		autonomousMatchType.addObject("Experimental", experimental);
		SmartDashboard.putData("Match Type", autonomousMatchType);*/

	}
	

	/**
	 * This function is called when the disabled button is hit.
	 * You can use it to reset subsystems before shutting down.
	 */
	public void disabledInit(){
		Robot.oi.driverControl.rumbleTimeRep(1, 250, 2);
		Robot.oi.driverControl.rumbleTimeRep(.2, 250, 2);
		Robot.oi.driverControl.rumbleTimeRep(1, 250, 2);
		Robot.oi.driverControl.rumbleTimeRep(.2, 250, 2);
		
	}

	public void disabledPeriodic() {
		
	}

	public void autonomousInit() {
		//turn is false
		turn = false;
		
		System.out.println("Auto Setting Up");

		FMS = DriverStation.getInstance().getGameSpecificMessage();

		Scheduler.getInstance().run();
		
		/* instantiate the command used for the autonomous period */
		System.out.println("Auto Starting");
		if (autonomousCommand != null) autonomousCommand.start();
	}
	
	

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	public void teleopInit() {
		if (autonomousCommand != null) autonomousCommand.cancel();
		
		FMS = DriverStation.getInstance().getGameSpecificMessage();
		SmartDashboard.putString("FMS", FMS);
	}
	
	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		FMS = DriverStation.getInstance().getGameSpecificMessage();		
		
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		System.out.println("Test Mode.");
	}
}
