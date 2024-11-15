// Written by: Christopher Gholmieh
// Package:`
package org.whitneyrobotics.ftc.teamcode.Subsystems.Outtake;

// Imports:
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.CRServo;

import java.util.HashMap;


// Outtake:
public class Outtake {
    // Constructor:
    public Outtake(HardwareMap hardware_map) {};

    // Methods:
    public void operate() {}
}

//public class Outtake {
//    // Variables (Declaration):
//    public CRServo outtake_right_spinner, outtake_left_spinner;
//    public State outtake_state;
//
//    // Enumerations:
//    public enum State {
//        // Enumerations:
//        INACTIVE_STATE(create_inactive_spinner_configuration()),
//        ACTIVE_STATE(create_active_spinner_configuration());
//
//        // Fields:
//        public final HashMap<String, Double> spinner_configuration;
//
//        // Constructor:
//        State(HashMap<String, Double> spinner_configuration) {
//            this.spinner_configuration = spinner_configuration;
//        }
//
//        // Methods:
//        private static HashMap<String, Double> create_inactive_spinner_configuration() {
//            HashMap<String, Double> inactive_spinner_configuration = new HashMap<>();
//            inactive_spinner_configuration.put("outtake-right-spinner", 1.0);
//            inactive_spinner_configuration.put("outtake-left-spinner", -1.0);
//
//            return inactive_spinner_configuration;
//        }
//
//        private static HashMap<String, Double> create_active_spinner_configuration() {
//            HashMap<String, Double> active_spinner_configuration = new HashMap<>();
//            active_spinner_configuration.put("outtake-right-spinner", 0.0);
//            active_spinner_configuration.put("outtake-left-spinner", 0.0);
//
//            return active_spinner_configuration;
//        }
//    }
//
//    // Constructor:
//    public Outtake(HardwareMap hardware_map) {
//        // Variables (Definition):
//        outtake_right_spinner = hardware_map.get(CRServo.class, "outtake-right-spinner");
//        outtake_left_spinner = hardware_map.get(CRServo.class, "outtake-left-spinner");
//
//        outtake_state = State.INACTIVE_STATE;
//    }
//
//    // Methods:
//    public void toggle_outtake_state() {
//        switch (outtake_state) {
//            case INACTIVE_STATE:
//                outtake_state = State.ACTIVE_STATE;
//            case ACTIVE_STATE:
//                outtake_state = State.INACTIVE_STATE;
//        }
//    }
//
//    public void set_outtake_state(State outtake_state) {
//        this.outtake_state = outtake_state;
//    }
//
//    public static void run(CRServo outtake_spinner, double power) {
//        outtake_spinner.setPower(power);
//    }
//
//    public void operate() {
//        // Variables (Assignment):
//        double outtake_right_spinner_power = outtake_state.spinner_configuration.getOrDefault("outtake-right-spinner", 0.0);
//        double outtake_left_spinner_power = outtake_state.spinner_configuration.getOrDefault("outtake-left-spinner", 0.0);
//
//        // Logic:
//        run(outtake_right_spinner, outtake_right_spinner_power);
//        run(outtake_left_spinner, outtake_left_spinner_power);
//    }
//}