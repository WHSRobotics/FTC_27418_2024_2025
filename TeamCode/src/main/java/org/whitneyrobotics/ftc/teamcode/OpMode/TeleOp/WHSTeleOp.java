// Written by: Christopher Gholmieh
// Package:
package org.whitneyrobotics.ftc.teamcode.OpMode.TeleOp;

// Imports:
import org.whitneyrobotics.ftc.teamcode.Extensions.OpModeEx.OpModeEx;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.whitneyrobotics.ftc.teamcode.Subsystems.Implementation;
import org.whitneyrobotics.ftc.teamcode.Subsystems.Information;
import org.whitneyrobotics.ftc.teamcode.Subsystems.Internals;


// Class:
@TeleOp(name = "WHS-TeleOp", group = "27418")
public class WHSTeleOp extends OpModeEx {
    // Variables (Declaration):
    Implementation implementation;
    Internals internals;

    // Initialization:
    @Override
    public void initInternal() {
        // Variables (Definition):
        implementation = Implementation.getInstance(hardwareMap);
        internals = new Internals();
    }

    @Override
    public void loopInternal() {
        // Variables (Assignment):
        Information information = new Information(
            // Mecanum:
            gamepad1.RIGHT_STICK_X.value(),

            gamepad1.LEFT_STICK_X.value(),
            gamepad1.LEFT_STICK_Y.value(),

            // Intake:
            gamepad2.RIGHT_TRIGGER.value(),
            gamepad2.LEFT_TRIGGER.value()
        );

        // Alliances:

        // Logic:
        implementation.update(information);
    }
}