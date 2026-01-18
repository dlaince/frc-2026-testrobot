package frc.robot.autonomous;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;

import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.VisionSubsystem;
import frc.robot.subsystems.FeederSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.commands.TargetWithShooterCommand;
import frc.robot.commands.ShootWhenReadyCommand;

public class AutoRoutine extends SequentialCommandGroup {

    public AutoRoutine(
            DriveSubsystem driveSubsystem,
            VisionSubsystem visionSubsystem,
            FeederSubsystem feederSubsystem,
            ShooterSubsystem shooterSubsystem
    ) {

        addCommands(

            // 1.5 saniye ileri sür
            new RunCommand(
                    () -> driveSubsystem.drive(
                            new ChassisSpeeds(1.0, 0.0, 0.0)
                    ),
                    driveSubsystem
            ).withTimeout(1.5),

            //  Dur
            new RunCommand(
                    () -> driveSubsystem.drive(
                            new ChassisSpeeds(0.0, 0.0, 0.0)
                    ),
                    driveSubsystem
            ).withTimeout(0.1),

            //  Limelight mesafesine göre shooter ayarla
            new TargetWithShooterCommand(
                    shooterSubsystem,
                    visionSubsystem
            ).withTimeout(1.0),

            //  Hazır olunca otomatik ateş et
            new ShootWhenReadyCommand(
                    feederSubsystem,
                    shooterSubsystem,
                    visionSubsystem
            ).withTimeout(2.5),

            // Güvenlik beklemesi
            new WaitCommand(0.1)
        );
    }
}
