// Written by: Bo-Yun Hsu & Christopher Gholmieh
// Package:
package org.whitneyrobotics.ftc.teamcode.Subsystems.Intake;

// Imports:
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.Servo;

import java.util.HashMap;


// Intake:
public class Intake {
    // Variables (Declaration):
    public CRServo intake_right, intake_left;

    public Servo intake_wrist;
    public double intake_wrist_position = 0.0;
    public static double SCALING_FACTOR = 0.02;

    public State intake_state = State.INACTIVE_STATE;

    // Enumerations:
    public enum State {
        // Enumerations:
        ACTIVE_INVERSE_STATE(create_active_inverse_intake_configuration()),
        ACTIVE_EJECT_STATE(create_active_eject_intake_configuration()),
        INACTIVE_STATE(create_inactive_intake_configuration());

        // Fields:
        public final HashMap<String, Double> servo_configuration;

        // Constructor:
        State(HashMap<String, Double> spinner_configuration) {
            this.servo_configuration = spinner_configuration;
        }

        // Methods:
        private static HashMap<String, Double> create_active_inverse_intake_configuration() {
            HashMap<String, Double> active_inverse_configuration = new HashMap<>();
            active_inverse_configuration.put("intake-right", -1.0);
            active_inverse_configuration.put("intake-left", 1.0);

            return active_inverse_configuration;
        }

        private static HashMap<String, Double> create_active_eject_intake_configuration() {
            HashMap<String, Double> active_eject_configuration = new HashMap<>();
            active_eject_configuration.put("intake-right", 1.0);
            active_eject_configuration.put("intake-left", -1.0);

            return active_eject_configuration;
        }

        private static HashMap<String, Double> create_inactive_intake_configuration() {
            HashMap<String, Double> inactive_configuration = new HashMap<>();
            inactive_configuration.put("intake-right", 0.0);
            inactive_configuration.put("intake-left", 0.0);

            return inactive_configuration;
        }
    }

    // Constructor:
    public Intake(HardwareMap hardwareMap) {
        // Variables (Definition):
        intake_right = hardwareMap.get(CRServo.class, "intake-right");
        intake_left = hardwareMap.get(CRServo.class, "intake-left");

        intake_wrist = hardwareMap.get(Servo.class, "intake-wrist");
        intake_wrist_position = 0.0;

        intake_state = State.INACTIVE_STATE;
    }

    // Methods:
    public void set_intake_state(State intake_state) {
        this.intake_state = intake_state;
    }

    static void run(CRServo intake, double power) {
        intake.setPower(power);
    }

    // Operate:
    public void operate(
        double gamepad_two_right_trigger_down,
        double gamepad_two_left_trigger_down,

        boolean gamepad_two_select,

        double gamepad_two_left_stick_y
    ) {
        // Variables (Assignment):
        double intake_right_power = intake_state.servo_configuration.getOrDefault("intake-right", 0.0);
        double intake_left_power = intake_state.servo_configuration.getOrDefault("intake-left", 0.0);

        // Logic:
        intake_wrist_position += (-gamepad_two_left_stick_y * SCALING_FACTOR);
        intake_wrist_position = Math.max(0.0, Math.min(1.0, intake_wrist_position));

        intake_wrist.setPosition(intake_wrist_position);

//        intake_left.setPower(0.5);
//        intake_right.setPower(-0.5);

        if (gamepad_two_select && gamepad_two_right_trigger_down >= 0.5) {
            //set_intake_state(State.ACTIVE_EJECT_STATE);
            intake_left.setPower(1);
            intake_right.setPower(1);
        } else if (gamepad_two_right_trigger_down >= 0.5) {
            //set_intake_state(State.ACTIVE_INVERSE_STATE);
            intake_left.setPower((-0.5));
            intake_right.setPower((0.5));
        } else {
            //set_intake_state(State.INACTIVE_STATE);
            intake_left.setPower((0));
            intake_right.setPower((0));
        }

//        if (gamepad_two_select) {
//            if (gamepad_two_right_trigger_down >= 0.5 && gamepad_two_left_trigger_down >= 0.5) {
//                set_intake_state(State.INACTIVE_STATE);
//            } else if (gamepad_two_right_trigger_down >= 0.5) {
//                set_intake_state(State.ACTIVE_INVERSE_STATE);
//            } else if (gamepad_two_left_trigger_down >= 0.5) {
//                set_intake_state(State.ACTIVE_EJECT_STATE);
//            }
//        }

//        run(intake_right, intake_right_power);
//        run(intake_left, intake_left_power);
    }
}
