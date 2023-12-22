// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.services.Oi;
import frc.robot.subsystem.Drivebase;

public class Tankdrive extends CommandBase {
  /** Creates a new Tankdrive. */

  private final Drivebase drivebase;
  private final Oi oi;
  
  public Tankdrive(Drivebase drivebase, Oi oi) 
  {
    this.drivebase = drivebase;
    this.oi = oi;
    addRequirements(drivebase);
  }

  @Override
  public void initialize() {
    System.out.println("Tankdrive start");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double outputLeft = oi.getLeftY();  
    double outputRight = oi.getRightY();

    
        if(outputLeft > 0)
        {
            outputLeft = Math.pow(outputLeft, 2);
        }
        else
        {
            outputLeft = -Math.abs(Math.pow(outputLeft, 2));
        }
        if(outputRight > 0)
        {
            outputRight = Math.pow(outputRight, 2);
        }
        else
        {
            outputRight = -Math.abs(Math.pow(outputRight, 2));
        }

        drivebase.runMotor(-outputLeft, -outputRight);

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

    System.out.println("Tankdrive end");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
