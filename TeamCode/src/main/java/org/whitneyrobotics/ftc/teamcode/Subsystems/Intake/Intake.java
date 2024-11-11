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
}