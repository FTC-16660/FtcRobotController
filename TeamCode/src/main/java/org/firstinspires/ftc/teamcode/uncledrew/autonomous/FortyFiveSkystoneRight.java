package org.firstinspires.ftc.teamcode.uncledrew.autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.uncledrew.hardware.DrewDrive;
import org.firstinspires.ftc.teamcode.uncledrew.hardware.Scoop;
import org.firstinspires.ftc.teamcode.uncledrew.hardware.Sensors;

@Autonomous(name = "45 Degree: FortyFiveSkystoneRight", group = "45 Degree")
@Disabled
public class FortyFiveSkystoneRight extends LinearOpMode {

    private DrewDrive robot;
    private Sensors sensors;
    private Scoop scoop;

    @Override
    public void runOpMode() {

        robot = new DrewDrive(this, hardwareMap);
        sensors = new Sensors(hardwareMap);
        scoop = new Scoop(this, hardwareMap);

        // Send telemetry message to signify robot waiting;
        telemetry.addData("Status", "Ready to run");
        telemetry.update();

        // Wait for the game to start (driver presses PLAY)
        waitForStart();

        // Go to first skystone
        robot.moveForward(0.8, 1700);

        int times = 0;

        while (!sensors.isSkystone()) {

            sleep(500);
            robot.moveSide(0.5, 150);

            if (sensors.getDistanceCM() < 2)
                robot.moveForward(-0.3, -20);
            else if (sensors.getDistanceCM() > 7)
                robot.moveForward(0.3, 20);

            times++;

        }

        robot.moveSide(-0.5, -300);
        robot.moveForward(0.5, 400);
        scoop.scoopSetPower(0.6, 'l', 2000);

        robot.moveForward(-0.9, -2300);
        robot.turn(0.5, 90);
        robot.moveForward(-0.9, -9000 - 150 * times);
        robot.turn(0.5, -90);
        scoop.scoop(-0.6, 'l', 50);
        robot.moveSide(0.9, 2000);

    }

}
