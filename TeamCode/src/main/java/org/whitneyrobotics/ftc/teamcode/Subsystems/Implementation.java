// Written by: Christopher Gholmieh
// Package:
package org.whitneyrobotics.ftc.teamcode.Subsystems;


// Imports:
import org.whitneyrobotics.ftc.teamcode.Subsystems.Mecanum.Mecanum;
import org.whitneyrobotics.ftc.teamcode.Subsystems.Information;
import com.qualcomm.robotcore.hardware.HardwareMap;


// Implementation:
public class Implementation {
    // Variables (Declaration):
    private static Implementation singleton_instance;

    // Subsystems:
    public Mecanum mecanum_drive;

    // Constructor:
    private Implementation(HardwareMap hardware_map) {
        mecanum_drive = new Mecanum(hardware_map);
    }

    private Implementation() {}

    // Methods:
    public static Implementation getInstance(HardwareMap hardware_map) {
        if (singleton_instance == null) {
            singleton_instance = new Implementation(hardware_map);
        }

        return singleton_instance;
    }

    public static Implementation getInstance() {
        if (singleton_instance == null) {
            singleton_instance = new Implementation();
        }

        return singleton_instance;
    }

    public void update(
        Information information
    ) {
        mecanum_drive.operate(
            information.gamepad_right_stick_x,

            information.gamepad_left_stick_x,
            information.gamepad_left_stick_y
        );
    }
}