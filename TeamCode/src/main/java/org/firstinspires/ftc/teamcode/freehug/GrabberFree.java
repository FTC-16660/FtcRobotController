package org.firstinspires.ftc.teamcode.freehug;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.hardware.BaseHardware;

public class GrabberFree extends BaseHardware {

    private CRServo rotator;
    private Servo grabberRight;
    private CRServo grabberTilt;

    //servo variables
    private static final double HAND_CLOSED_R = 0;
    private static final double HAND_OPEN_R = 0.4;


    public GrabberFree(OpMode opMode, HardwareMap hwmap) {

        super(opMode);

        initServo(hwmap);

    }

    public GrabberFree(LinearOpMode opMode, HardwareMap hwmap) {

        super(opMode);

        initServo(hwmap);

    }

    private void initServo(HardwareMap HWMap) {
        grabberRight = HWMap.get(Servo.class, "grabberRight");
        grabberTilt = HWMap.get(CRServo.class, "grabberTilt");
        rotator = HWMap.get(CRServo.class, "rotator");
        grabberRight.setPosition(HAND_CLOSED_R);
    }

    public void handInTheAir() {
        rotator.setPower(-0.9);
    }
    public void lowerHand() {
        rotator.setPower(0.9);
    }
    public void restElbow() {
        rotator.setPower(0);
    }

    public void tiltHandUp() { grabberTilt.setPower(1); }
    public void tiltHandDown() { grabberTilt.setPower(-1); }
    public void restWrist() {
        grabberTilt.setPower(0);
    }

    public void openHand() {
        grabberRight.setPosition(HAND_OPEN_R);
    }

    public void closeHand() {
        grabberRight.setPosition(HAND_CLOSED_R);
    }

}
