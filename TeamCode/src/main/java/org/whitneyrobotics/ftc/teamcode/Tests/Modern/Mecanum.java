// Written by: Anik Koirala & Ayaan Ahsan
// Package:
package org.whitneyrobotics.ftc.teamcode.Tests.Modern;

// Imports:
import org.whitneyrobotics.ftc.teamcode.Extensions.OpModeEx.OpModeEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;


// Mecanum:
@TeleOp(name = "OpMode-Test-27418", group = "27418-Tests")
public class Mecanum extends OpModeEx {
    // Variables (Declaration):
    DcMotor front_right, front_left, back_right, back_left;

    // Constructor:
    @Override
    public void initInternal() {
        // Variables (Definition):
        front_right = hardwareMap.get(DcMotor.class, "front-right");
        front_left = hardwareMap.get(DcMotor.class, "front-left");

        back_right = hardwareMap.get(DcMotor.class, "back-right");
        back_left = hardwareMap.get(DcMotor.class, "back-left");

        // Initialization:
        front_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        front_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        back_right.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        back_left.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        front_right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        front_left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

        back_right.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        back_left.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    // Methods:
    public double calculate_scaling_factor(
        double right_x,

        double left_x,
        double left_y
    ) {
        return Math.max(
            Math.abs(right_x) +
            Math.abs(left_x) +
            Math.abs(left_y),
        1);
    }

    @Override
    public void loopInternal() {
        // Variables (Assignment):
        double right_x = gamepad1.RIGHT_STICK_X.value();

        double left_x = gamepad1.LEFT_STICK_X.value() * 1.05;
        double left_y = -gamepad1.LEFT_STICK_Y.value();

        double greatest_common_factor = calculate_scaling_factor(
            right_x,
            left_x,
            left_y
        );

        // Logic:
        front_right.setPower((left_x - left_y + right_x) / greatest_common_factor);
        front_left.setPower((left_x + left_y + right_x) / greatest_common_factor);

        back_right.setPower((left_x - left_y - right_x) / greatest_common_factor);
        back_left.setPower((left_x + left_y - right_x) / greatest_common_factor);
    }
}