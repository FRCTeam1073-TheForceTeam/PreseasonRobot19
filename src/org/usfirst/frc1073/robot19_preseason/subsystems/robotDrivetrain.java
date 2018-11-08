package org.usfirst.frc1073.robot19_preseason.subsystems;

import org.usfirst.frc1073.robot19_preseason.Robot;
import org.usfirst.frc1073.robot19_preseason.RobotMap;
import org.usfirst.frc1073.robot19_preseason.commands.*;
import org.usfirst.frc1073.robot19_preseason.subsystems.*;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class robotDrivetrain extends Subsystem {
	    
    private boolean leftInverted = false;
    private boolean rightInverted = false;
    
    public DifferentialDrive difDrive;
    
	public robotDrivetrain() {
	    	
	}
    
    @Override
    public void initDefaultCommand() {
    	setDefaultCommand(new ControllerDifferentialDrive());

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    public void periodic() {
        // Put code here to be run every loop

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    /** Basic non-PID drive 
     * @author Nathaniel
     * @param left Speed
     * @param right Speed
     * @category Drive Command
     */
    public void basicDrive(double left, double right) {
    	
    	if (left > 1) {
    		left = 1;
    	}
    	if (right > 1) {
    		right = 1;
    	}
    	if (left < -1) {
    		left = -1;
    	}
    	if (right < -1) {
    		right = -1;
    	}
    }
    /** Basic drive that stops after a set time
     * @author Eben, Xander, and Nathaniel
     * @param left speed
     * @param right speed
     * @param time in milliseconds (1000 milliseconds in 1 second)
     * @category Drive Command
     */
    public void basicDriveTimed(double left, double right, int time) { 
    	
    	basicDrive(left, right);
    	try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	basicDrive(0, 0);
    }
    
    // @ToDo comment on this 
    public void arcadeDrive(double left, double right) {
        
    	//double tempLeft = cubicScale(deadzone(left,DEADZONE_VALUE),CUBIC_SCALE)-cubicScale(deadzone(right,DEADZONE_VALUE*3),CUB);
    	//double tempRight = cubicScale(deadzone(left,DEADZONE_VALUE),CUBIC_SCALE)+cubicScale(deadzone(right,DEADZONE_VALUE*3),CUB);
    	
    	double tempLeft = left;
    	double tempRight = right;
    	double difL,difR = 0;
    	
    	if(tempLeft > 1)
    	{
    		difL = tempLeft-1;
    		tempRight -= difL;
    		tempLeft = 1;
    	}
    	if(tempRight > 1)
    	{
    		difR = tempRight-1;
    		tempLeft -= difR;
    		tempRight = 1;
    	}
    	if(tempLeft < -1)
    	{
    		difL = tempLeft+1;
    		tempRight -= difL;
    		tempLeft = -1;
    	}
    	if(tempRight < -1)
    	{
    		difR = tempRight+1;
    		tempLeft -= difR;
    		tempRight = -1;
    	}
    	
//    	if(isPrecision)
//    	{
//    		//Should change when testing for max ease for driver to line up
//    		tempLeft /= 3;
//    		tempRight /= 3;
//    	}
    	
    	    	
    		
    }

}

