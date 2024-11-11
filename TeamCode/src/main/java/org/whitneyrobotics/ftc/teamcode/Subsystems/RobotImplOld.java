package org.whitneyrobotics.ftc.teamcode.Subsystems;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.whitneyrobotics.ftc.teamcode.Constants.Alliance;
import org.whitneyrobotics.ftc.teamcode.Roadrunner.drive.IntoTheDeepMecanumDrive;
import org.whitneyrobotics.ftc.teamcode.Roadrunner.drive.StandardTrackingWheelLocalizer;

import java.util.ArrayList;

public class RobotImplOld {

    public static Pose2d poseMemory = new Pose2d(0, 0, 0);

    private static RobotImplOld instance = null;

    public Alliance alliance = Alliance.RED;

    public RobotImplOld() {
    }

    public static RobotImplOld getInstance(){
        return instance;
    }

    public static RobotImplOld getInstance(HardwareMap hardwareMap){
        init(hardwareMap);
        return instance;

    }

    public static void init(HardwareMap hardwareMap) {
        instance = new RobotImplOld(hardwareMap);
    }

    public IntoTheDeepMecanumDrive drive;

    public StandardTrackingWheelLocalizer localizer;

    private RobotImplOld(HardwareMap hardwareMap) {
        drive = new IntoTheDeepMecanumDrive(hardwareMap);
        localizer = new StandardTrackingWheelLocalizer(hardwareMap, new ArrayList<>(), new ArrayList<>());

    }

    public void switchAlliance(){
        alliance = alliance == Alliance.RED ? Alliance.BLUE : Alliance.RED;
    }

    public void teleOpInit(){
        Pose2d poseMemory = localizer.getPoseEstimate();

        drive.setPoseEstimate(poseMemory);


    }

    public void update(){
        drive.update();
    }
}
