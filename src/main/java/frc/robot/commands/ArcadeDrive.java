package frc.robot.commands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.constants.Constants;
import frc.robot.services.Oi;
import frc.robot.subsystem.Drivebase;


public class ArcadeDrive extends CommandBase {
    private final Drivebase drivebase;
    private final Oi oi;

    private double targetHeading;

    private PIDController drivePidController = new PIDController(Constants.Drivebase.ARCADE_DRIVE_KP, 0, Constants.Drivebase.ARCADE_DRIVE_KD);

    public ArcadeDrive(Drivebase drivebase, Oi oi) {

        this.drivebase = drivebase;
        this.oi = oi;

        addRequirements(drivebase);
    }

    @Override
    public void initialize() {
        targetHeading = drivebase.getHeading();
        System.out.println("Arcadedrive beginning");

        System.out.println("turning to game piece init!!!");
    }

    @Override
    public void execute() {

        double leftX = oi.getLeftX();
        double rightY = -oi.getRightY();

        double oldX = leftX;
        double oldY = rightY;

        leftX = (Math.pow(Math.abs(leftX), 2.2)) * (oldX < 0 ? -1 : 1);
        rightY = (Math.pow(Math.abs(rightY), 2)) * (oldY < 0 ? -1 : 1);

        double heading = drivebase.getHeading();

        double turnThrottle;
        turnThrottle = leftX * Constants.Drivebase.TURN_THROTTLE_MULTIPLIER;

        double leftSpeed = rightY + turnThrottle;
        double rightSpeed = rightY - turnThrottle;

        leftSpeed = MathUtil.clamp(leftSpeed, -1, 1);
        rightSpeed = MathUtil.clamp(rightSpeed, -1, 1);

        drivebase.runMotor(leftSpeed, rightSpeed);
        
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("Arcade drive end Interrupted " + interrupted);
    }
}