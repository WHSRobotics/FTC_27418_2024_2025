// Written by Anik Koirala & Ayaan Ahsan
// Package:
package org.whitneyrobotics.ftc.teamcode.Subsystems.Mecanum;

// Imports:
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.DcMotor;


// Mecanum:
public class Mecanum {
    // Variables (Declaration):
    DcMotor front_right, front_left, back_right, back_left;
    private double turn_scaling = 0.5;

    public static double conversion_ratio = 0.25;

    // Constructor:
    public Mecanum(HardwareMap hardware_map) {
        // Variables (Definition):
        front_right = hardware_map.get(DcMotor.class, "front-right");
        front_left = hardware_map.get(DcMotor.class, "front-left");

        back_right = hardware_map.get(DcMotor.class, "back-right");
        back_left = hardware_map.get(DcMotor.class, "back-left");

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

    public void operate(
        double gamepad_right_stick_x,

        double gamepad_left_stick_x,
        double gamepad_left_stick_y
    ) {
        // Variables (Assignment):
        double right_x = gamepad_right_stick_x * turn_scaling;

        double left_x = gamepad_left_stick_x;
        double left_y = -gamepad_left_stick_y;

        double greatest_common_factor = calculate_scaling_factor(
            right_x,
            left_x,
            left_y
        );

        // Logic:
        front_right.setPower((left_x - left_y + right_x) / greatest_common_factor);
        front_left.setPower((left_x + left_y + right_x) / greatest_common_factor * conversion_ratio);

        back_right.setPower((left_x - left_y - right_x) / greatest_common_factor * conversion_ratio);
        back_left.setPower((left_x + left_y - right_x) / greatest_common_factor * conversion_ratio);
    }
}