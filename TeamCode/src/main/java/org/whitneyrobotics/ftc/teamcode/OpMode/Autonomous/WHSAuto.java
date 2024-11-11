package org.whitneyrobotics.ftc.teamcode.OpMode.Autonomous;

import com.qualcomm.hardware.lynx.LynxModule;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.whitneyrobotics.ftc.teamcode.Extensions.OpModeEx.OpModeEx;
import org.whitneyrobotics.ftc.teamcode.Extensions.TelemetryPro.AutoSetupTesting.Tests;
import org.whitneyrobotics.ftc.teamcode.Roadrunner.drive.IntoTheDeepMecanumDrive;
import org.whitneyrobotics.ftc.teamcode.Subsystems.RobotImplOld;

@Autonomous(name = "AutoWHS")
public class WHSAuto extends OpModeEx {
    IntoTheDeepMecanumDrive drive;
    RobotImplOld robot;

    @Override
    public void initInternal() {
        RobotImplOld.init(hardwareMap);
        robot = RobotImplOld.getInstance();
        telemetryPro.useTestManager()
                .addTest("Gamepad 1 Initialization", () -> Tests.assertGamepadSetup(gamepad1, "Gamepad 1"))
                .addTest("Gamepad 2 Initialization", () -> Tests.assertGamepadSetup(gamepad2, "Gamepad 2"))
                .addTest("Battery voltage test", () -> Tests.assertBatteryCharged(hardwareMap.get(LynxModule.class, "Control Hub")));

        drive = new IntoTheDeepMecanumDrive(hardwareMap);
    }

    @Override
    protected void loopInternal() {


        while (drive.isBusy()) {
            drive.update();
            telemetryPro.update();
        }
    }
}