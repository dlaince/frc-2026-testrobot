package frc.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;

public class DriveCommand extends CommandBase {
    private final DriveSubsystem drive;
    private double forward, rotation;

    public DriveCommand(DriveSubsystem drive) {
        this.drive = drive;
        addRequirements(drive);
    }

    public void setInput(double forward, double rotation) {
        this.forward = forward;
        this.rotation = rotation;
    }

    @Override
    public void execute() {
        drive.arcadeDrive(forward, rotation);
    }

    @Override
    public void end(boolean interrupted) {
        drive.stop();
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
