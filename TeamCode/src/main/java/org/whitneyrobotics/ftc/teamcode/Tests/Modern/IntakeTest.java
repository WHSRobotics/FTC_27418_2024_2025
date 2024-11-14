// Written by: Christopher Gholmieh & Bo-Yun Hsu
// Package:
package org.whitneyrobotics.ftc.teamcode.Tests.Modern;


// Imports:
import org.whitneyrobotics.ftc.teamcode.Extensions.OpModeEx.OpModeEx;

import org.whitneyrobotics.ftc.teamcode.Subsystems.Intake.Intake;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;


// Intake:
@TeleOp(name = "Intake-Test-27418", group = "27418-Tests")
public class IntakeTest extends OpModeEx {
    // Variables (Declaration):
    public Intake intake;

    // Initialization:
    @Override
    public void initInternal() {
        intake = new Intake(hardwareMap);
    }

    // Loop:
    @Override
    public void loopInternal() {
        gamepad1.Y.onPress(() -> {
            intake.set_intake_state(Intake.State.INACTIVE_STATE);
        });

        gamepad1.X.onPress(() -> {
            intake.set_intake_state(Intake.State.ACTIVE_INVERSE_STATE);
        });

        gamepad1.A.onPress(() -> {
            intake.set_intake_state(Intake.State.ACTIVE_EJECT_STATE);
        });
    }
}
