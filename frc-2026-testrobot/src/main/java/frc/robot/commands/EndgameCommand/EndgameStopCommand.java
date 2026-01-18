package frc.robot.commands.endgame;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimbSubsystem;

public class EndgameStopCommand extends CommandBase {
    private final ClimbSubsystem endgame;

    public EndgameStopCommand(ClimbSubsystem climb) {
        this.climb = climb;
        addRequirements(climb);
    }

    @Override
    public void initialize() {
        climb.stop();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
