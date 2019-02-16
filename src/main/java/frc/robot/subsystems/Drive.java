package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.ArcadeDrive;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Drive extends Subsystem {
	RobotDrive robotDrive = RobotMap.driveTrainRobotDrive;

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new ArcadeDrive());
	}

	public void arcadeDrive(Joystick joystick) {
		robotDrive.arcadeDrive(joystick);
	}

	public void arcadeDrive(double rawAxis, double rawAxis2) {
		// TODO Auto-generated method stub
		robotDrive.arcadeDrive(rawAxis, rawAxis2);
	}
	
	public void tankDrive(double leftSpeed, double rightSpeed) {
		robotDrive.tankDrive(leftSpeed, rightSpeed);
	}

	public void stop() {
		robotDrive.arcadeDrive(0.0, 0.0);
		robotDrive.tankDrive(0.0, 0.0);
	}
}
