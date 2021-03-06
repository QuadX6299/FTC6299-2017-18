package org.firstinspires.ftc.teamcode.Autonomous;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.robotcore.external.navigation.Position;
import org.firstinspires.ftc.robotcore.external.navigation.Velocity;
import org.firstinspires.ftc.teamcode.Library.MyOpMode;

@Autonomous(name = "AltBlueRight", group = "Linear Opmode") // Comment this out to add to the opmode list
@Disabled
public class AltBlueRight extends MyOpMode {
    private ElapsedTime runtime = new ElapsedTime();

    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();
        hMap(hardwareMap);
        // Set up our telemetry dashboard
        composeTelemetry();
        // Wait until we're told to go

        waitForStart();
        runtime.reset();
/**---------------------------------------------------------------------------------------------------------------*/
        // Start the logging of measured acceleration
        imu.startAccelerationIntegration(new Position(), new Velocity(), 1000);

        vfValue();

        jewelArm.setPosition(.55);
        jewelHand.setPosition(.4);
        sleep(500);
        jewelArm.setPosition(.15);
        sleep(1000);
        if (jewelColor.red() < jewelColor.blue()) {
            jewelHand.setPosition((.3));
        } else if (jewelColor.red() > jewelColor.blue()) {
            jewelHand.setPosition((.6));
        }
        sleep(500);

        jewelArm.setPosition(.55);
        jewelHand.setPosition(.45);
        sleep(500);
        jewelHand.setPosition(.3);
        sleep(500);
//
        setMotors(-.4, -.4);
        sleep(1000);
        stopMotors();
        sleep(100);

        try {
            turnCorr(0.1,-85, 7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sleep(1000);


        setMotorStrafe(-.4);
        sleep(800);
        stopMotors();

        setMotorStrafe(.4);
        sleep(825);
        stopMotors();

        vfMoveAlt();

        rangeMovePID(6, rangeF);

        manipAuto(-.75);
        sleep(500);

        manipAuto(-.75);

//back up, push forward, back up
        setMotors(-.2, -.2);
        sleep(250);
        stopMotors();

        manip.setPower(-1);
        setMotors(.3, .3);
        sleep(250);
        stopMotors();

        setMotors(-.2, -.2);
        sleep(250);
        stopMotors();
        manip.setPower(0);
        // Turn for second block

        try {
            turnCorr(0.1,85, 7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sleep(1000);

        manip.setPower(1);
        rangeMovePID(3, rangeF);
        sleep(250);
        manip.setPower(0);

        try {
            turnCorr(0.1,-85, 7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sleep(1000);

        rangeMovePID(6, rangeF);
        manipAuto(-.75);

        setMotors(-.2, -.2); //back up, push forward, back up
        sleep(250);
        stopMotors();

        manip.setPower(-1);
        setMotors(.3, .3);
        sleep(250);
        stopMotors();

        setMotors(-.2, -.2);
        sleep(250);
        stopMotors();
        manip.setPower(0);
    }
}