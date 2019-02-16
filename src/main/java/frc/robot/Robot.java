/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.StrafeyBoys;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot {
	Command autonomousCommand;

	public static OI oi;
	public static Drive driveTrain;
	public static StrafeyBoys strafeyBoys;
	Tracking trackingCam;

	SendableChooser chooser = new SendableChooser<>();

	private int mode = 0;

	public static String GameData = "UUU";

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		RobotMap.init();

		driveTrain = new Drive();
		strafeyBoys = new StrafeyBoys();
		oi = new OI();

	
		trackingCam = new Tracking();
		//trackingCam.setSerOutEnable(true);
		trackingCam.startCameraStream1();
		
		chooser = new SendableChooser();
		chooser.addDefault("Do absolutely nothing like Mr. Horwath said", 1);
		chooser.addObject("Straight", 2);
		chooser.addObject("Middle Switch", 3);
		chooser.addObject("Middle Scale", 4);
		chooser.addObject("Right Switch", 5);
		SmartDashboard.putData("Automous Selector", chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
	 */
	@Override
	public void disabledInit() {

	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString code to get the
	 * auto name from the text box below the Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons to
	 * the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		GameData = DriverStation.getInstance().getGameSpecificMessage();
		mode = (int) chooser.getSelected();
		// if (mode == 1) {
		// autonomousCommand = (Command) new DoNothingAuto();
		// } else if (mode == 2) {
		// autonomousCommand = (Command) new AutoStraight();
		// } else if (mode == 3) {
		// autonomousCommand = (Command) new MiddleSwitch();
		// } else if (mode == 4) {
		// autonomousCommand = (Command) new MiddleScale();
		// } else if (mode == 5) {
		// autonomousCommand = (Command) new SwitchRightAuto();
		// }

		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
	
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();

		
		//System.out.println(trackingCam.getCamMode()+" "+trackingCam.isVisionOnline()+" "+trackingCam.getTx()+" "+trackingCam.getTy()+" "+trackingCam.getTa()+" "+trackingCam.getTv());
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
