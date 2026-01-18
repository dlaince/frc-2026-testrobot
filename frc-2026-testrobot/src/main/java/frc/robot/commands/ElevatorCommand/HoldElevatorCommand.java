package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class HoldElevatorCommand extends CommandBase {
    private final ElevatorSubsystem elevator;

    public HoldElevatorCommand(ElevatorSubsystem elevator) {
        this.elevator = elevator;
        addRequirements(elevator);
    }

    @Override
    public void execute() {
        elevator.holdPosition();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
