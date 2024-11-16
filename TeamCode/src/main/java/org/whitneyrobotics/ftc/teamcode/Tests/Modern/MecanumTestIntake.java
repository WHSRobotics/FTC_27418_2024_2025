// Written by: Anik Koirala & Ayaan Ahsan
// Package:
package org.whitneyrobotics.ftc.teamcode.Tests.Modern;

// Imports:
import org.whitneyrobotics.ftc.teamcode.Extensions.OpModeEx.OpModeEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

import org.whitneyrobotics.ftc.teamcode.Subsystems.Mecanum.Mecanum;


// Mecanum:
@TeleOp(name = "OpMode-Test-27418-MIC", group = "27418-Tests")
public class MecanumTestIntake extends OpModeEx {
    // Variables (Declaration):
    public Mecanum mecanum_drive;
    public Servo intake_arm;

    // Initialization:
    @Override
    public void initInternal() {
        mecanum_drive = new Mecanum(hardwareMap);
        intake_arm = hardwareMap.get(Servo.class, "intake-arm");
    }

    // Methods:
    @Override
    public void loopInternal() {
        // Logic:
        mecanum_drive.operate(
            gamepad1.RIGHT_STICK_X.value(),
            gamepad1.LEFT_STICK_X.value(),

            gamepad1.LEFT_STICK_Y.value()
        );

        if (gamepad2.RIGHT_TRIGGER.value() == 0) {
            intake_arm.setPosition(0.1);
        } else {
            intake_arm.setPosition(-1);
        }
    }
}