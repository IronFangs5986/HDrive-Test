package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.MoveStrafeyBoys;

import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

public class StrafeyBoys extends Subsystem {
	private final Victor StrafeyBoys = RobotMap.StrafeyBoys;
	private final Double deadZone = RobotMap.StrafeyBoisDeadZone;

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		setDefaultCommand(new MoveStrafeyBoys());
	}

	public void move(double speed) {
		if (Math.abs(speed) < deadZone) {
			StrafeyBoys.set(0);
		} else {
			StrafeyBoys.set(speed);
		}
	}
}
