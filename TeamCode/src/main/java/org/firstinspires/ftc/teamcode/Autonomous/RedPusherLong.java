package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.quadx.Libraries.MyOpMode;

/**
 * Created by jspspike on 1/15/17.
 */

@Autonomous(name="Red Pusher Long", group="Red")
public class RedPusherLong extends MyOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        hardwareMap();
        initServos();
        initSensors();

        resetGyro();

        while (!gamepad1.a && !opModeIsActive()) {
            telemetry.addData("gyro", getGyroYaw());
            telemetry.update();
            idle();
        }
        telemetry.addData("Gyro", "Completed");
        telemetry.update();

        double flyPow = .68;
        int moveVal = (encoderPow() + 3180) * -1;
        double turnVal;

        waitForStart();

        turnVal = getGyroYaw();


        telemetry.addData("MoveVal", moveVal);
        telemetry.update();

        floorL.enableLed(true);
        floorR.enableLed(true);


        moveTo(-.25, moveVal, .6, 1.5);
        arcTurnCorr(-.5, turnVal * -1 + .7);
        untilWhiteRange(-.35, -.15, 15, 800, 3800);
        if (!fail)
            moveTo(.2, 140, .6, 1.5);
        pressBlue();

        untilWhiteRange(.35, .15, 15, -1600, -5500);
        if (!fail)
            moveTo(.2, -220, .6, 1.5);
        setManip(0);
        pressBlue();

        arcTurn(.45, -75, false);
        setFly(flyPow);
        moveTo(.2, 1500);
        delay(1000);
        door.setPosition(DOOR_OPEN);
        delay(1100);
        moveTo(.2, 1600, 6);
    }
}
