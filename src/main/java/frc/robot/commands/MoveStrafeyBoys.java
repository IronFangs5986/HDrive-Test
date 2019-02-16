package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class MoveStrafeyBoys extends Command {
	public MoveStrafeyBoys() {
		requires(Robot.strafeyBoys);
	}

	protected void execute() {
		Robot.strafeyBoys.move(Robot.oi.joystick3.getRawAxis(0));
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
