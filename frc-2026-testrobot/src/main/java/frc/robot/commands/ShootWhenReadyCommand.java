package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.FeederSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.VisionSubsystem;

@Override public void initialize() {}
@Override public void execute() {}
@Override public void end(boolean interrupted) {}
@Override public boolean isFinished() { return false; }

public class ShootWhenReadyCommand extends Command {
    private static final double FEEDER_SPEED = 1.0;

    private final FeederSubsystem feeder;
    private final ShooterSubsystem shooter;
    private final VisionSubsystem vision;

    private final Timer timer = new Timer();

    public ShootWhenReadyCommand(FeederSubsystem feeder, ShooterSubsystem shooter, VisionSubsystem vision) {
        this.feeder = feeder;
        this.shooter = shooter;
        this.vision = vision;

    }

    @Override
    public void initialize() {
        timer.start();
        timer.reset();
    }

    @Override
    public void execute() {
        if (vision.isOnTarget() & shooter.isFlywheelAtTargetSpeed() & shooter.isHoodAtTargetAngle()) {
            feeder.setFeederSpeed(FEEDER_SPEED);
            timer.reset();
        } else {
            feeder.setFeederSpeed(0.0);
        }
    }

    @Override
    public void end(boolean interrupted) {
        shooter.setTargetFlywheelSpeed(0.0);
    }
}
