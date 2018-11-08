
package org.usfirst.frc1073.robot19_preseason;

import org.usfirst.frc1073.robot19_preseason.XboxController;
import org.usfirst.frc1073.robot19_preseason.commands.*;
import org.usfirst.frc1073.robot19_preseason.commands.AutonomousTools.*;

import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	public XboxController driverControl;
	public XboxController operatorControl;
	
	public JoystickButton RobotTeleInit;
	public JoystickButton visionButton;
	public JoystickButton driverCancel;
	public JoystickButton operatorCancel;   
	
    public OI() {
    	
    	driverControl = new XboxController(0);
    	operatorControl = new XboxController(1);
    	
    	RobotTeleInit = driverControl.start;
    	
    	driverCancel = driverControl.a;
    	operatorCancel = operatorControl.a;

    	visionButton = driverControl.b;
    	visionButton.whenPressed(new VisionCubeTracker());

    }
}


