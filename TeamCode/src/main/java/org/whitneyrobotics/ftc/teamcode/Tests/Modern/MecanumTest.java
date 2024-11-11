// Written by: Anik Koirala & Ayaan Ahsan
// Package:
package org.whitneyrobotics.ftc.teamcode.Tests.Modern;

// Imports:
import org.whitneyrobotics.ftc.teamcode.Extensions.OpModeEx.OpModeEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.whitneyrobotics.ftc.teamcode.Subsystems.Mecanum.Mecanum;


// Mecanum:
@TeleOp(name = "OpMode-Test-27418", group = "27418-Tests")
public class MecanumTest extends OpModeEx {
    // Variables (Declaration):
    public Mecanum mecanum_drive;

    // Initialization:
    @Override
    public void initInternal() {
        mecanum_drive = new Mecanum(hardwareMap);
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
    }
}