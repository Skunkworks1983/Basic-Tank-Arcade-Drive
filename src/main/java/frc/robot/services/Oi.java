// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.services;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.constants.Constants;

/** Add your docs here. */
public class Oi {

   public static Oi Instance;
   
   Joystick leftStick;
   Joystick rightStick;
   Joystick buttonStick;

   JoystickButton option1;

   private Oi() {

    Instance = this;

    leftStick = new Joystick(Constants.JoystickPorts.LEFT_JOY_STICK_PORT);
    rightStick = new Joystick(Constants.JoystickPorts.RIGHT_JOY_STICK_PORT);
    buttonStick = new Joystick(Constants.JoystickPorts.BUTTON_STICK_PORT);

    option1 = new JoystickButton(buttonStick, 2);

   }
   

   public double getLeftY() {
    return leftStick.getY();
}

public double getRightY() {
    return rightStick.getY();
}

public double getLeftX() {
    return leftStick.getX();
}

public double getRightX() {
    return rightStick.getX();
}

public boolean turing() {

    return option1.getAsBoolean();
}

public static Oi GetInstance() {

    if (Instance == null) {
        Instance = new Oi();
    }

    return Instance;

}

}
