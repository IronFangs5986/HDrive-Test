package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class ArcadeDrive extends Command {

	public ArcadeDrive() {
		requires(Robot.driveTrain);
	}

	protected void execute() {
		//Robot.driveTrain.arcadeDrive(Robot.oi.joystick1);
		Double rawTurn = Robot.oi.joystick3.getRawAxis(2);
		double maxTurn = .7;
		double turnSpeed;
		if (Math.abs(rawTurn) >= maxTurn) {
			if (rawTurn > 0) {
				turnSpeed = maxTurn;
			} else {
				turnSpeed = -maxTurn;
			}
		} else {
			turnSpeed = rawTurn;
		}
		//Robot.driveTrain.arcadeDrive(Robot.oi.joystick3.getRawAxis(1), turnSpeed);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
