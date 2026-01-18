package frc.robot.commands.outtake;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.OuttakeSubsystem;

public class OuttakeStopCommand extends CommandBase {
    private final OuttakeSubsystem outtake;

    public OuttakeStopCommand(OuttakeSubsystem outtake) {
        this.outtake = outtake;
        addRequirements(outtake);
    }

    @Override
    public void initialize() {
        outtake.stop();
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
