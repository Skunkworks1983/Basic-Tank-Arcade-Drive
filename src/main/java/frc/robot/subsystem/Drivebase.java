// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystem;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.Tankdrive;
import frc.robot.constants.Constants;
import frc.robot.services.Oi;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.I2C;




public class Drivebase extends SubsystemBase {
  /** Creates a new Drivebase. */

  public Command Tankdrive = new Tankdrive(this, Oi.Instance);


  private static Drivebase OGDrivebase;

  TalonFX leftMotor1 = new TalonFX(Constants.Drivebase.LEFT_MOTOR_1);
  TalonFX leftMotor2 = new TalonFX(Constants.Drivebase.LEFT_MOTOR_2);
  TalonFX rightMotor1 = new TalonFX(Constants.Drivebase.RIGHT_MOTOR_1);
  TalonFX rightMotor2 = new TalonFX(Constants.Drivebase.RIGHT_MOTOR_2);
  public AHRS gyro = new AHRS(I2C.Port.kMXP);

  public Drivebase() {
    rightMotor1.setInverted(true);
    rightMotor2.setInverted(true);
    rightMotor2.follow(rightMotor1);
    leftMotor2.follow(leftMotor1);
  }

  public void runMotor(double turnSpeedLeft, double turnSpeedRight) {
    leftMotor1.set(TalonFXControlMode.PercentOutput, turnSpeedLeft);
    rightMotor1.set(TalonFXControlMode.PercentOutput, turnSpeedRight);
  }
  
private final double TicksPerFoot =
Constants.Drivebase.TICKS_PER_MOTOR_REV * Constants.Drivebase.GEAR_RATIO/
        (Constants.Drivebase.WHEEL_DIAMETER * Math.PI);


  public double getPosLeft() {
    return leftMotor1.getSelectedSensorPosition() / TicksPerFoot;
}


public double getPosRight() {
    return -(rightMotor1.getSelectedSensorPosition() / TicksPerFoot);
}

public double getHeading() {

    return gyro.getAngle();

}

public static Drivebase GetDrivebase() {

  if (OGDrivebase == null) {
      OGDrivebase = new Drivebase();
  }

  return OGDrivebase;

}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}