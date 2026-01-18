package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class ZeroElevatorCommand extends CommandBase {
    private final ElevatorSubsystem elevator;

    public ZeroElevatorCommand(ElevatorSubsystem elevator) {
        this.elevator = elevator;
        addRequirements(elevator);
    }

    @Override
    public void initialize() {
        elevator.zero();
    }

    @Override
    public boolean isFinished() {
        return elevator.isZeroed();
    }
}
