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

        // Telemetry:
        telemetry.addLine()
            .addData("initialization", "%s", "Robot initialized..");
        telemetry.update();
    }

    @Override
    public void loopInternal() {
        // Variables (Assignment):
        Information information = new Information(
            // Mecanum (Gamepad One):
            gamepad1.RIGHT_STICK_X.value(),

            gamepad1.LEFT_STICK_X.value(),
            gamepad1.LEFT_STICK_Y.value(),

            // Intake (Gamepad Two):
            gamepad2.RIGHT_TRIGGER.value(),
            gamepad2.LEFT_TRIGGER.value(),

            gamepad2.SELECT.value(),

            gamepad2.LEFT_STICK_Y.value()
        );

        // Alliances:
        gamepad1.LEFT_STICK_DOWN.onPress(() -> {
            telemetry.addLine()
                .addData("previous-alliance", "%s", internals.get_alliance().identifier);

            internals.toggle_alliance();

            telemetry.addLine()
                    .addData("current-alliance", "%s", internals.get_alliance().identifier);

            telemetry.update();
        });

        // Logic:
        implementation.update(information);
    }
}