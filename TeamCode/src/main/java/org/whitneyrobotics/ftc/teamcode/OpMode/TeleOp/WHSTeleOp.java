// Written by: Christopher Gholmieh
// Package:
package org.whitneyrobotics.ftc.teamcode.OpMode.TeleOp;

// Imports:
import org.whitneyrobotics.ftc.teamcode.Extensions.OpModeEx.OpModeEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.whitneyrobotics.ftc.teamcode.Subsystems.Implementation;
import org.whitneyrobotics.ftc.teamcode.Subsystems.Information;


// Class:
@TeleOp(name = "WHS-TeleOp", group = "27418")
public class WHSTeleOp extends OpModeEx {
    // Variables (Declaration):
    Implementation implementation;

    // Initialization:
    @Override
    public void initInternal() {
        // Variables (Definition):
        implementation = Implementation.getInstance(hardwareMap);
    }

    @Override
    public void loopInternal() {
        // Variables (Assignment):
        Information information = new Information(
            // Mecanum:
            gamepad1.RIGHT_STICK_X.value(),

            gamepad1.LEFT_STICK_X.value(),
            gamepad1.LEFT_STICK_Y.value()
        );

        // Logic:
        implementation.update(information);
    }
}