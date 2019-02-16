/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.cscore.VideoMode.PixelFormat;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
  
	// Initialize drive variables
	public static WPI_VictorSPX FrontLeftMotor;
	public static WPI_VictorSPX FrontRightMotor;
	public static WPI_VictorSPX BackLeftMotor;
	public static WPI_VictorSPX BackRightMotor;

	// Initialize RobotDrive
	public static RobotDrive driveTrainRobotDrive;

	// Initialize Strafey Bois
	public static Victor StrafeyBoys;

	// Dead zones
	public static Double driveDeadZone = .2;
	public static Double StrafeyBoisDeadZone = .2;

	public static void init() {

		FrontLeftMotor = new WPI_VictorSPX(2); // Define front left drive motor
		FrontRightMotor = new WPI_VictorSPX(4); // Define front right drive motor
		BackLeftMotor = new WPI_VictorSPX(5); // Define back left drive motor
		BackRightMotor = new WPI_VictorSPX(3); // Define back right drive motor

		driveTrainRobotDrive = new RobotDrive(FrontLeftMotor, BackLeftMotor, FrontRightMotor, BackRightMotor); // Define
		// RobotDrive

		StrafeyBoys = new Victor(1); // Define the strafey boys

		//UsbCamera server = CameraServer.getInstance().startAutomaticCapture();
		//server.setVideoMode(PixelFormat.kYUYV, 320, 240, 60);
		
		//server.setResolution(320, 240);
		//server.setFPS(25);
		//CameraServer.getInstance().startAutomaticCapture();
		//CvSink cvsink = CameraServer.getInstance().getVideo();
		//CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 320, 240);
	}
}
