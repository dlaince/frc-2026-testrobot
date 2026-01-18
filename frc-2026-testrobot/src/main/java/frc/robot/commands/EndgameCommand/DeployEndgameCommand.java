package frc.robot.commands.endgame;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ClimbSubsystem;

public class DeployEndgameCommand extends CommandBase {
    private final ClimbSubsystem climb;

    public DeployEndgameCommand(ClimbSubsystem climb) {
        this.climb = climb;
        addRequirements(climb);
    }

    @Override
    public void initialize() {
        climb.deploy();
    }

    @Override
    public boolean isFinished() {
        return climb.isDeployed();
    }
}
