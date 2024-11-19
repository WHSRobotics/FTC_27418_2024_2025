// Written by Bryan Hsu
// Package:
package org.whitneyrobotics.ftc.teamcode.Subsystems.Mecanum;

// Imports:
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class FieldCentricMecanum {
    DcMotor frontRight, frontLeft, backRight, backLeft;
    IMU imu;
    public FieldCentricMecanum(HardwareMap hardwareMap) {

        // Initialize motors
        frontRight = hardwareMap.get(DcMotor.class, "front-right");
        frontLeft = hardwareMap.get(DcMotor.class, "front-left");
        backRight = hardwareMap.get(DcMotor.class, "back-right");
        backLeft = hardwareMap.get(DcMotor.class, "back-left");

        // Reverse opposite motors
        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);

        // Brake when no input
        frontRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        frontLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        backLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        // IMU stuff
        imu = hardwareMap.get(IMU.class, "imu");
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.DOWN,
                RevHubOrientationOnRobot.UsbFacingDirection.FORWARD));
        imu.initialize(parameters);

    }

    public void operate(double gamepad_right_stick_x, double gamepad_left_stick_x, double gamepad_left_stick_y, boolean gamepad_options) {
        double x=gamepad_left_stick_x;
        double y=-gamepad_left_stick_y;
        double r=gamepad_right_stick_x;

        // Reset reference angle
        if (gamepad_options) {
            imu.resetYaw();
        }

        double botHeading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
        double rotX = x * Math.cos(-botHeading) - y * Math.sin(-botHeading);
        double rotY = x * Math.sin(-botHeading) + y * Math.cos(-botHeading);

        rotX = rotX * 1.1;

        double denominator = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(r), 1);
        double frontLeftPower = (rotY + rotX + r) / denominator;
        double backLeftPower = (rotY - rotX + r) / denominator;
        double frontRightPower = (rotY - rotX - r) / denominator;
        double backRightPower = (rotY + rotX - r) / denominator;

        frontLeft.setPower(frontLeftPower);
        backLeft.setPower(backLeftPower);
        frontRight.setPower(frontRightPower);
        backRight.setPower(backRightPower);
    }

}
