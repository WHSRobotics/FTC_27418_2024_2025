// Written by: Christopher Gholmieh & Bo-Yun Hsu
// Package:
package org.whitneyrobotics.ftc.teamcode.Tests.Modern;


// Imports:
import org.whitneyrobotics.ftc.teamcode.Extensions.OpModeEx.OpModeEx;

import org.whitneyrobotics.ftc.teamcode.Subsystems.Intake.Intake;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.CRServoImpl;


// Intake:
@TeleOp(name = "SimpleInt-Test-27418", group = "27418-Tests")
public class SimpleIntakeTest extends OpMode {
    // Variables (Declaration):
    public CRServo intake_left, intake_right;

    // Initialization:
    @Override
    public void init() {
        intake_left = hardwareMap.get(CRServo.class, "intake-left");
        intake_right = hardwareMap.get(CRServo.class, "intake-right");
    }

    // Loop:
    @Override
    public void loop() {
            intake_left.setPower(1);//(-gamepad1.left_stick_x.value());
            intake_right.setPower(1);//(-gamepad1.RIGHT_STICK_X.value());
    }
}
