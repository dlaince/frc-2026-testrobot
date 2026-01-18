package frc.robot.commands.DriveCommand;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.VisionSubsystem;

public class AutoAlignCommand extends CommandBase {
    private final DriveSubsystem drive;
    private final VisionSubsystem vision;

    public AutoAlignCommand(DriveSubsystem drive, VisionSubsystem vision) {
        this.drive = drive;
        this.vision = vision;
        addRequirements(drive);
    }

    @Override
    public void execute() {
        double turn = vision.getTurnCorrection();
        double forward = vision.getDistanceCorrection();
        drive.arcadeDrive(forward, turn);
    }

    @Override
    public boolean isFinished() {
        return vision.isAligned();
    }

    @Override
    public void end(boolean interrupted) {
        drive.stop();
    }
}
