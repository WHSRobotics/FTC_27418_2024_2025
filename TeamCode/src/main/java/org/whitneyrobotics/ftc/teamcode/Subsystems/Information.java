// Written by: Christopher Gholmieh
// Package:
package org.whitneyrobotics.ftc.teamcode.Subsystems;


// Information:
public class Information {
    // Variables (Declaration):
    // Mecanum:
    double gamepad_right_stick_x;

    double gamepad_left_stick_x;
    double gamepad_left_stick_y;

    // Constructor:
    public Information(
        double gamepad_right_stick_x,

        double gamepad_left_stick_x,
        double gamepad_left_stick_y
    ) {
        // Variables (Definition):
        // Mecanum:
        this.gamepad_right_stick_x = gamepad_right_stick_x;

        this.gamepad_left_stick_x = gamepad_left_stick_x;
        this.gamepad_left_stick_y = gamepad_left_stick_y;
    }
}
