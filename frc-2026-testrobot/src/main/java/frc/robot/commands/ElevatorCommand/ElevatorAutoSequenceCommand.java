package frc.robot.commands.elevator;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ElevatorSubsystem;

public class ElevatorAutoSequenceCommand extends SequentialCommandGroup {

    
    public ElevatorAutoSequenceCommand(ElevatorSubsystem elevator, int targetLevel) {
             
        addCommands(
            new ZeroElevatorCommand(elevator),                 
            new SetElevatorLevelCommand(elevator, targetLevel), 
            new HoldElevatorCommand(elevator)                  
        );
    }
