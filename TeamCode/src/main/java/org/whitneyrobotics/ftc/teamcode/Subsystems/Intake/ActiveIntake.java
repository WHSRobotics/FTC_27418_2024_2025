package org.whitneyrobotics.ftc.teamcode.Subsystems.Intake;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class ActiveIntake {
    public CRServo intake_right, intake_left;
    public Servo intake_wrist, intake_arm;

    public double DegreeOfFreedom = 0.2;
    public enum WristPositions {
        INTAKING(0.2),
        OUTTAKING(0.0),
        STOWED(0.5);

        public double position;
        WristPositions(double position) {
            this.position = position;
        }
    }

    public enum ArmPositions {
        INTAKING(0.0),
        OUTTAKING(0.5),
        STOWED(1.0);

        public double position;
        ArmPositions(double position) {
            this.position = position;
        }
    }

    public enum IntakePower {
        INTAKING(1.0),
        OUTTAKING(-1.0),
        STOPPED(0.0);

        public double power;
        IntakePower(double power) {
            this.power = power;
        }
    }

    public ActiveIntake(HardwareMap hm) {
        hm.get(CRServo.class, "intake-right");
        hm.get(CRServo.class, "intake-left");
        hm.get(Servo.class, "intake-wrist");
    }

    public void initialize() {
        setIntakePower(0);
        intake_wrist.setPosition(0.5);
        intake_arm.setPosition(1);
    }

    public void setIntakePower(double power) {
        intake_right.setPower(power);
        intake_left.setPower(-power);
    }

    public double getIntakePower() {
        return intake_right.getPower();
    }

    public void setWristAngle(double angle) {
        intake_wrist.setPosition(angle);
    }

    public double getWristAngle() {
        return intake_wrist.getPosition();
    }

    public void setArmAngle(double angle) {
        intake_arm.setPosition(angle);
    }

    public double getArmAngle() {
        return intake_arm.getPosition();
    }

    public void EqualizeIntakeAngle() {
        setWristAngle(DegreeOfFreedom-getArmAngle());
    }
}
