package frc.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import frc.robot.Robot;
import frc.robot.RobotMap;

public class Drivetrain {

    TalonSRX frontLeftTalon;
    TalonSRX frontRightTalon;
    TalonSRX backLeftTalon;
    TalonSRX backRightTalon;

    public Drivetrain() {
        frontLeftTalon = new TalonSRX(RobotMap.FRONTLEFT_TALON);
        frontRightTalon = new TalonSRX(RobotMap.FRONTRIGHT_TALON);
        backLeftTalon = new TalonSRX(RobotMap.BACKLEFT_TALON);
        backRightTalon = new TalonSRX(RobotMap.BACKRIGHT_TALON); 
    }

    public void drive(double throttle, double turn) {
        double left = throttle - turn;
        double right = throttle + turn;
        frontLeftTalon.set(ControlMode.PercentOutput, left);
        frontRightTalon.set(ControlMode.PercentOutput, right);
        backLeftTalon.follow(frontLeftTalon);
        backRightTalon.follow(frontRightTalon);
        
    }
}
