// Written by: Bo-Yun Hsu & Christopher Gholmieh
// Package:
package org.whitneyrobotics.ftc.teamcode.Subsystems.Intake;

// Imports:
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.CRServo;


// Intake:
public class Intake {
    // Variables (Declaration):
    public CRServo intake_right, intake_left;

    // Constructor:
    public Intake(HardwareMap hardwareMap) {
        // Variables (Definition):
        intake_right = hardwareMap.get(CRServo.class, "intake-right");
        intake_left = hardwareMap.get(CRServo.class, "intake-left");
    }

    // Methods:
    public void run_intake(double power) {
        // Logic:
        run(intake_right, -power);
        run(intake_left, power);
    }

    static void run(CRServo intake, double power) {
        intake.setPower(power);
    }

    // Operate:
    public void operate(
        double gamepad_two_right_trigger_down,
        double gamepad_two_left_trigger_down
    ) {
        if (gamepad_two_right_trigger_down >= 0.5) {
            run_intake(1.0);

            return;
        }

        if (gamepad_two_left_trigger_down >= 0.5) {
            run_intake(0.0);
        }
    }
}