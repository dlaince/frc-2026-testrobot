package frc.robot.commands.outtake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.OuttakeSubsystem;

public class OuttakeShootCommand extends CommandBase {
    private final OuttakeSubsystem outtake;

    public OuttakeShootCommand(OuttakeSubsystem outtake) {
        this.outtake = outtake;
        addRequirements(outtake);
    }

    @Override
    public void execute() {
        outtake.shoot();
    }

    @Override
    public void end(boolean interrupted) {
        outtake.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
