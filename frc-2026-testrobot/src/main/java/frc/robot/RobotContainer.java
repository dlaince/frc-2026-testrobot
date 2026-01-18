package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

import frc.robot.subsystems.*;
import frc.robot.commands.*;

public class RobotContainer {

    // Controllers
    private final XboxController driverController =
            new XboxController(Constants.OperatorConstants.DRIVER_CONTROLLER_PORT);

    private final XboxController operatorController =
            new XboxController(Constants.OperatorConstants.OPERATOR_CONTROLLER_PORT);

    // Subsystems
    private final DriveSubsystem driveSubsystem = new DriveSubsystem();
    private final VisionSubsystem visionSubsystem = new VisionSubsystem();
    private final ElevatorSubsystem elevatorSubsystem = new ElevatorSubsystem();
    private final OuttakeSubsystem outtakeSubsystem = new OuttakeSubsystem();
    private final ClimberSubsystem climberSubsystem = new ClimberSubsystem();
    private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
    private final FeederSubsystem feederSubsystem = new FeederSubsystem();
    private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();

    public RobotContainer() {
        configureDefaultCommands();
        configureButtonBindings();
    }

    // ---------------- DEFAULT COMMANDS ----------------
    private void configureDefaultCommands() {
        driveSubsystem.setDefaultCommand(
                new DriveCommand(driveSubsystem, driverController)
        );

        elevatorSubsystem.setDefaultCommand(
                new HoldElevatorCommand(elevatorSubsystem)
        );

        climberSubsystem.setDefaultCommand(
                new HoldClimberCommand(climberSubsystem)
        );
    }

    // ---------------- BUTTON BINDINGS ----------------
    private void configureButtonBindings() {

        /* ---------- DRIVER ---------- */

        // Auto align
        new JoystickButton(driverController, Constants.ButtonConstants.AUTO_ALIGN)
                .whileTrue(new AlignRobotToShootCommand(
                        driveSubsystem,
                        visionSubsystem,
                        () -> driverController.getLeftX(),
                        () -> driverController.getLeftY()
                ));

        // Climber – driver
        new JoystickButton(driverController, Constants.ButtonConstants.CLIMB_UP)
                .whileTrue(new ClimbUpCommand(climberSubsystem))
                .onFalse(new ClimbStopCommand(climberSubsystem));

        new JoystickButton(driverController, Constants.ButtonConstants.CLIMB_DOWN)
                .whileTrue(new ClimbDownCommand(climberSubsystem))
                .onFalse(new ClimbStopCommand(climberSubsystem));

        /* ---------- OPERATOR ---------- */

        // Climber zero
        new JoystickButton(operatorController, Constants.ButtonConstants.CLIMBER_ZERO)
                .onTrue(new ZeroClimberCommand(climberSubsystem));

        // Intake
        new JoystickButton(operatorController, Constants.ButtonConstants.INTAKE_IN)
                .whileTrue(new IntakeInCommand(intakeSubsystem))
                .onFalse(new IntakeStopCommand(intakeSubsystem));

        new JoystickButton(operatorController, Constants.ButtonConstants.INTAKE_OUT)
                .whileTrue(new IntakeOutCommand(intakeSubsystem))
                .onFalse(new IntakeStopCommand(intakeSubsystem));

        // Elevator levels
        new JoystickButton(operatorController, Constants.ButtonConstants.ELEVATOR_L1)
                .onTrue(new SetElevatorLevelCommand(elevatorSubsystem, 1));

        new JoystickButton(operatorController, Constants.ButtonConstants.ELEVATOR_L2)
                .onTrue(new SetElevatorLevelCommand(elevatorSubsystem, 2));

        new JoystickButton(operatorController, Constants.ButtonConstants.ELEVATOR_L3)
                .onTrue(new SetElevatorLevelCommand(elevatorSubsystem, 3));

        new JoystickButton(operatorController, Constants.ButtonConstants.ELEVATOR_ZERO)
                .onTrue(new ZeroElevatorCommand(elevatorSubsystem));

        // Outtake commands
        new JoystickButton(operatorController, Constants.ButtonConstants.SHOOT)
                .whileTrue(new FenderShootCommand(feederSubsystem, shooterSubsystem))
                .onFalse(new OuttakeStopCommand(outtakeSubsystem));

        new JoystickButton(operatorController, Constants.ButtonConstants.SHOOT_WHEN_READY)
                .whileTrue(new ShootWhenReadyCommand(feederSubsystem, shooterSubsystem, visionSubsystem));

        new JoystickButton(operatorController, Constants.ButtonConstants.TARGET_SHOOTER)
                .whileTrue(new TargetWithShooterCommand(shooterSubsystem, visionSubsystem));
    }

    // ---------------- AUTONOMOUS ----------------
    public Command getAutonomousCommand() {

        return new AutoRoutine(
                driveSubsystem,
                visionSubsystem,
                elevatorSubsystem,
                outtakeSubsystem
        );
    }
}

