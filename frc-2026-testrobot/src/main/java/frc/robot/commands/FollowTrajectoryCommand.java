package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.common.control.Trajectory;

@Override public void initialize() {}
@Override public void execute() {}
@Override public void end(boolean interrupted) {}
@Override public boolean isFinished() { return false; }

public class FollowTrajectoryCommand extends Command {
    private final DrivetrainSubsystem drivetrain;

    private final Trajectory trajectory;

    public FollowTrajectoryCommand(DrivetrainSubsystem drivetrain, Trajectory trajectory) {
        this.drivetrain = drivetrain;
        this.trajectory = trajectory;

    }

    @Override
    public void initialize() {
        drivetrain.getFollower().follow(trajectory);
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.getFollower().cancel();
    }

    @Override
    public boolean isFinished() {
        return drivetrain.getFollower().getCurrentTrajectory().isEmpty();
    }
}
