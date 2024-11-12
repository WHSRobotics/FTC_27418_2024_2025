// Written by: Christopher Gholmieh
// Package:
package org.whitneyrobotics.ftc.teamcode.Subsystems;


public class Internals {
    // Fields:
    public Alliance alliance;

    // Enumerations:
    public enum Alliance {
        // Enumerations
        BLUE_ALLIANCE("blue-alliance"),
        RED_ALLIANCE("red-alliance");

        // Fields:
        public final String identifier;

        // Constructor:
        Alliance(String identifier) {
            this.identifier = identifier;
        }
    }

    // Constructor:
    public Internals(Alliance alliance) {
        this.alliance = alliance;
    }

    public Internals() {
        this.alliance = Alliance.BLUE_ALLIANCE;
    }

    // Methods:
    public Alliance get_alliance() {
        return alliance;
    }

    public void set_alliance(Alliance alliance) {
        this.alliance = alliance;
    }

    public void toggle_alliance() {
        switch (this.alliance) {
            case BLUE_ALLIANCE:
                this.alliance = Alliance.RED_ALLIANCE;
            case RED_ALLIANCE:
                this.alliance = Alliance.BLUE_ALLIANCE;
        }
    }
}