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

    // Intake:
    double gamepad_two_right_trigger_down;
    double gamepad_two_left_trigger_down;

    boolean gamepad_two_select;

    double gamepad_two_right_stick_x;
    double gamepad_two_left_stick_y;
    double gamepad_two_left_stick_x;

    // Constructor:
    public Information(
        // Mecanum:
        double gamepad_right_stick_x,

        double gamepad_left_stick_x,
        double gamepad_left_stick_y,

        // Intake:
        double gamepad_two_right_trigger_down,
        double gamepad_two_left_trigger_down,

        boolean gamepad_two_select,

        double gamepad_two_right_stick_x,
        double gamepad_two_left_stick_y,
        double gamepad_two_left_stick_x
    ) {
        // Variables (Definition):
        // Mecanum:
        this.gamepad_right_stick_x = gamepad_right_stick_x;

        this.gamepad_left_stick_x = gamepad_left_stick_x;
        this.gamepad_left_stick_y = gamepad_left_stick_y;

        // Intake:
        this.gamepad_two_right_trigger_down = gamepad_two_right_trigger_down;
        this.gamepad_two_left_trigger_down = gamepad_two_left_trigger_down;

        this.gamepad_two_select = gamepad_two_select;

        this.gamepad_two_right_stick_x = gamepad_two_right_stick_x;
        this.gamepad_two_left_stick_y = gamepad_two_left_stick_y;
        this.gamepad_two_left_stick_x = gamepad_two_left_stick_x;
    }
}
