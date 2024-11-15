package org.whitneyrobotics.ftc.teamcode.OpMode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class BackupTeleOp extends OpMode {
    DcMotor front_right, front_left, back_right, back_left;
    CRServo intake_right, intake_left;
    Servo intake_wrist, intake_arm;
    @Override
    public void init() {
        front_right = hardwareMap.get(DcMotor.class, "front-right");
        front_left = hardwareMap.get(DcMotor.class, "front-left");
        back_right = hardwareMap.get(DcMotor.class, "back-right");
        back_left = hardwareMap.get(DcMotor.class, "back-left");
        intake_right = hardwareMap.get(CRServo.class, "intake-right");
        intake_left = hardwareMap.get(CRServo.class, "intake-left");
        intake_wrist = hardwareMap.get(Servo.class, "intake-wrist");
        intake_arm = hardwareMap.get(Servo.class, "intake-arm");

        front_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        front_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        back_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        back_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        front_right.setDirection(DcMotor.Direction.REVERSE);
        back_right.setDirection(DcMotor.Direction.REVERSE);

        intake_right.setDirection(CRServo.Direction.REVERSE);

        intake_arm.setPosition(1);
        intake_wrist.setPosition(0);

    }

    void operateMecanum() {
        double right_x = gamepad1.right_stick_x;
        double left_x = gamepad1.left_stick_x;
        double left_y = -gamepad1.left_stick_y;

        double front_right_power = left_y - left_x - right_x;
        double front_left_power = left_y + left_x + right_x;
        double back_right_power = left_y + left_x - right_x;
        double back_left_power = left_y - left_x + right_x;

        double scaling_factor = Math.max(
            Math.abs(front_right_power) +
            Math.abs(front_left_power) +
            Math.abs(back_right_power) +
            Math.abs(back_left_power),
        1);

        front_right.setPower(front_right_power/scaling_factor);
        front_left.setPower(front_left_power/scaling_factor);
        back_right.setPower(back_right_power/scaling_factor);
        back_left.setPower(back_left_power/scaling_factor);
    }
    @Override
    public void loop() {


    }

}
