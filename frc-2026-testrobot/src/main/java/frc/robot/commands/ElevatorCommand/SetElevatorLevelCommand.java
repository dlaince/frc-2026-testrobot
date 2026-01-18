package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ElevatorSubsystem;

public class SetElevatorLevelCommand extends CommandBase {
    private final ElevatorSubsystem elevator;
    private final int level;

    public SetElevatorLevelCommand(ElevatorSubsystem elevator, int level) {
        this.elevator = elevator;
        this.level = level;
        addRequirements(elevator);
    }

    @Override
    public void initialize() {
        elevator.setLevel(level);
    }

    @Override
    public boolean isFinished() {
        return elevator.atTarget();
    }

    @Override
    public void end(boolean interrupted) {}
}
