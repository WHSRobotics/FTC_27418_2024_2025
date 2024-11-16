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
                // Mecanum (Gamepad One):
                gamepad1.RIGHT_STICK_X.value(),

                gamepad1.LEFT_STICK_X.value(),
                gamepad1.LEFT_STICK_Y.value(),

                // Intake (Gamepad Two):
                gamepad2.RIGHT_TRIGGER.value(),
                gamepad2.LEFT_TRIGGER.value(),

                gamepad2.SELECT.value(),

                gamepad2.RIGHT_STICK_X.value(),
                gamepad2.LEFT_STICK_Y.value(),
                gamepad2.LEFT_STICK_X.value()
        );

        // Telemetry:
        // Alliance:
        telemetryPro.addData("current-alliance", internals.get_alliance().identifier);

        // Mecanum:
        telemetryPro.addData("g1-right-stick-x", gamepad1.RIGHT_STICK_X.value());
        telemetryPro.addData("g1-left-stick-x", gamepad1.LEFT_STICK_X.value());
        telemetryPro.addData("g1-left-stick-y", gamepad1.LEFT_STICK_Y.value());

        // Intake:
        telemetryPro.addData("g2-right-trigger", gamepad2.RIGHT_TRIGGER.value());
        telemetryPro.addData("g2-left-trigger", gamepad2.LEFT_TRIGGER.value());
        telemetryPro.addData("g2-select", gamepad2.SELECT.value());
        telemetryPro.addData("g2-right-stick-x", gamepad2.RIGHT_STICK_X.value());
        telemetryPro.addData("g2-left-stick-y", gamepad2.LEFT_STICK_Y.value());

        // Update:
        telemetryPro.update();

        // Alliances:
        gamepad1.LEFT_STICK_DOWN.onPress(() -> {
            internals.toggle_alliance();

            telemetryPro.addData("current-alliance", internals.get_alliance().identifier);
            telemetryPro.update();
        });

        // Logic:
        implementation.update(information);
    }
}
