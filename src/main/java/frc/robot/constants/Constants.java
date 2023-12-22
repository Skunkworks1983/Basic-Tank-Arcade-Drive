// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.constants;

/** Add your docs here. */
public class Constants {

    public static class Drivebase
    {
        public static final int LEFT_MOTOR_1 = 3;
        public static final int RIGHT_MOTOR_1 = 1;
        public static final int LEFT_MOTOR_2 = 4;
        public static final int RIGHT_MOTOR_2 = 2;

        public static final int LEFT_DIRECTION = 1; //Wheels turn in correct direction
        public static final int RIGHT_DIRECTION = -1;
        public static final double WHEEL_DIAMETER = 0.5;
        public static final double GEAR_RATIO = 8.4586;


        public static final int TICKS_PER_MOTOR_REV = 2048;
        public static final double TICKS_PER_FOOT =
                (TICKS_PER_MOTOR_REV * GEAR_RATIO) / (WHEEL_DIAMETER * Math.PI);


                public static final double SLOW_MODE_RATIO = .225;
        public static final double OLD_GEAR_RATIO = 10.71;
        public static final double kTrackwidthMeters = .38;
        public static final double FEET_PER_METER=3.28084;
        public static final int TICKS_PER_ROTATION=2048;
        public static final double DISTANCE_KP = 0.05;
        public static final double ROTATE_KP = 0.0026/* 16,17,18 */;
        public static final double ROTATE_KF = 0.04;
        public static final double ANGLE_KP = 0.003;
        public static final double ANGLE_KD = 0.005;
        public static final double DRIVEBASE_KF = 0.08;
        public static final double THRESHOLD_ROTATE = 2.5;
        public static final int DRIVE_OUT_OF_COMMUNITY = -9;
        public static final double TURN_THROTTLE_MULTIPLIER = 0.7;
        public static final double ARCADE_DRIVE_KP = 0.007;
        public static final double ARCADE_DRIVE_KD = 0;
        public static final double ARCADE_DRIVE_LEFTX_DEADBAND = 0.01;
    }

    public static class JoystickPorts
    {
        public static final int LEFT_JOY_STICK_PORT = 1;
        public static final int RIGHT_JOY_STICK_PORT = 2;
        public static final int BUTTON_STICK_PORT = 0;
    }

}
